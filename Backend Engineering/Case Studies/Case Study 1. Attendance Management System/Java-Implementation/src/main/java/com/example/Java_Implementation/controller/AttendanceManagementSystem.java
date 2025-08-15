package com.example.Java_Implementation.controller;

import com.example.Java_Implementation.dto.AddStudentRequest;
import com.example.Java_Implementation.dto.AddStudentResponse;
import com.example.Java_Implementation.dto.CreateClassRequest;
import com.example.Java_Implementation.dto.CreateClassResponse;
import com.example.Java_Implementation.service.AttendanceService;
import com.example.Java_Implementation.service.ClassService;
import com.example.Java_Implementation.service.ReportService;
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
    public ResponseEntity<CreateClassResponse> createClass(@Valid @RequestBody CreateClassRequest req) {
        String classId = classService.createClass(req);
        if (classId == null) {
            return ResponseEntity.status(409).body(new CreateClassResponse(
                    null,
                    "Class with name: " + req.getClassName() + " already exists")
            );
        }
        return ResponseEntity.status(201).body(new CreateClassResponse(
                classId,
                "Class created successfully")
        );
    }

    @PostMapping("add-student")
    public ResponseEntity<AddStudentResponse> addStudent(@Valid @RequestBody AddStudentRequest req) {
        String studentId = classService.addStudent(req);
        if (studentId == null) {
            return ResponseEntity.status(409).body(new AddStudentResponse(
                    null,
                    "Student already exists in class: " + req.getClassId())
            );
        }
        return ResponseEntity.status(201).body(new AddStudentResponse(
                studentId,
                "Student successfully added to class: " + req.getClassId())
        );
    }


}
