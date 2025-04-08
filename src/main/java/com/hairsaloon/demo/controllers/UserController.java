package com.hairsaloon.demo.controllers;

import com.hairsaloon.demo.modals.User;
import com.hairsaloon.demo.repository.userRepository;
import com.hairsaloon.demo.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {

    @Autowired
//    public userRepository userRepo;
    private final UserService userServ;
    @PostMapping("/api/create-user")
//    WE can return http code as well with ResponseEntity.
    public ResponseEntity<User> createUser(@RequestBody @Valid User user){
        User createdUser = userServ.createUser(user);
        return  new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/api/user")
    public ResponseEntity<List<User>> getUser(){
        System.out.println("Working...");
        List<User>users = userServ.getUser();

        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    @GetMapping("/api/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id) throws  Exception{
        User user= userServ.getUserById(id);

        return new ResponseEntity<>(user,HttpStatus.FOUND);
    }
    // Now we want to update user ;
    @PutMapping("api/user/{id}")
    public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable Long id)throws Exception{
        User updatedUser= userServ.updateUser(user,id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
    @DeleteMapping("/api/user/remove/{id}")
    public ResponseEntity<String> removeUser(@PathVariable Long id) throws  Exception{
        userServ.removeUser(id);
        return new ResponseEntity<>("USER DELETED FROM DATABASE", HttpStatus.ACCEPTED);
    }

}
