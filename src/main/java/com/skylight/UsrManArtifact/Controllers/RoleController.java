/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skylight.UsrManArtifact.Controllers;

import com.skylight.UsrManArtifact.Entities.Role;
import com.skylight.UsrManArtifact.Services.RoleService;
import java.util.List;
import java.util.Map;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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
    public String getRole(Model roleModel) {

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

//    public Integer generateId() {
//        Integer id = 0;
//        Integer idBigger = 0;
//        Integer idAccess = 0;
//        Iterable<Role> roleList = roleService.getAll();
//        for (Role i : roleList) {
//            idAccess = i.getRoleId();
//            if (idAccess > idBigger) {
//                idBigger = idAccess;
//            } else {
//                idBigger = idBigger;
//            }
//        }
//        id = idBigger + 1;
//        return id;
//    }
//
//    @RequestMapping(value = "/role/add", method = RequestMethod.POST)
//    public String addRole(
//            @RequestParam(value = "category_name_add", required = false) String nameRole
//    ) {
//        String activeRole = "true";
//        System.out.println("Here ^_^");
//
//        Integer idRole = generateId();
//
//        System.out.println(idRole);
//
//        Role role = new Role(idRole, nameRole, activeRole);
//        role.setRoleId(idRole);
//        role.setRoleName(nameRole);
//        role.setRoleActive(activeRole);
//
////        
//        this.roleService.save(role);
//        return "redirect:/role";
//    }
//
//    @RequestMapping(value = "/role/edit", method = RequestMethod.POST)
//    public String editRole(
//            @RequestParam(value = "category_id_edit", required = false) Integer idRole,
//            @RequestParam(value = "category_name_edit", required = false) String nameRole
//    ) {
//        String activeRole = "true";
//        Role role = new Role(idRole, nameRole, activeRole);
//        role.setRoleId(idRole);
//        role.setRoleName(nameRole);
//        role.setRoleActive(activeRole);
//
//        this.roleService.save(role);
//        return "redirect:/role";
//    }
//
//    @RequestMapping(value = "/role/remove", method = RequestMethod.POST)
//    public String removeRole(
//            @RequestParam(value = "category_id_remove", required = false) Integer idRole
//    ) {
//        String activeRole = "false";
//        String nameRole = "";
//
//        List<Role> roleDetail = roleService.getById(idRole);
//        System.out.println(roleDetail);
//        for (Role i : roleDetail) {
//            nameRole = i.getRoleName();
//            System.out.println(nameRole);
//        }
//
//        Role role = new Role(idRole, nameRole, activeRole);
//        role.setRoleId(idRole);
//        role.setRoleName(nameRole);
//        role.setRoleActive(activeRole);
//
//        this.roleService.save(role);
//        return "redirect:/role";
//    }
}
