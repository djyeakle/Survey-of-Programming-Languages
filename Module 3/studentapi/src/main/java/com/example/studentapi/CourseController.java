package com.example.studentapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;
import java.util.List;

@RestController
public class CourseController {
    @GetMapping("/api/courses")
    public List<Map<String, Object>> course() {
        return List.of(
                Map.of(
                        "code", "CMPS",
                        "title", "Introduction to Java",
                        "lessons", 3,
                        "active", true),
                Map.of(
                        "code", "CMPS",
                        "title", "Senior Capstone",
                        "lessons", 15,
                        "active", true),
                Map.of(
                        "code", "CMPS",
                        "title", "Introduction to C#",
                        "lessons", 3,
                        "active", false));
    }
}
