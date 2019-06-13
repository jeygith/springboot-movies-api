package com.githinit.springboot.moviesapi.controller;

import com.githinit.springboot.moviesapi.entity.Role;
import com.githinit.springboot.moviesapi.entity.User;
import com.githinit.springboot.moviesapi.service.RoleService;
import com.githinit.springboot.moviesapi.service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private UserService userService;
    private RoleService roleService;

    private PasswordEncoder passwordEncoder;


    public UserController(UserService userService, RoleService roleService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
    }


    @GetMapping("")
    public List<User> findAll() {
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable int id) {
        return userService.findById(id);
    }

    @PostMapping("")
    public User addUser(@RequestBody User user) {


        String pass = passwordEncoder.encode(user.getPassword()).toString();

        Role role = roleService.findById(1);

        user.setId(0);
        user.setCreatedAt(getTimestamp());
        user.setUpdatedAt(getTimestamp());
        user.addRole(role);
        user.setPassword(pass);
        userService.save(user);

        return user;
    }

    @PutMapping("")
    public User updateUser(@RequestBody User user) {

        user.setUpdatedAt(getTimestamp());
        String pass = passwordEncoder.encode(user.getPassword()).toString();

        user.setPassword(pass);

        userService.save(user);

        return user;
    }


    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable int id) {
        userService.deleteById(id);

        return "Deleted user id - " + id;
    }


    private Timestamp getTimestamp() {
        Date date = new Date();

        long time = date.getTime();
        System.out.println("Time in Milliseconds: " + time);

        Timestamp ts = new Timestamp(time);
        System.out.println("Current Time Stamp: " + ts);
        return ts;
    }

}
