package com.example.Java_Implementation.service;

import com.example.Java_Implementation.dto.AddStudentRequest;
import com.example.Java_Implementation.dto.CreateClassRequest;
import com.example.Java_Implementation.model.ClassEntity;
import com.example.Java_Implementation.model.StudentEntity;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClassServiceImpl implements ClassService {

    // In-memory storage
    private final Map<String, ClassEntity> classMap = new ConcurrentHashMap<>();
    private int classCounter;

    @Override
    public boolean createClass(CreateClassRequest req) {
        // Step 1: Check if class with same name already exists
        boolean exists = classMap.values().stream()
                .anyMatch(obj -> obj.getName().equalsIgnoreCase(req.getClassName()));
        if(exists) return false;

        // Step 2: Generate a unique class id
        String classId = generateClassId();
        // Step 3: Create a new class
        ClassEntity newClass = new ClassEntity(classId, req.getClassName(), req.getTeacherName());
        classMap.put(classId, newClass);

        return true;
    }

    @Override
    public boolean addStudent(AddStudentRequest req) {
        ClassEntity classEntity = classMap.get(req.getClassId());
        // Step 1: Check if the student already exists in the class
        boolean exists = classEntity.getStudents().containsKey(req.getEnrollmentNumber());
        if(exists) return false;
        // step 2: Create a student and add it to the target class
        StudentEntity student = new StudentEntity(req.getEnrollmentNumber(), req.getName());
        classEntity.getStudents().put(req.getEnrollmentNumber(), student);
        return true;
    }

    // ========== UTILITY METHODS ==========

    private String generateClassId() {
        return "CLASS_" + String.format("%04d", ++classCounter);
    }

}
