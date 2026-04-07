package com.example.experiment7.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    @GetMapping("/dashboard")
    public Map<String, String> dashboard(Authentication authentication) {
        return Map.of(
            "message", "Welcome, Admin!",
            "username", authentication.getName(),
            "role", authentication.getAuthorities().toString(),
            "access", "ADMIN only endpoint"
        );
    }
}
