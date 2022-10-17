package com.starwar.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class CustomUserDetailService implements UserDetailsService {

	 @Lazy
	 @Autowired BCryptPasswordEncoder bcrypt;
	 @Value("${spring.username}")
	 String user;
	 @Value("${spring.password}")
	String password;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		//we can also build logic to get username and password from DB
		
		 if(username.equals(user))
		 { 
			 return new User(user, bcrypt.encode(password), new ArrayList<>());
		 }
		 else 
		 { 
			 throw new UsernameNotFoundException("user not found"); 
		 }
		 
		
		
	}

}
