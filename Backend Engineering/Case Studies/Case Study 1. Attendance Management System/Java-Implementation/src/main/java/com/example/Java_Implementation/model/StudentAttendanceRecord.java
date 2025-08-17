package com.example.Java_Implementation.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
public class StudentAttendanceRecord {
    private String enrollmentId;
    private String name;
    private String attendanceStatus; // PRESENT / ABSENT
}
