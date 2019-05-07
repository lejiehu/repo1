package com.itheima.Transactionfig;

import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;




//声明式事务的配置类
public class Transaction {


    @Bean
    public DataSourceTransactionManager createTransaction(DataSource dataSource){

        return new DataSourceTransactionManager(dataSource);
    }
}
