/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skylight.UsrManArtifact.Services;

import com.skylight.UsrManArtifact.Entities.Users;
import com.skylight.UsrManArtifact.Repositories.UserRepository;
import com.skylight.UsrManArtifact.ServiceInterfaces.UserInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author dragon
 */
@Service
public class UserService implements UserInterface{
    @Autowired
    private UserRepository userRepository;
    

    @Override
    public Iterable<Users> getUserActive() {
       return userRepository.getUserActive();
    }

    @Override
    public List<Users> getUserById(String id) {
        return userRepository.getUserById(id);
    }

    @Override
    public List<Users> findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    
}
