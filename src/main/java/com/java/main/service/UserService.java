package com.java.main.service;

import java.util.List;

import com.java.main.model.User;

public interface UserService {

	public User save(User user);

	public List<User> findAll();

	public User getUserByEmail(String email);

}
