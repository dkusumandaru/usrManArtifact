/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skylight.UsrManArtifact.Controllers;

import com.skylight.UsrManArtifact.Entities.AuthResponse;
import com.skylight.UsrManArtifact.Entities.AuthRequest;
import com.skylight.UsrManArtifact.Services.AuthUserDetailService;
import com.skylight.UsrManArtifact.Services.JwtUtil;
import java.util.Date;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dragon
 */

@RestController
public class AuthResource {

    @Autowired
    private AuthenticationManager authenticationManager;
    
    @Autowired
    private AuthUserDetailService userDetailsService;
    
    @Autowired
    private JwtUtil jwtTokenUtil;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String hello() {
        return "hello world";
    }
    
//    @RequestMapping("/api/auth/forgotpassword/webrequest/{id}")
//    public String requestForgotPassword(@PathVariable("id") String id) {
//        
//        System.out.println("id: "+id);
//        String a = UUID.randomUUID().toString();
//        System.out.println("UUID: "+a);
//        Date d = new Date(System.currentTimeMillis()+1000*60*15);
//        System.out.println("expired in: "+d);
//        
//        String android =a.substring(0,4);
//        System.out.println("id android: "+android);
//        String url = "localhost:8082/"+a;
//        System.out.println("url web: "+url);
//        
//        return "hello world";
//    }
//    
//    @RequestMapping("/api/auth/forgotpassword/confirm/{id}")
//    public String confirmForgotPassword(@PathVariable("id") String id) {
//        
//        System.out.println("id: "+id);
//        String a = UUID.randomUUID().toString();
//        System.out.println("UUID: "+a);
//        Date d = new Date(System.currentTimeMillis()+1000*60*15);
//        System.out.println("expired in: "+d);
//        
//        String android =a.substring(0,4);
//        System.out.println("id android: "+android);
//        String url = "localhost:8082/"+a;
//        System.out.println("url web: "+url);
//        
//        return "hello world";
//    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken
        (@RequestBody AuthRequest authenticationRequest)
            throws Exception {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                            authenticationRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new Exception("incorect username or password", e);
        }
        
        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());
        
        final String jwt = jwtTokenUtil.generateToken(userDetails);
        
        return ResponseEntity.ok(new AuthResponse(jwt));
    }
}
