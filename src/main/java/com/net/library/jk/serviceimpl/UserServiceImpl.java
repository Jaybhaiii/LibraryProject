package com.net.library.jk.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.net.library.jk.entity.User;
import com.net.library.jk.repository.UserRepository;
import com.net.library.jk.serviceinterface.UserServiceInterface;
@Service
 public class UserServiceImpl implements UserServiceInterface
{

	@Autowired
	UserRepository ur;
	
	@Override
	public User saveData(User u) {
		
		return ur.save(u);
		
	}

	@Override
	public Iterable<User> getData() {
		
		return ur.findAll();
	}

}
