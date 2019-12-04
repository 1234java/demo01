package com.malin.demo.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
	
	
	@RequestMapping("/logisn")
	public String login(String name,String pwd) {
		log.info("name:{}",name);
		log.info("pwd:{}",pwd);
		UsernamePasswordToken token = new UsernamePasswordToken(name, pwd);
				
				
		SecurityUtils.getSubject().login(token);
		return "sd";
	}
	
	
	

}
