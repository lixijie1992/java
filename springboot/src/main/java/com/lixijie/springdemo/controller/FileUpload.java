package com.lixijie.springdemo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author lixijie
 * @RestController    对返回值进行jason格式转换    @Controller + @ResponseBody
 * 文件上传
 */
@RestController
public class FileUpload {

    @RequestMapping("/uploadFile")
    public Map<String,Object> uploadFiles(MultipartFile  fileName){
        System.out.println(fileName.getOriginalFilename());
        System.out.println(fileName.getName());
        System.out.println(fileName.getSize());
        try {
            fileName.transferTo(new File("h://"+fileName.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("msd","OK");
        return  map;
    }

}
