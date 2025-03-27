package com.hairsaloon.demo.controllers;

import com.hairsaloon.demo.modals.User;
import com.hairsaloon.demo.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class UserController {

    @Autowired
    public userRepository userRepo;
    @PostMapping("/api/create-user")
    public User createUser(@RequestBody User user){
        return  userRepo.save(user);
    }

    @GetMapping("/api/user")
    public User getUser(){
        User user = new User();
        user.setEmail("yashsharmaharsh@gmail.com");
        user.setFullname("YASH SHARMA");
        user.setRole("User");
        user.setPhoneNo("+91 6395877792");
        user.setCreatedAt(LocalDateTime.now());
        return user;
    }
}
