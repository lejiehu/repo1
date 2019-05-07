package com.itheima;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Jdbcc3p0 {
    public static void main(String[] args) throws SQLException {
        //创建连接池对象
        DataSource ds = new ComboPooledDataSource();
        //获取连接对象
        Connection con = ds.getConnection();
        System.out.println(con);
    }
}
