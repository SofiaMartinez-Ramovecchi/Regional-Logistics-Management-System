package com.logistics.controllers;

import com.logistics.models.LoginRequest;
import com.logistics.models.LoginResponse;

import com.logistics.services.login.LoginService;

import org.springframework.web.bind.annotation.*;

@RestController
public class LoginController {

    @PostMapping("/login")
    public LoginResponse login(
            @RequestBody LoginRequest request
    ) {

        return LoginService.login(
                request.email(),
                request.password()
        );
    }
}