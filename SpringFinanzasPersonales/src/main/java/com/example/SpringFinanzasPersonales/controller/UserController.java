package com.example.SpringFinanzasPersonales.controller;

import com.example.SpringFinanzasPersonales.models.User;
import com.example.SpringFinanzasPersonales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users/")
public class UserController {
    @Autowired
    private UserService userService;

    //create new user with roles
    @PostMapping
    public User createUser(@RequestBody User user){
        return userService.createUser(user);
    }

    //get all users
    @GetMapping
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    //get one user by id
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id){
        Optional<User> user = userService.getUserById(id);
        return user.map(ResponseEntity::ok).orElseGet(()->ResponseEntity.notFound().build());
    }

    //update one user and roles
    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDetails){
        return ResponseEntity.ok(userService.updateUser(id, userDetails));
    }

    //delete one user
    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    //login
    @GetMapping("login")
    public String login(){
        return "login";
    }

}
