package com.githinit.springboot.moviesapi.dao;

import com.githinit.springboot.moviesapi.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}