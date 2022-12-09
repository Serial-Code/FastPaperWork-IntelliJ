package com.example.demo.service;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){

        return userRepository.findAll();
    }

    public User saveUser(User user){

        return userRepository.save(user);
    }

    public User getUser(Long id){

        return userRepository.findById(id).get();
    }

    public User updateUser(User user){

        return userRepository.save(user);
    }

    public void deleteUser(Long id){

        userRepository.deleteById(id);
    }
}
