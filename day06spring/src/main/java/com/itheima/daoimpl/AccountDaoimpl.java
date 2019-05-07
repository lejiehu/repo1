package com.itheima.daoimpl;

import com.itheima.dao.IAccountDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("accountDao")
public class AccountDaoimpl implements IAccountDao{

    @Autowired
    private JdbcTemplate jdbcTemplate;



    //减钱
    public void tomoney() {
        String sql = "update account set money=money-? where name=?";
        jdbcTemplate.update(sql,1,"jack");
    }
    //加钱
    public void inmoney() {
        String sql = "update account set money=money+? where name=?";
        jdbcTemplate.update(sql,1,"rose");
    }
}
