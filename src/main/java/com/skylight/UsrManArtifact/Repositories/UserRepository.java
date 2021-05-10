/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skylight.UsrManArtifact.Repositories;

import com.skylight.UsrManArtifact.Entities.User;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author dragon
 */
public interface UserRepository extends CrudRepository<User, String> {
    @Query(value = "SELECT * FROM user WHERE user.user_active = 'true'", nativeQuery = true)
    Iterable <User> getUserActive();
      
    @Query(value = "SELECT * FROM role WHERE user.user_id = :id AND user.user_active = 'true'", nativeQuery = true)
    List <User> getUserById(@Param(value="id") String id);
}
