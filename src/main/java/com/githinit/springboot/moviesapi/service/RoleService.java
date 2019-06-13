package com.githinit.springboot.moviesapi.service;

import com.githinit.springboot.moviesapi.entity.Role;
import com.githinit.springboot.moviesapi.entity.User;

import java.util.List;

public interface RoleService {
    public List<Role> findAll();

    public Role findById(int id);

    public void save(Role role);

    public void deleteById(int id);
}
