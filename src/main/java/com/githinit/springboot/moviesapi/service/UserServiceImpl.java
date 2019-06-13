package com.githinit.springboot.moviesapi.service;

import com.githinit.springboot.moviesapi.dao.UserRepository;
import com.githinit.springboot.moviesapi.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImpl implements UserService {


    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

}
