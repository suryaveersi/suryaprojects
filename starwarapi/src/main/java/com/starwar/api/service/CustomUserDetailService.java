package com.starwar.api.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
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
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		
		//we can also build logic to get username and password from DB
		
		 if(username.equals("admin")) 
		 { 
			 return new User("admin", bcrypt.encode("pass"), new ArrayList<>());
		 }
		 else 
		 { 
			 throw new UsernameNotFoundException("user not found"); 
		 }
		 
		
		
	}

}
