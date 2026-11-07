package com.example.studentapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class GreetingController {

    @GetMapping("/api/student")
    public Map<String, String> greeting(
            @RequestParam(defaultValue = "Student") String name) {
        return Map.of("message", "Welcome, " + name + "!");
    }
}
