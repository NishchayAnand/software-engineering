package com.example.Java_Implementation.service;

import com.example.Java_Implementation.dto.CreateClassRequest;
import com.example.Java_Implementation.dto.CreateClassResponse;

public interface ClassService {
    CreateClassResponse createClass(CreateClassRequest req);
    //AddStudentResponse addStudentToClass(AddStudentRequest req);
    //List<ClassEntity> getAllClasses();
}
