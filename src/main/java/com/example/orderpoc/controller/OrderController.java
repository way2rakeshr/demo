package com.example.orderpoc.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;



import com.example.orderpoc.entity.Response;
import com.example.orderpoc.entity.User;
import com.example.orderpoc.entity.UserList;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RequestMapping("/orders")
@RestController
public class OrderController {
	@Autowired
	RestTemplate restTemplate;
	
	


	 @GetMapping("/allUsers")
	 @HystrixCommand(fallbackMethod = "fallBackgetAllUsers")
	public UserList  getAllUsers(){
//		
		    UserList forObject = restTemplate.getForObject("http://loginpoc/api/allUsers/", UserList.class);
		return forObject;
		 
			
	}
	 public UserList	 fallBackgetAllUsers() {
		ArrayList<User> arrayList= new ArrayList<User>();
		arrayList.add(new User(1, "error please wait for sometime", "error"));
	
		 UserList userList= new UserList();
		 userList.setUser( arrayList);
		 
		return userList;
		 
	 }
	
}
