package com.lixijie.springdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ThymeLeafController {

	@RequestMapping("/getShow")
	public String getMsg(Model model) {
		String ss=null;
		ss.length();
		model.addAttribute("msg", "First Thymeleaf");
		return "index";
	}

	@RequestMapping("/getShow2")
	public String getMsgs(Model model) {
	/*	int a=100/0;*/
		model.addAttribute("msg", "First Thymeleaf");
		return "index";
	}


}
