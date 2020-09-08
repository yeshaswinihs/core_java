package com.example.helloWorld.restfulwebservices.service;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.helloWorld.restfulwebservices.domain.User;
import com.example.helloWorld.restfulwebservices.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;

	@Autowired
	Mapper beanMapper;

	public Long createUser(com.example.helloWorld.restfulwebservices.dto.User user) {
		User createdUser = userRepository.save(beanMapper.map(user, User.class));
		com.example.helloWorld.restfulwebservices.dto.User userDto = beanMapper.map(createdUser,
				com.example.helloWorld.restfulwebservices.dto.User.class);
		return userDto.getId();
	}
}
