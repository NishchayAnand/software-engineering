package com.example.Java_Implementation.controller;

import com.example.Java_Implementation.service.AttendanceService;
import com.example.Java_Implementation.service.ClassService;
import com.example.Java_Implementation.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @PostMapping("/create-class")
    public ResponseEntity<CreateClassResponse> createClass(@RequestBody CreateClassRequest req) {
        CreateClassResponse res = classService.createClass(req);
        return ResponseEntity.status(201).body(res);
    }


}
