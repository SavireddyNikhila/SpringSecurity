package com.zkteco.springsecurity.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.zkteco.springsecurity.entity.UserInfo;
import com.zkteco.springsecurity.repository.UserInfoRepository;
import com.zkteco.springsecurity.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserInfoRepository repo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public String addUser(UserInfo userInfo) {
		userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
		repo.save(userInfo);
		return "user added to system";
	}

}
