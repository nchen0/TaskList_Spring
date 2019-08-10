package com.tasklist.spring.demo.controllers;

import com.tasklist.spring.demo.entities.User;
import com.tasklist.spring.demo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> getUsers() {
        return userService.getUsers();
    }


    @GetMapping("/users/{id}")
    public User getUser(@PathVariable int id) {
        return userService.getUser(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public User addUser(@Valid @RequestBody User user) {
        userService.addUser(user);
        return user;
    }

    @PutMapping("/users/{id}")
    public User updateUser(@Valid @RequestBody User user, @PathVariable int id) {
        userService.updateUser(user, id);
        return user;
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.deleteUser(id);
    }

    // GET /users/username/{username} - Return the user based off of the user name
    @GetMapping("/users/username/{username}")
    public User getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }


}
