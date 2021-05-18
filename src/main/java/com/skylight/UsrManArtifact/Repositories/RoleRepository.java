/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skylight.UsrManArtifact.Repositories;

import com.skylight.UsrManArtifact.Entities.Role;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dragon
 */
@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    @Query(value = "SELECT * FROM role WHERE role.role_active = 'true'", nativeQuery = true)
    Iterable <Role> getRoleActive();
      
    @Query(value = "SELECT * FROM role WHERE role.role_id = :id AND role.role_active = 'true'", nativeQuery = true)
    List <Role> getRoleById(@Param(value="id") Integer id);
}
