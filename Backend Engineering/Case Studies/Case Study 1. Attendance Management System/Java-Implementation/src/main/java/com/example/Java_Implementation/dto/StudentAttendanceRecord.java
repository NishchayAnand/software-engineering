package com.example.Java_Implementation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
public class StudentAttendanceRecord {
    private String enrollmentId;
    private String name;
    private String status; // PRESENT / ABSENT
}
