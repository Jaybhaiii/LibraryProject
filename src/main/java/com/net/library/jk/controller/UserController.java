package com.net.library.jk.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.net.library.jk.entity.User;
import com.net.library.jk.serviceinterface.UserServiceInterface;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserServiceInterface usi;
	
	@PostMapping("/save")
	public String saveData(@RequestBody User u)
	{
		usi.saveData(u);
		return "Save";
	}
	
	  @GetMapping("/get")
	    public Iterable<User> getAllUsers() {
	    	
	        return usi.getData();
	    }
}
