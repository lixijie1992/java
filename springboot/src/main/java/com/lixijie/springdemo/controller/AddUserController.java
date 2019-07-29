package com.lixijie.springdemo.controller;

import com.lixijie.springdemo.service.UserServices;
import com.lixijie.springdemo.pojo.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class AddUserController {
    @Autowired
    private UserServices userServices;

    /**
     * 参数变量名需要按照驼峰规则
     * 若想要为变量不按照驼峰规则命名，则需要使用@ModelAttribute("ss")命名为ss
     * 在前端页面也需要改为ss   其他相关地方也要使用此重新命名
     * @param userDao
     * @return
     */
    @RequestMapping("/add")
    public String showPage( UserDao userDao) {

        return "addUser";
    }

    /**
     * @Valid 开启数据校验
     * @param userDao
     * @param bindingResult  校验结果  true 非法结果
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(@Valid UserDao userDao, BindingResult bindingResult) {
        userDao.setId(UUID.randomUUID().toString());
        if(bindingResult.hasErrors()){
            return "addUser";
        }
        this.userServices.addUser(userDao);
        return "ok";
    }

    /**
     * @return
     */
    @RequestMapping("/findUser")
    public String findUser(Model model) {
        List<UserDao> list = this.userServices.findUser();
        model.addAttribute("list", list);
        return "showUsers";
    }


}
