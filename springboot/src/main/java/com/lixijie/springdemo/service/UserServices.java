package com.lixijie.springdemo.service;

import com.lixijie.springdemo.pojo.UserDao;

import java.util.List;

public interface UserServices {

    void addUser(UserDao user);
    List<UserDao>  findUser();
}
