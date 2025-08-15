package com.example.Java_Implementation.service;

import com.example.Java_Implementation.dto.AddStudentRequest;
import com.example.Java_Implementation.dto.AddStudentResponse;
import com.example.Java_Implementation.dto.CreateClassRequest;

public interface ClassService {
    String createClass(CreateClassRequest req);
    String addStudent(AddStudentRequest req);
    //List<ClassEntity> getAllClasses();
}
