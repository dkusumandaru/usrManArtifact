/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skylight.UsrManArtifact.Services;

import com.skylight.UsrManArtifact.Entities.Role;
import com.skylight.UsrManArtifact.Repositories.RoleRepository;
import com.skylight.UsrManArtifact.ServiceInterfaces.RoleInterface;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dragon
 */
@Service
public class RoleService implements RoleInterface {

    @Autowired
    private RoleRepository roleRepository;

    @Override
    public Iterable<Role> getAll() {
        return roleRepository.findAll();  
    }
    
    @Override
    public Optional<Role> getById(Integer id) {
        return roleRepository.findById(id);
    }

    @Override
    public void deleleteById(Integer id) {
        roleRepository.deleteById(id);
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }

    @Override
    public Iterable<Role> getRoleActive() {
        return roleRepository.getRoleActive();
    }

    @Override
    public List<Role> getRoleById(Integer id) {
       return roleRepository.getRoleById(id);
    }
    
}
