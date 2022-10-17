package com.starwar.api.service;

import com.starwar.api.dao.UserRepository;
import com.starwar.api.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;


    public User getUsername(String username)
    {
        User user = userRepository.getById(username);

        return user;

    }

}
