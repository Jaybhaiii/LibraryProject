package com.net.library.jk.serviceinterface;

import java.util.List;

import com.net.library.jk.entity.User;

public interface UserServiceInterface {

	
	public User saveData(User u);

	public Iterable<User> getData();
}
