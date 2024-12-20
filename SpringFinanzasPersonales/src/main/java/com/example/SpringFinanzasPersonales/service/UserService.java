package com.example.SpringFinanzasPersonales.service;

import com.example.SpringFinanzasPersonales.DAO.RoleRepository;
import com.example.SpringFinanzasPersonales.DAO.UserRepository;
import com.example.SpringFinanzasPersonales.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    //create new user
    public User createUser(User user){
        return userRepository.save(user);
    }

    //get user by id
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    //get all users
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    //update info user and roles
    public User updateUser(Long id, User userDetails){
        User user = userRepository.findById(id).orElseThrow();
        user.setName(userDetails.getName());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setUsername(userDetails.getUsername());
        return userRepository.save(user);
    }

    //delete user
    public void deleteUser(Long id){
        userRepository.deleteById(id);
    }
}
