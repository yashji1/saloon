package com.hairsaloon.demo.services;

import com.hairsaloon.demo.modals.User;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getUser();
    int login(User user) throws UsernameNotFoundException;
    User getUserById(Long id) throws Exception;
    void removeUser(Long id) throws Exception;
    User updateUser(User user, Long id) throws Exception;

}
