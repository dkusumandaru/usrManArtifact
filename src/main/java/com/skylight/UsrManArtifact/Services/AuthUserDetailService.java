/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skylight.UsrManArtifact.Services;


import com.skylight.UsrManArtifact.Entities.ThisUser;
import java.util.ArrayList;
import java.util.List;
import net.minidev.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.skylight.UsrManArtifact.Entities.Users;
import net.minidev.json.JSONArray;

/**
 *
 * @author dragon
 */
@Service
public class AuthUserDetailService implements UserDetailsService{

//    @Override
//    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
//        return new User("foo","foo", new ArrayList<>());
//    }
    
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        
        System.out.println("load by username: "+userName);
        
        ThisUser user = validasi(userName);
        System.out.println(user.toString());
        User.UserBuilder builder = null;
        
        if(user != null){
            System.out.println("Test");
            System.out.println("username after validation: "+user.getUsername());
            System.out.println("password after validation: "+user.getPassword());
            builder = org.springframework.security.core.userdetails.User.withUsername(userName);
            builder.password(user.getPassword());
            builder.roles(user.getRoles());
            System.out.println(user.getRoles());

        }else{
            JSONObject jsonObject = new JSONObject();
            System.out.println("user salah");
        }
        
        System.out.println(builder.toString());
        return builder.build();
    }

    private ThisUser validasi(String userName) {
        System.out.println("cek username di databse: "+userName);
        
        String password = null;
        String role = null;
        String email = null;
        

        List<Users> us = userService.findByEmail(userName);
        
        System.out.println(us.toString());

        if(us != null){
            
//            JSONArray jsonArray = new JSONArray();
//            JSONObject jsonObject2 = new JSONObject();

            for (Users users : us) {
                String UserId = users.getUserId();
                email = users.getUserEmail();
                password = users.getUserPassword();
                role = "RANGER";
                String UserMiddleName   = users.getUserMiddleName();
                String UserLastName     = users.getUserLastName();
                String UserFirstName    = users.getUserFirstName();
//                String UserRoleId = users.getRoleId();
            }
        
//            
//            System.out.println("username: "+userName);
//            System.out.println("password: "+password);
//            System.out.println("role: "+role);
            
        }else{
            System.out.println("access denied");
        }
        
        
        if(userName.equalsIgnoreCase(email)){
            System.out.println("test : "+email);
            System.out.println("test : "+userName);
            return new ThisUser(userName, password, role);
        }
        
        return null;
    }    
    
}
