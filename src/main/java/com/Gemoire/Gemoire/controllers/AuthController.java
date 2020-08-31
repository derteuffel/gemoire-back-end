package com.Gemoire.Gemoire.controllers;


import com.Gemoire.Gemoire.helpers.LoginRequest;
import com.Gemoire.Gemoire.helpers.SignupRequest;
import com.Gemoire.Gemoire.metiers.AuthService;
import com.Gemoire.Gemoire.metiers.AuthenticationResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/rest/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity signup(@RequestBody SignupRequest signupRequest) {
        authService.signup(signupRequest);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticationResponse login(@RequestBody LoginRequest loginRequest) {
        return authService.login(loginRequest);
    }

}
