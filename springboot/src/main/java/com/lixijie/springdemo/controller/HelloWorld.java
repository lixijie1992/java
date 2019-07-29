package com.lixijie.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloWorld {
    @RequestMapping("/getMap")
    @ResponseBody
   public Map<String,Object>  getMap(){
       Map<String,Object> map = new HashMap<String,Object>();
       map.put("aa","34234");
       return  map;
   }
}
