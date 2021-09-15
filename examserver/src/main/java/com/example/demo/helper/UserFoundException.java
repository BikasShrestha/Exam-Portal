package com.example.demo.helper;

public class UserFoundException extends Exception{
	
	public UserFoundException() {
		super("User already exist in database!");
	}
	
	public UserFoundException(String msg) {
		super(msg);
	}
}
