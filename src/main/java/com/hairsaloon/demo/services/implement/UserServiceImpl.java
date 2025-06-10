package com.hairsaloon.demo.services.implement;

import com.hairsaloon.demo.modals.User;
import com.hairsaloon.demo.repository.userRepository;
import com.hairsaloon.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserServiceImpl implements UserService {

    private final userRepository userRepo;
    @Autowired
    private final PasswordEncoder passwordEncoder;

    @Override
    public User createUser(User user) {
        return  userRepo.save(user);
    }

    @Override
    public List<User> getUser() {
        System.out.println("Till here also working");
        return userRepo.findAll();
    }

    @Override
    public User getUserById(Long id) throws Exception {
        Optional<User> op = userRepo.findById(id);
        if(op.isPresent()) {

            return op.get();
        }
        throw  new Exception("USER NOT FOUND");
    }

    @Override
    public int login(@NotNull User user)  {
        Optional<User> op = userRepo.findByUsername(user.getUsername());
        System.out.println("User found");
        User usr = op.get();
        System.out.println("User "+ usr);
        System.out.println("User "+ user.getPassword());
        System.out.println("User "+ usr.getPassword());
        if(user.getPassword().equals(usr.getPassword())){
            return 1;
        }
        return 0;
    }

    @Override
    public void removeUser(Long id) throws Exception {
        Optional<User> rmUser = userRepo.findById(id);
        if(rmUser.isEmpty())
            throw new Exception("User not present in the records with id"+id);
        userRepo.deleteById(rmUser.get().getId());

    }

    @Override
    public User updateUser(User user, Long id) throws Exception {
        Optional<User> usr= userRepo.findById(id);

        if(usr.isEmpty()){
            throw new Exception("User not found with id "+ id);
        }

        User existingUser =  usr.get();

        System.out.println(existingUser.getFullname());
        System.out.println("workin");
        String hashedPassword=existingUser.getPassword();

        if(!existingUser.getPassword().isEmpty()){
            hashedPassword = passwordEncoder.encode(existingUser.getPassword());
        }
        existingUser.setPassword(hashedPassword);
        System.out.println(hashedPassword);
        existingUser.setFullname(user.getFullname());
        existingUser.setPhoneNo(user.getPhoneNo());
        existingUser.setEmail(user.getEmail());
        existingUser.setUsername(user.getUsername());
        existingUser.setRole(user.getRole());
        return userRepo.save(existingUser);
    }
}
