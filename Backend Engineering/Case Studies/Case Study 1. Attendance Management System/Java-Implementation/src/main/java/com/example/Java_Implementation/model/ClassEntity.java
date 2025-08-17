package com.example.Java_Implementation.model;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter @Setter
public class ClassEntity {
    private final String id;
    private final String name;
    private final String teacherName;
    private final Map<String, StudentEntity> studentRegistry = new HashMap<>();
    private final Map<LocalDate, List<StudentAttendanceRecord>> attendanceRegistry = new HashMap<>();

    public ClassEntity(String id, String name, String teacherName) {
        this.id = id;
        this.name = name;
        this.teacherName = teacherName;
    }
}
