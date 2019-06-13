package com.githinit.springboot.moviesapi.service;

import com.githinit.springboot.moviesapi.dao.RoleRepository;
import com.githinit.springboot.moviesapi.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(int id) {
        Optional<Role> result = roleRepository.findById(id);

        Role role = null;

        if (result.isPresent()) {
            role = result.get();
        } else {
            throw new RuntimeException("Movie not found - " + id);
        }

        return role;
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public void deleteById(int id) {
        roleRepository.deleteById(id);
    }
}
