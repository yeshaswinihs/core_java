package com.example.helloWorld.restfulwebservices.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helloWorld.restfulwebservices.domain.User;
import com.example.helloWorld.restfulwebservices.dto.UserBean;
import com.example.helloWorld.restfulwebservices.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	Mapper beanMapper;

	public Long createUser(UserBean userBean) {

		User createdUser = userRepository.save(beanMapper.map(userBean, User.class));
		UserBean userDto = beanMapper.map(createdUser, UserBean.class);
		return userDto.getId();
	}
}
