package com.hairsaloon.demo.controllers;

import com.hairsaloon.demo.modals.User;
import com.hairsaloon.demo.repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    public userRepository userRepo;
    @PostMapping("/api/create-user")
    public User createUser(@RequestBody User user){
        System.out.println("till here it is working ");
        return  userRepo.save(user);
    }

    @GetMapping("/api/user")
    public List<User> getUser(){
        return userRepo.findAll();
    }
    @GetMapping("/api/users/{id}")
    public User getUserById(@PathVariable Long id) throws  Exception{
        Optional<User>op = userRepo.findById(id);
        if(op.isPresent())
            return op.get();
        throw  new Exception("USER NOT FOUND");
    }
    // Now we want to update user ;
    @PutMapping("api/user/{id}")
    public User updateUser(@RequestBody User user, @PathVariable Long id)throws Exception{
        Optional<User> usr= userRepo.findById(id);

        if(usr.isEmpty()){
            throw new Exception("User not found with id "+ id);
        }

        User existingUser =  usr.get();

        existingUser.setFullname(user.getFullname());
        existingUser.setPhoneNo(user.getPhoneNo());
        existingUser.setEmail(user.getEmail());
        existingUser.setRole(user.getRole());
        return userRepo.save(existingUser);
    }
    @DeleteMapping("/api/user/remove/{id}")
    public String removeUser(@PathVariable Long id) throws  Exception{
        Optional<User> rmUser = userRepo.findById(id);
        if(rmUser.isEmpty())
            throw new Exception("User not present in the records with id"+id);
        userRepo.deleteById(rmUser.get().getId());

        return "User have been removed successfully";
    }

}
