package com.lixijie.springdemo.controller;

import com.lixijie.springdemo.pojo.UserDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * SpringBoot整合jsp页面
 * @date  2019-05-24
 * @author lixijie
 */
@Controller
public class UserController {
    @RequestMapping("/getUser")
    public String showUser(Model model) {
        List<UserDao> list = new ArrayList<UserDao>();
        list.add(new UserDao("1", "zs", 0, 35));
        list.add(new UserDao("2", "ls", 0, 25));
        list.add(new UserDao("3", "ks", 1, 15));
        list.add(new UserDao("4", "js", 1, 45));
        list.add(new UserDao("5", "gs", 0, 55));
//需要一个Model对象
        model.addAttribute("list", list);
//跳转视图
        return "userList";

    }
}
