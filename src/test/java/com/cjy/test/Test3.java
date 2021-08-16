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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test3 {
    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = ssfb.build(inputStream);
        sqlSession = factory.openSession();
    }

    @Test
    public void findByEmpno() throws IOException {
        Emp findByEmpno = sqlSession.selectOne("findByEmpno", 7935);
        System.out.println(findByEmpno);
    }

    @Test
    public void findEmpByDeptnoAndSal(){
        Map<String,Object> map = new HashMap<>();
        map.put("deptno", 20);
        map.put("sal", 1500.0);
        List<Emp> list = sqlSession.selectList("findEmpByDeptnoAndSal", map);
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    public void findEmpByDeptnoAndSal2(){
        Emp emp = new Emp();
        emp.setDEPTNO(30);
        emp.setSAL(1000.0);

        List<Emp> list = sqlSession.selectList("findEmpByDeptnoAndSal2", emp);
        for (Emp emp1 : list) {

            System.out.println(emp1);
        }
    }

    @After
    public void release(){
        sqlSession.close();
    }



























}
