package com.hairsaloon.demo.services.implement;

import com.hairsaloon.demo.modals.User;
import com.hairsaloon.demo.repository.userRepository;
import com.hairsaloon.demo.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final userRepository userRepo;

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
        if(op.isPresent())
            return op.get();
        throw  new Exception("USER NOT FOUND");
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

        existingUser.setFullname(user.getFullname());
        existingUser.setPhoneNo(user.getPhoneNo());
        existingUser.setEmail(user.getEmail());
        existingUser.setUsername(user.getUsername());
        existingUser.setRole(user.getRole());
        return userRepo.save(existingUser);
    }
}
