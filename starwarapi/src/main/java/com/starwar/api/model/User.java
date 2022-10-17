package com.starwar.api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name="userdata")
public class User {
    @Id
    String username;
    String password;
    String email;
    String role;

    public User(String username, String password, String email) {

        this.username = username;
        this.password = password;
        this.email = email;
    }





}
