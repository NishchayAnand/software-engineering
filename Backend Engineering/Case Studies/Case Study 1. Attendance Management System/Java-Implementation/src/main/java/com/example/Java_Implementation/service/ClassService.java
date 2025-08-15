package com.example.Java_Implementation.service;

import com.example.Java_Implementation.dto.AddStudentRequest;
import com.example.Java_Implementation.dto.AttendanceRecord;
import com.example.Java_Implementation.dto.CreateClassRequest;

import java.time.LocalDate;
import java.util.List;

public interface ClassService {
    boolean createClass(String name, String teacherName);
    boolean addStudent(String classId, String enrollmentId, String name);
    boolean markAttendance(String classId, LocalDate date, List<AttendanceRecord> records);
    //List<ClassEntity> getAllClasses();
}
