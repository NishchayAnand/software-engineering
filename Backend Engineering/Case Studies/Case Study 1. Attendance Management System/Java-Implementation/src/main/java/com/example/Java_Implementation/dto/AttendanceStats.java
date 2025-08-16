package com.example.Java_Implementation.dto;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class AttendanceStats {
    private final String enrollmentId;
    private final String studentName;
    private final int totalPresent;
    private final int totalAbsent;
    private final float attendancePercentage;
}
