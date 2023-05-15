package com.java.main.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.java.main.model.User;
import com.java.main.repository.UserRepository;
import com.java.main.security.JwtuserFactory;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user=userRepository.findByEmailIgnoreCase(username);
		if(user==null) {
			throw new UsernameNotFoundException(String.format("No User Name Found with UserName '%s'", username));
		}
		else
		{
			return JwtuserFactory.create(user);
		}
	}

}
