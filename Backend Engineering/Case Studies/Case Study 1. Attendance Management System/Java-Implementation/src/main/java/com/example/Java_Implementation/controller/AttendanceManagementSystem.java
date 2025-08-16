package com.example.Java_Implementation.controller;

import com.example.Java_Implementation.dto.AddStudentRequest;
import com.example.Java_Implementation.dto.CreateClassRequest;
import com.example.Java_Implementation.dto.MarkAttendanceRequest;
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
        boolean created = classService.createClass(req.getClassName(), req.getTeacherName());
        return created ? ResponseEntity.status(201).body("Class created successfully") :
                ResponseEntity.status(409).body("Class already exists");
    }

    @PostMapping("/add-student")
    public ResponseEntity<String> addStudent(@PathVariable String classId, @Valid @RequestBody AddStudentRequest req) {
        boolean added = classService.addStudent(classId, req.getEnrollmentId(), req.getName());
        return added ? ResponseEntity.status(201).body("Student added successfully") :
                ResponseEntity.status(409).body("Student already exists");
    }

    @PostMapping("mark-attendance")
    public ResponseEntity<String> markAttendance(@PathVariable String classId,
                                                 @Valid @RequestBody MarkAttendanceRequest req) {
        boolean ok = classService.markAttendance(classId, req.getDate(), req.getRecords());
        return ok ? ResponseEntity.ok("Attendance marked successfully") :
                ResponseEntity.status(500).body("Failed to save");
    }


}
