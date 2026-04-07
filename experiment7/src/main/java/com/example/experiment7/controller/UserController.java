package com.example.experiment7.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @GetMapping("/profile")
    public Map<String, String> profile(Authentication authentication) {
        return Map.of(
            "message", "Welcome, authenticated user!",
            "username", authentication.getName(),
            "role", authentication.getAuthorities().toString(),
            "access", "USER and ADMIN can access this"
        );
    }
}
