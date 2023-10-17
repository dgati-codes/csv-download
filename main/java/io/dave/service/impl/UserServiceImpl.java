package io.dave.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.dave.entity.User;
import io.dave.repo.UserRepository;
import io.dave.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}


    
}