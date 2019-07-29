package com.lixijie.springdemo.serviceimpl;

import com.lixijie.springdemo.service.UserServices;
import com.lixijie.springdemo.mapper.UserMapper;
import com.lixijie.springdemo.pojo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserServices {

    @Autowired
    private UserMapper userMapper;

    @Override
    public void addUser(UserDao user) {
        this.userMapper.insertUser(user);
    }

    @Override
    @Cacheable(value = "user")  //对当前查询对象进行缓存
    public List<UserDao> findUser() {
    	System.out.println("--------------------------------");
        return this.userMapper.selectUser();
    }
}
