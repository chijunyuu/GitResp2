package com.cjy.test;

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
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test4 {
    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
        InputStream inputStream = Resources.getResourceAsStream("sqlMapConfig.xml");
        SqlSessionFactory factory = ssfb.build(inputStream);
        sqlSession = factory.openSession(true); //设置事务自动提交
    }

    @Test
    public void testInsert() throws IOException {
        Emp emp = new Emp(null,"哈萨克","SALESMAN",7893,new Date(),3100.0,200.0,50);

        int addEmp = sqlSession.insert("addEmp", emp);
        // 设置事务手动提交
        sqlSession.commit();//增删改都要提交事务，默认回滚事务
        System.out.println(addEmp);
    }

    @Test
    public void testUpdate() throws IOException {
        Emp emp = new Emp();
        emp.setEMPNO(4);
        emp.setENAME("张三");
        int updateEmp = sqlSession.insert("updateEmp", emp);
        System.out.println(updateEmp);
    }

    @Test
    public void deleteEmp (){
        int deleteEmp = sqlSession.delete("deleteEmp", 4);
        System.out.println(deleteEmp);
    }


    @After
    public void release(){
        sqlSession.close();
    }



























}
