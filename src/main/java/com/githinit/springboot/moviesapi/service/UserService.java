package com.githinit.springboot.moviesapi.service;

import com.githinit.springboot.moviesapi.entity.User;

import java.util.List;

public interface UserService {
    public List<User> findAll();

    public User findById(int id);

    public void save(User user);

    public void deleteById(int id);

    public User findByUsername(String username);

}
