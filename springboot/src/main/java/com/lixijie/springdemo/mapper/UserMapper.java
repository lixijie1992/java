package com.lixijie.springdemo.mapper;

import com.lixijie.springdemo.pojo.UserDao;

import java.util.List;

public interface UserMapper {
    /**
     * ������Ա
     * @param user
     */
    void insertUser(UserDao user);
    List<UserDao> selectUser();
}
