package com.java.main.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.java.main.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>  {

	public User findByEmailIgnoreCase(String username);

	
	
	
}
