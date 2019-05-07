package com.gitboy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gitboy.pojo.User;
import com.gitboy.service.UserService;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping("findAllUser")
	@ResponseBody
	public List<User> findAllUser() {
		
		
		return userService.findAllUser();
		
	}
}
