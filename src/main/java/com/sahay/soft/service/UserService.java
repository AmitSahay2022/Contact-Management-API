package com.sahay.soft.service;

import com.sahay.soft.entity.User;

import java.util.List;

public interface UserService {
    String saveUser(User user);
    String updateUser(long id,User user);
    String deleteUser(long id);
    User getUser(long id);
    List<User> getAllUsers();
}
