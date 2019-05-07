package com.itheima.test;

import com.itheima.dao.IUserDao;
import com.itheima.domain.User;
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
import java.util.List;


public class MybatisTest {
    private InputStream in;
    private SqlSession sqlSession;
    private IUserDao dao;


    @Before
    public void init() throws Exception {
        //加载主配置文件
        in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建构造者
        SqlSessionFactoryBuilder session = new SqlSessionFactoryBuilder();
        //创建工厂类
        SqlSessionFactory factory = session.build(in);
        //工厂类创建SqlSession对象
        sqlSession = factory.openSession(true);
        //创建IUserDao接口的代理对象
        dao = sqlSession.getMapper(IUserDao.class);

    }

    @After
    public void destroy() throws Exception {
        sqlSession.commit();
        sqlSession.close();
        in.close();
    }
    //查询所有
    @Test
    public void testFindAll() {
        List<User> users = dao.findAll();
        for (User user : users) {
            System.out.println(user);
        }
    }
    //保存用户
    @Test
    public void testSaveUser(){
        //需要传入一个User对象 并赋值
        User user = new User();
        user.setUsername("张三");
        user.setAddress("北京1");
        user.setSex("男");
        user.setBirthday(new Date());
        System.out.println("保存前"+user);
        dao.saveUser(user);
        System.out.println("保存后"+user);
    }

    //删除用户
    @Test
    public void testdeleteUser(){
        dao.deleteUser(53);
    }

    //更新用户
    @Test
    public void testupdateUser(){
        User user = new User();
        user.setId(48);
        user.setUsername("翠花");
        user.setAddress("上海");
        user.setSex("女");
        user.setBirthday(new Date());
        dao.updateUser(user);

    }
    //根据id查询
    @Test
    public void testFindid(){
        User user = dao.findId(48);
        System.out.println(user);
    }

    //模糊查询
    @Test
    public void testFindlike(){
        List<User> users = dao.findLike("%王%");
        System.out.println(users);
    }
}
