package com.itheima.dao;

import com.itheima.domain.User;

import java.util.List;

public interface IUserDao {
    //查询所有
    List<User> findAll();

    //保存用户
    void saveUser(User user);
    //删除用户
    void deleteUser(int Userid);

    //更新用户信息
    void updateUser(User user);

//    根据id查询
    User findId(Integer Userid);
    //模糊查询
    List<User> findLike(String username);

    //查询所有并且获取id值
    List<User> findAllid();
}
