package com.example.demo.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.repo.RoleRepository;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.UserService;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private RoleRepository roleRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	//creating user
	@Override
	public User createUser(User user, Set<UserRole> userRoles) throws Exception {
		
		//look if user exist
		User local = this.userRepository.findByUsername(user.getUsername());
		
		//if exist
		if(local != null) {
			System.out.println("User is already present in userRepository!");
			throw new Exception("User already present in userRepo");
		}else {
			//create user
			
			
			for(UserRole ur: userRoles) {
				roleRepository.save(ur.getRole());
			}
			
			user.getUserRoles().addAll(userRoles);
			local = this.userRepository.save(user);
			
			
		} 
		
		return local;
		
		
	}


	//getting user by username
	@Override
	public User getUser(String username) {
		
		return this.userRepository.findByUsername(username);
	}


	@Override
	public void deleteUser(Long userId) {

		this.userRepository.deleteById(userId);
	}


	
}
