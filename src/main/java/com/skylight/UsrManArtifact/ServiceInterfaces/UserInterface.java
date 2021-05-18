/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skylight.UsrManArtifact.ServiceInterfaces;

import com.skylight.UsrManArtifact.Entities.Users;
import java.util.List;

/**
 *
 * @author dragon
 */
public interface UserInterface {
   Iterable <Users> getUserActive();
   List<Users> getUserById(String id);
   List<Users> findByEmail(String email);
}
