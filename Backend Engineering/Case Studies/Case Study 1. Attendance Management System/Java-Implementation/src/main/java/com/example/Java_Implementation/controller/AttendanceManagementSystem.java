package com.example.Java_Implementation.controller;

import com.example.Java_Implementation.service.AttendanceService;
import com.example.Java_Implementation.service.ClassService;
import com.example.Java_Implementation.service.ReportService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class AttendanceManagementSystem {

    private final ClassService classService;
    private final AttendanceService attendanceService;
    private final ReportService reportService;

    public AttendanceManagementSystem(ClassService classService, AttendanceService attendanceService,
                                      ReportService reportService) {
        this.classService = classService;
        this.attendanceService = attendanceService;
        this.reportService = reportService;
    }


}
