package com.hairsaloon.demo.services;

import com.hairsaloon.demo.modals.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    List<User> getUser();
    User getUserById(Long id) throws Exception;
    void removeUser(Long id) throws Exception;
    User updateUser(User user, Long id) throws Exception;

}
