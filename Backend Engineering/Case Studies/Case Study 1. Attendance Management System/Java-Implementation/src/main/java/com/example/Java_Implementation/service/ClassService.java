package com.example.Java_Implementation.service;

public interface ClassService {
    CreateClassResponse createClass(CreateClassRequest req);
    AddStudentResponse addStudentToClass(AddStudentRequest req);
    List<SchoolClass> getAllClasses();
}
