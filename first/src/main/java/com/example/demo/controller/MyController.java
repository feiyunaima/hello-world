package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {
	
	@ResponseBody
	@RequestMapping("/hello")
	public String sayHello(){
		return "你好啊";
	}

}
