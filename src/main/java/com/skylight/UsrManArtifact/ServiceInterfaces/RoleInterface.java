/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skylight.UsrManArtifact.ServiceInterfaces;

import com.skylight.UsrManArtifact.Entities.Role;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author dragon
 */
public interface RoleInterface {
    Iterable<Role> getAll(); 
    Iterable <Role> getRoleActive();
    Optional<Role> getById(String id);
    List<Role> getRoleById(Integer id);
    void deleleteById(String id);
    void save(Role product);
    
}
