package com.itheima.serviceimpl;

import com.itheima.dao.IAccountDao;
import com.itheima.daoimpl.AccountDaoimpl;
import com.itheima.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@Service("accountService")
@Transactional
public class AccountServiceimpl implements IAccountService {
    @Autowired
    private IAccountDao accountDao;
    @Autowired
    private DataSource dataSource;



    //转账
    public void tranFer() {


        //开启事务管理器  为了将获到的连接和当前线程绑定

//        TransactionSynchronizationManager.initSynchronization();
//        //获取连接
//        Connection connection = DataSourceUtils.getConnection(dataSource);

//        try {
//            //开启事务
//            connection.setAutoCommit(false);

        //减钱
        accountDao.tomoney();
        int i =1/0;
        //加钱
        accountDao.inmoney();

//            //提交事务
//            connection.commit();
//        } catch (SQLException e) {
//            e.printStackTrace();
//            try {
//                connection.rollback();
//            } catch (SQLException e1) {
//                e1.printStackTrace();
//            } finally {
//                try {
//                    connection.setAutoCommit(true);
//                    TransactionSynchronizationManager.clearSynchronization();
//                } catch (SQLException e1) {
//                    e1.printStackTrace();
//                }
//
//            }
//        }

    }
}
