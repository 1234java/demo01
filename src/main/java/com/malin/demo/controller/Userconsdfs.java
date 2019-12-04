package com.malin.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class Userconsdfs {

	@RequestMapping("/heelo")
	@ResponseBody
	public String get() {
		
		return "json";
	}
	
	
	
	@RequestMapping("/ajaxLogin")
	public String index() {
		
		return "/login";
	}
}
