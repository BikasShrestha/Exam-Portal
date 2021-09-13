package com.example.demo;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.model.Role;
import com.example.demo.model.User;
import com.example.demo.model.UserRole;
import com.example.demo.service.UserService;

@SpringBootApplication
public class ExamserverApplication implements CommandLineRunner{

	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Starting code");
		
		//ADMIN
		User user = new User();
		
		user.setFirstname("Bikas");
		user.setLastname("Shrestha");
		user.setUsername("bikas04");
		user.setPassword(this.bCryptPasswordEncoder.encode("bikas"));
		user.setEmail("bikas@gmail.com");
		user.setProfile("profile.png");
		
		Role role1 = new Role();
		role1.setRoleId(44L);
		role1.setRoleName("ADMIN");
		
		
		UserRole userRole = new UserRole();
		userRole.setRole(role1);
		userRole.setUser(user);
		
		
		Set<UserRole> userRoleSet = new HashSet<>();
		userRoleSet.add(userRole);
		
		User user1 = this.userService.createUser(user, userRoleSet);
		System.out.println(user1.getUsername());
		
		//Normal User
		User nuser = new User();
		
		nuser.setFirstname("Bikas");
		nuser.setLastname("Shrestha");
		nuser.setUsername("normal");
		nuser.setPassword(this.bCryptPasswordEncoder.encode("bikas"));
		nuser.setEmail("normal@gmail.com");
		nuser.setProfile("profile.png");
		
		Role role2 = new Role();
		role2.setRoleId(11L);
		role2.setRoleName("NORMAL");
		
		
		UserRole userRole1 = new UserRole();
		userRole1.setRole(role2);
		userRole1.setUser(nuser);
		
		
		Set<UserRole> userRoleSet1 = new HashSet<>();
		userRoleSet1.add(userRole1);
		
		User user2 = this.userService.createUser(nuser, userRoleSet1);
		System.out.println(user2.getUsername());
		
		
	}
	
}
