package com.example.Java_Implementation.controller;

import com.example.Java_Implementation.dto.AddStudentRequest;
import com.example.Java_Implementation.dto.CreateClassRequest;
import com.example.Java_Implementation.service.ClassService;
import jakarta.validation.Valid;
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

    @PostMapping("/create-class")
    public ResponseEntity<String> createClass(@Valid @RequestBody CreateClassRequest req) {
        boolean created = classService.createClass(req);
        if (!created) {
            return ResponseEntity.status(409).body("Class with name: " + req.getClassName() + " already exists");
        }
        return ResponseEntity.status(201).body("Class created successfully");
    }

    @PostMapping("add-student")
    public ResponseEntity<String> addStudent(@Valid @RequestBody AddStudentRequest req) {
        boolean added = classService.addStudent(req);
        if (!added) {
            return ResponseEntity.status(409).body("Student already exists in class: " + req.getClassId());
        }
        return ResponseEntity.status(201).body("Student successfully added to class: " + req.getClassId());
    }


}
