package com.starwar.api.dao;

import com.starwar.api.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
    public interface UserRepository extends JpaRepository<User, String> {

         User findByUsername(String username);
    }


