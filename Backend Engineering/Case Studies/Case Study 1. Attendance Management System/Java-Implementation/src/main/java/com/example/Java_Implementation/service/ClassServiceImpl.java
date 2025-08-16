package com.example.Java_Implementation.service;

import com.example.Java_Implementation.dto.AttendanceReport;
import com.example.Java_Implementation.dto.AttendanceRecord;
import com.example.Java_Implementation.model.ClassEntity;
import com.example.Java_Implementation.model.StudentEntity;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class ClassServiceImpl implements ClassService {

    // In-memory storage
    private final Map<String, ClassEntity> classMap = new ConcurrentHashMap<>();
    private int classCounter;

    @Override
    public boolean createClass(String name, String teacherName) {
        // Step 1: Check if class with same name already exists
        boolean exists = classMap.values().stream()
                .anyMatch(obj -> obj.getName().equalsIgnoreCase(name));
        if(exists) return false;

        // Step 2: Generate a unique class id
        String classId = generateClassId();
        // Step 3: Create a new class
        ClassEntity newClass = new ClassEntity(classId, name, teacherName);
        classMap.put(classId, newClass);

        return true;
    }

    @Override
    public boolean addStudent(String classId, String enrollmentId, String name) {
        ClassEntity classEntity = classMap.get(classId);
        // Step 1: Check if the student already exists in the class
        boolean exists = classEntity.getStudents().containsKey(enrollmentId);
        if(exists) return false;
        // step 2: Create a student and add it to the target class
        StudentEntity student = new StudentEntity(enrollmentId, name);
        classEntity.getStudents().put(enrollmentId, student);
        return true;
    }

    @Override
    public boolean markAttendance(String classId, LocalDate date, List<AttendanceRecord> records) {
        ClassEntity classEntity = classMap.get(classId);
        // Step 1: Check if attendance for today's date is already marked
        boolean exists = classEntity.getAttendanceRecords().containsKey(date);
        if(exists) return false;
        // Step 2: Add attendance records for today's date to the target class
        classEntity.getAttendanceRecords().put(date, records);
        return true;
    }

    @Override
    public AttendanceReport generateReport(String classId, LocalDate startDate, LocalDate endDate) {
        // Step 1: Filter AttendanceRecords between startDate and endDate
        ClassEntity classEntity = classMap.get(classId);
        Map<LocalDate, List<AttendanceRecord>> records = classEntity.getAttendanceRecords();
        List<AttendanceRecord> filteredRecords = records.entrySet().stream()
                .filter(entry -> !entry.getKey().isBefore(startDate) && !entry.getKey().isAfter(endDate))
                .flatMap(entry -> entry.getValue().stream())
                .toList();
        // Step 2: Iterate over each filtered AttendanceRecord and populate each student's AttendanceStats

        return null;
    }

    // ========== UTILITY METHODS ==========

    private String generateClassId() {
        return "CLASS_" + String.format("%04d", ++classCounter);
    }

}
