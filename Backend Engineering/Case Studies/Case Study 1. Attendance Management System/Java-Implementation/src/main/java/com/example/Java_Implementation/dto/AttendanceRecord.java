package com.example.Java_Implementation.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
public class AttendanceRecord {
    private String enrollmentId;
    private String status; // PRESENT / ABSENT
}
