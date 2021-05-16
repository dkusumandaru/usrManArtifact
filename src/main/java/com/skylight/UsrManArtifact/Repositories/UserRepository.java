/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skylight.UsrManArtifact.Repositories;

import com.skylight.UsrManArtifact.Entities.Users;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author dragon
 */
public interface UserRepository extends CrudRepository<Users, String> {
    @Query(value = "SELECT * FROM users WHERE users.user_active = 'true'", nativeQuery = true)
    Iterable <Users> getUserActive();
      
    @Query(value = "SELECT * FROM users WHERE users.user_id = :id AND users.user_active = 'true'", nativeQuery = true)
    List <Users> getUserById(@Param(value="id") String id);
    
    @Query(value = "SELECT * FROM users WHERE users.user_email = :email AND users.user_active = 'true'", nativeQuery = true)
    //List <User> getUserById(@Param(value="id") String id);
    //public User ;
    List<Users> findByEmail(@Param(value="email") String email);
}
