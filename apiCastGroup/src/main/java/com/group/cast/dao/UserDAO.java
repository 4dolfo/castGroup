package com.group.cast.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.group.cast.model.User;



public interface UserDAO {

	List<User> findAll();
	User getUser(String vcEmail, String vcPassword);
	
}