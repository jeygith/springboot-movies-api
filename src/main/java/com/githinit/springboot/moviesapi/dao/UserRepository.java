package com.githinit.springboot.moviesapi.dao;

import com.githinit.springboot.moviesapi.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String s);

}
