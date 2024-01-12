package com.sahay.soft.controller;

import com.sahay.soft.entity.Role;
import com.sahay.soft.entity.User;
import com.sahay.soft.repository.RoleRepository;
import com.sahay.soft.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private RoleRepository roleRepository;
    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody User user){
        Role normal = roleRepository.findByRole("Normal");
        user.getRoles().add(normal);
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }
    @PutMapping("{id}")
    public ResponseEntity<String> updateUser(@PathVariable long id,@RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(id,user),HttpStatus.ACCEPTED);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteUser(@PathVariable long id){
        return new ResponseEntity<>(userService.deleteUser(id),HttpStatus.OK);
    }
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable long id){
        return new ResponseEntity<>(userService.getUser(id),HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    @GetMapping("/dummy")
    public ResponseEntity<List<User>> getDummyUsers(){
        List<User> userList=new ArrayList<>();
        userList.add(new User("Amit Kumar","sahay soft"));
        userList.add(new User("Sunny Leone","leone"));
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }
}
