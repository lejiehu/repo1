package com.itheima.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


//切面类
public class TransManager {

    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


//开启事务 之前通知

    public void open() throws SQLException {
        TransactionSynchronizationManager.initSynchronization();
        Connection connection = DataSourceUtils.getConnection(dataSource);
        connection.setAutoCommit(false);
    }

    //提交事务 之后通知
    public void Transactioncommit() throws SQLException {
        //从当前线程中获取同一个连接
        Connection connection = DataSourceUtils.getConnection(dataSource);
        connection.commit();

    }

    //回滚职务  异常通知

    public void TransactionException() throws SQLException {

        Connection connection = DataSourceUtils.getConnection(dataSource);
        connection.rollback();

    }

    //关闭事务 最终通知
    public void TransactionClose() throws SQLException {
        Connection connection = DataSourceUtils.getConnection(dataSource);
        connection.setAutoCommit(true);
        TransactionSynchronizationManager.clearSynchronization();

    }

//    环绕通知
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {


        TransactionSynchronizationManager.initSynchronization();
        Connection connection = DataSourceUtils.getConnection(dataSource);



        try {
            //开启事务 之前通知


            connection.setAutoCommit(false);
            //执行方法
            joinPoint.proceed();

            //提交事务 之后通知
            connection.commit();
        } catch (Exception e) {
            //回滚职务  异常通知
            connection.rollback();
        }finally {
            //关闭事务 最终通知

            connection.setAutoCommit(true);
            TransactionSynchronizationManager.clearSynchronization();
        }


    }
}
