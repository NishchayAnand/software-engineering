package com.example.Java_Implementation.controller;

import com.example.Java_Implementation.dto.*;
import com.example.Java_Implementation.model.StudentEntity;
import com.example.Java_Implementation.service.ClassService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AttendanceManagementSystem {

    private final ClassService classService;

    @Autowired
    public AttendanceManagementSystem(ClassService classService) {
        this.classService = classService;
    }

    @PostMapping("/class/create-class")
    public ResponseEntity<String> createClass(@Valid @RequestBody CreateClassRequest req) {
        boolean created = classService.createClass(req.getClassName(), req.getTeacherName());
        return created ? ResponseEntity.status(201).body("Class created successfully") :
                ResponseEntity.status(409).body("Class already exists");
    }

    @GetMapping("/class/classes")
    public ResponseEntity<List<ClassDetailsResponse>> getAllClasses() {
        List<ClassDetailsResponse> response = classService.getClasses().stream()
                .map(c -> new ClassDetailsResponse(c.getId(), c.getName()))
                .toList();
        return ResponseEntity.ok(response);
    }

    @PostMapping("/student/add-student/{clasId}")
    public ResponseEntity<String> addStudentToClass(@PathVariable String classId, @Valid @RequestBody AddStudentRequest req) {
        boolean added = classService.addStudent(classId, req.getEnrollmentId(), req.getName());
        return added ? ResponseEntity.status(201).body("Student added successfully") :
                ResponseEntity.status(409).body("Student already exists");
    }

    @GetMapping("/students/{classId}")
    public ResponseEntity<List<StudentEntity>> getStudentsByClass(@PathVariable String classId) {
        List<StudentEntity> students = classService.getStudents(classId);
        return ResponseEntity.ok(students);
    }

    @PostMapping("/attendance/mark-attendance/{classId}")
    public ResponseEntity<String> markClassAttendance(@PathVariable String classId,
                                                 @Valid @RequestBody MarkAttendanceRequest req) {
        boolean ok = classService.markAttendance(classId, req.getDate(), req.getRecords());
        return ok ? ResponseEntity.ok("Attendance marked successfully") :
                ResponseEntity.status(500).body("Failed to save");
    }

    @GetMapping("/report/attendance-report/{classId}")
    public ResponseEntity<ClassAttendanceReport> generateClassAttendanceReport(@PathVariable String classId, @Valid @RequestBody GenerateReportRequest req) {
        ClassAttendanceReport report = classService.generateAttendanceReport(classId, req.getStartDate(), req.getEndDate());
        return ResponseEntity.ok(report);
    }

}
