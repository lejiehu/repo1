package com.itheima.test;

import com.itheima.service.IAccountService;
import com.itheima.serviceimpl.AccountServiceimpl;
import com.itheima.springConfig.springConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.swing.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = springConfiguration.class)
public class springTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void testtranFer(){

        accountService.tranFer();


    }
}
