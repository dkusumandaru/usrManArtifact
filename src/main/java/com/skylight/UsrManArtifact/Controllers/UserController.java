/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skylight.UsrManArtifact.Controllers;

import com.skylight.UsrManArtifact.Entities.User;
import com.skylight.UsrManArtifact.Services.UserService;
import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dragon
 */
@RestController
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/user")
    public String getUser(Model userModel) {

        Iterable<User> user = userService.getUserActive();

        JSONArray jsonArray = new JSONArray();;
        JSONObject jsonObject2 = new JSONObject();

        for (User users : user) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("first_name", users.getUserFirstName());
            jsonObject.put("middle_name", users.getUserMiddleName());
            jsonObject.put("middle_name", users.getUserLastName());
            jsonArray.add(jsonObject);
        }

        jsonObject2.put("user", jsonArray);
        return jsonObject2.toString();

    }
}
