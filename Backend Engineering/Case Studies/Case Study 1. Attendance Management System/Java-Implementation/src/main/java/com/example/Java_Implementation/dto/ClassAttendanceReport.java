package com.example.Java_Implementation.dto;

import lombok.AllArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
public class ClassAttendanceReport {
    private final String className;
    private final LocalDate startDate;
    private final LocalDate endDate;
    private final List<StudentAttendanceStats> attendanceSummary;
}
