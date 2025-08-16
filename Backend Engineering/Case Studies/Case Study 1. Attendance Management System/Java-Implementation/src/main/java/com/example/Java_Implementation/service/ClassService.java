package com.example.Java_Implementation.service;

import com.example.Java_Implementation.dto.AttendanceReport;
import com.example.Java_Implementation.dto.StudentAttendanceRecord;

import java.time.LocalDate;
import java.util.List;

public interface ClassService {
    boolean createClass(String name, String teacherName);
    boolean addStudent(String classId, String enrollmentId, String name);
    boolean markAttendance(String classId, LocalDate date, List<StudentAttendanceRecord> records);
    AttendanceReport generateReport(String classId, LocalDate startDate, LocalDate endDate);
    //List<ClassEntity> getAllClasses();
}
