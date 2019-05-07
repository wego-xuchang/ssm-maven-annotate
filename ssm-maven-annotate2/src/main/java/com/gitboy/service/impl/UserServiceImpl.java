package com.gitboy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gitboy.mapper.UserMapper;
import com.gitboy.pojo.User;
import com.gitboy.service.UserService;


@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserMapper userMapper;

	@Override
	public List<User> findAllUser() {
		return userMapper.findAllUser();
	}
}
