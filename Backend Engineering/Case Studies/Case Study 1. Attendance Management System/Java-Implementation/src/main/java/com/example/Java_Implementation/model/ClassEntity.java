package com.example.Java_Implementation.model;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class ClassEntity {
    private final String classId;
    private final String name;
    private final String teacherName;
    private final Map<String, StudentEntity> students = new HashMap<>();

    public ClassEntity(String classId, String name, String teacherName) {
        this.classId = classId;
        this.name = name;
        this.teacherName = teacherName;
    }
}
