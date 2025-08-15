package com.example.Java_Implementation.service;

import com.example.Java_Implementation.dto.AddStudentRequest;
import com.example.Java_Implementation.dto.CreateClassRequest;

public interface ClassService {
    boolean createClass(CreateClassRequest req);
    boolean addStudent(AddStudentRequest req);
    //List<ClassEntity> getAllClasses();
}
