package com.sahay.soft.service.impl;

import com.sahay.soft.entity.User;
import com.sahay.soft.repository.UserRepository;
import com.sahay.soft.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;

    @Override
    public String saveUser(User user) {
        String encode = passwordEncoder.encode(user.getPassword());
        user.setPassword(encode);
        User saved = userRepository.save(user);
        if(saved!=null){
            return "User Info Saved Successfully";
        }else{
            return "OOPS!";
        }

    }

    @Override
    public String updateUser(long id, User user) {
        User updateUser = getUser(id);
        updateUser.setUserName(user.getUserName());
        String encode = passwordEncoder.encode(user.getPassword());
        updateUser.setPassword(encode);
        User save = userRepository.save(updateUser);
        if(save!=null){
            return "Successfully updated";
        }else{
            return "Oops!";
        }

    }

    @Override
    public String deleteUser(long id) {
        User user = getUser(id);
        userRepository.delete(user);
        return "User Deleted Successfully";
    }

    @Override
    public User getUser(long id) {
        User user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found!"));
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
