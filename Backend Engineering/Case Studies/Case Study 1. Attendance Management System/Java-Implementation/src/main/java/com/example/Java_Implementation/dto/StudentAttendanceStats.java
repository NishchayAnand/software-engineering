package com.example.Java_Implementation.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class StudentAttendanceStats {
    private String enrollmentId;
    private String name;
    private int totalPresent;
    private int totalAbsent;
    private double attendancePercentage;

    public StudentAttendanceStats(String enrollmentId, String studentName) {
        this.enrollmentId = enrollmentId;
        this.name = name;
    }


}
