package com.tasklist.spring.demo.services;

import com.tasklist.spring.demo.entities.User;
import com.tasklist.spring.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUser(int id) {
        // return userRepository.findById(id).orElse(null);
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("Did not find user with id: " + id);
        }
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void updateUser(User newUser, int id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            newUser.setId(id);
            userRepository.save(newUser);
        } else {
            throw new RuntimeException("Did not find user with id: " + id);
        }
    }

    public void deleteUser(int id) {
        userRepository.deleteById(id);
    }



}
