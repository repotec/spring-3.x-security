package com.spring.security.controller;

import com.spring.security.dto.UserAuthRequestModel;
import com.spring.security.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public String auth(@RequestBody UserAuthRequestModel authModel) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authModel.userName(),
                                                                                       authModel.password()));
            try {
                return jwtUtil.generateToken(authModel.userName());
            }catch (Exception e){
                e.printStackTrace();
            }

            return "logged in";
        } catch (Exception e) {
            return "invalid username or password - " + e.getMessage();
        }
    }
}
