package com.example.Java_Implementation.service;

import com.example.Java_Implementation.dto.AddStudentRequest;
import com.example.Java_Implementation.dto.CreateClassRequest;
import com.example.Java_Implementation.dto.CreateClassResponse;
import com.example.Java_Implementation.model.ClassEntity;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ClassServiceImpl implements ClassService {

    // In-memory storage
    private final Map<String, ClassEntity> classMap = new ConcurrentHashMap<>();
    private int classCounter;

    @Override
    public String createClass(CreateClassRequest req) {
        // Check if class with same name already exists
        boolean exists = classMap.values().stream()
                .anyMatch(obj -> obj.getName().equalsIgnoreCase(req.getClassName()));
        if(exists) return null;

        // Create a new class
        String classId = generateClassId();
        ClassEntity newClass = new ClassEntity(classId, req.getClassName(), req.getTeacherName());
        classMap.put(classId, newClass);
        return classId;
    }

    @Override
    public String addStudent(AddStudentRequest req) {
        return null;
    }

    // ========== UTILITY METHODS ==========

    private String generateClassId() {
        return "CLASS_" + String.format("%04d", ++classCounter);
    }
}
