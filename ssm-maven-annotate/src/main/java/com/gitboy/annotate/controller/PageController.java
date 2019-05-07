package com.gitboy.annotate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
	@RequestMapping("hello")
	@ResponseBody
	public String hello() {
		return "hello world";
		
	}
	@RequestMapping("/{page}")
	public String  showPage(@PathVariable String page) {
		return page;
		
	}
	
}
