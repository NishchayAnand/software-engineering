package com.example.Java_Implementation.controller;

import com.example.Java_Implementation.service.AttendanceService;
import com.example.Java_Implementation.service.ClassService;
import com.example.Java_Implementation.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class AttendanceManagementSystem {

    private final ClassService classService;

    @Autowired
    public AttendanceManagementSystem(ClassService classService) {
        this.classService = classService;
    }

    // ========== CLASS MANAGEMENT OPERATIONS ==========

    @GetMapping("/create-class")
    public String createClass(@RequestParam String className, @RequestParam String teacherName) {
        return "Class Name: " + className + ", Teacher Name: " + teacherName;
    }


}
