package com.itheima.springConfig;


import com.itheima.Transactionfig.Transaction;
import com.itheima.jdbcConfig.jdbcProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.EnableTransactionManagement;


//设定该类为配置类的注解
@Configuration
//设置扫描包的注解
@ComponentScan("com.itheima")
//导入其他的配置类
@Import({jdbcProperties.class, Transaction.class})
//jdbc配置文件
@PropertySource("jdbc.properties")
//声明spring支持注解的配置
@EnableTransactionManagement
public class springConfiguration {

}
