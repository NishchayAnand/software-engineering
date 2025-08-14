package com.example.Java_Implementation.service;

import com.example.Java_Implementation.dto.CreateClassRequest;
import com.example.Java_Implementation.dto.CreateClassResponse;
import com.example.Java_Implementation.model.SchoolClass;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class ClassServiceImpl implements ClassService {

    // In-memory storage
    private final Map<String, SchoolClass> classMap = new ConcurrentHashMap<>();
    private int classCounter;

    @Override
    public CreateClassResponse createClass(CreateClassRequest req) {

        // Check if class with same name already exists
        boolean exists = classMap.values().stream()
                .anyMatch(obj -> obj.getName().equalsIgnoreCase(req.getClassName()));
        if(exists) {
            return new CreateClassResponse(
                    null,
                    LocalDateTime.now(),
                    "Class with name: " + req.getClassName() + " already exists.");
        }

        // Create a new class
        String classId = generateClassId();
        SchoolClass newClass = new SchoolClass(classId, req.getClassName(), req.getTeacherName());
        classMap.put(classId, newClass);

        return new CreateClassResponse(
                classId,
                LocalDateTime.now(),
                "Class created successfully");

    }

    // ========== UTILITY METHODS ==========

    private String generateClassId() {
        return "CLASS_" + String.format("%04d", ++classCounter);
    }
}
