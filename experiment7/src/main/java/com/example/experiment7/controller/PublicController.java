package com.example.experiment7.controller;

import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/public")
public class PublicController {

    @GetMapping("/hello")
    public Map<String, String> hello() {
        return Map.of(
            "message", "This is a public endpoint - no authentication required",
            "status", "open"
        );
    }
}
