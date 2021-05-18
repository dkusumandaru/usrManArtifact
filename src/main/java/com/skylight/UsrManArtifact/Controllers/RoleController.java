/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skylight.UsrManArtifact.Controllers;

import com.skylight.UsrManArtifact.Entities.Role;
import com.skylight.UsrManArtifact.Services.RoleService;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dragon
 */
@RestController
public class RoleController {

    @Autowired
    RoleService roleService;

    @GetMapping("/role")
    @ApiOperation(value = "${RoleController.get}")
    public String getRole(Model roleModel
       // @RequestHeader("bearer") String header
    ) {

        Iterable<Role> role = roleService.getRoleActive();

        JSONArray jsonArray = new JSONArray();;
        JSONObject jsonObject2 = new JSONObject();

        for (Role roles : role) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("role_id", roles.getRoleId());
            jsonObject.put("role_name", roles.getRoleName());
            jsonObject.put("role_active", roles.getRoleActive());
            jsonArray.add(jsonObject);
        }

        jsonObject2.put("roleList", jsonArray);
        return jsonObject2.toString();

    }

    public Integer generateId() {
        Integer id = 0;
        Integer idBigger = 0;
        Integer idAccess = 0;
        Iterable<Role> roleList = roleService.getAll();
        for (Role i : roleList) {
            idAccess = i.getRoleId();
            if (idAccess > idBigger) {
                idBigger = idAccess;
            }
        }
        id = idBigger + 1;
        return id;
    }

    @PostMapping("/role/add")
    @ApiOperation(value = "${RoleController.insert}")
    public String addRole(
            @RequestBody Role role
    // @RequestBody(value = "role_name", required = true) String nameRole, String value
    ) {
        JSONObject jSONObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();

        System.out.println(role);

        //        String activeRole = "true";
        //        Integer idRole = generateId();
        //        Role roleInsert = new Role(idRole, nameRole, activeRole);
        //        roleInsert.setRoleId(idRole);
        //        roleInsert.setRoleName(nameRole);
        //        roleInsert.setRoleActive(activeRole);
        //        return role.toString();
        try {
            this.roleService.save(role);
            jsonObject.put("status", "true");
            jsonObject.put("description", "insert successfully");
            jsonArray.add(jsonObject);
            return jsonObject.toString();
        } catch (DataAccessException ex) {
            jsonObject.put("status", "false");
            jsonObject.put("description", "insert unsuccessfully");
            jsonArray.add(jsonObject);
            return jsonObject.toString();
        }

    }


    @PutMapping("role/update/{id}")
    @ApiOperation(value = "${RoleController.update}")
    public String updateRole(@RequestBody Role role, @PathVariable Integer id
    //, @RequestHeader("bearer") String header
    ) {

        JSONArray jsonArray = new JSONArray();
        JSONObject jsonObject = new JSONObject();
        JSONObject jsonObject2 = new JSONObject();

        Optional<Role> roleOptional = roleService.getById(id);

        if (!roleOptional.isPresent()) {
            jsonObject.put("status", "false");
            jsonObject.put("description", "update unsuccessfully");
            jsonArray.add(jsonObject);
        }

        String name = roleOptional.get().getRoleName();
        String active = roleOptional.get().getRoleActive();
        role.setRoleId(id);
        roleService.save(role);
        String nameUpdate = roleOptional.get().getRoleName();
        String activeUpdate = roleOptional.get().getRoleActive();

        if (name.equals(nameUpdate) && active.equals(activeUpdate)) {
            jsonObject.put("status", "true");
            jsonObject.put("description", "there is no data udated");
            jsonArray.add(jsonObject);
            jsonObject2.put("status", jsonArray);

            return jsonObject.toString();
        } else {
            jsonObject.put("status", "true");
            jsonObject.put("description", "update successfully");
            jsonArray.add(jsonObject);

            jsonObject2.put("status", jsonArray);

            return jsonObject.toString();
        }
    }

    @DeleteMapping("/role/delete/{id}")
    @ApiOperation(value = "${RoleController.delete}")
    public String hardDeleteUser(@PathVariable Integer id) {

        roleService.deleleteById(id);

        JSONObject jSONObject1 = new JSONObject();

        jSONObject1.put("status", "true");
        jSONObject1.put("description", "delete succefully");

        return jSONObject1.toJSONString();

    }

}
