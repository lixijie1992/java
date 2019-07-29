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
     * ������������Ҫ�����շ����
     * ����ҪΪ�����������շ��������������Ҫʹ��@ModelAttribute("ss")����Ϊss
     * ��ǰ��ҳ��Ҳ��Ҫ��Ϊss   ������صط�ҲҪʹ�ô���������
     * @param userDao
     * @return
     */
    @RequestMapping("/add")
    public String showPage( UserDao userDao) {

        return "addUser";
    }

    /**
     * @Valid ��������У��
     * @param userDao
     * @param bindingResult  У����  true �Ƿ����
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
