package com.cjy.test;

import com.cjy.pojo.Dept;
import com.cjy.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Test2 {
    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = ssfb.build(inputStream);
        sqlSession = factory.openSession();
    }

    @Test
    public void testSelectOne() throws IOException {

        Emp emp = sqlSession.selectOne("findOne");

        System.out.println(emp);

    }

    @Test
    public void selectAllEmp(){
        List<Emp> list = sqlSession.selectList("findAllEmp");
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    public void findEmpMap(){
        Map<Integer, Emp> map = sqlSession.selectMap("findEmpMap", "EMPNO");

        Set<Integer> integers = map.keySet();
        for (Integer integer : integers) {
            System.out.println(integer+" " +map.get(integer));
        }
    }

    @After
    public void release(){
        sqlSession.close();
    }



























}
