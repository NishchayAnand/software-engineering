package com.example.Java_Implementation.service;

import com.example.Java_Implementation.dto.ClassAttendanceReport;
import com.example.Java_Implementation.model.ClassEntity;
import com.example.Java_Implementation.model.StudentAttendanceRecord;
import com.example.Java_Implementation.model.StudentEntity;

import java.time.LocalDate;
import java.util.List;

public interface ClassService {
    boolean createClass(String name, String teacherName);
    boolean addStudent(String classId, String enrollmentId, String name);
    boolean markAttendance(String classId, LocalDate date, List<StudentAttendanceRecord> records);
    ClassAttendanceReport generateAttendanceReport(String classId, LocalDate startDate, LocalDate endDate);
    List<ClassEntity> getClasses();
    List<StudentEntity> getStudents(String classId);
}
