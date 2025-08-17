package com.example.Java_Implementation.dto;

import com.example.Java_Implementation.model.StudentAttendanceRecord;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@NoArgsConstructor @Getter @Setter
public class MarkAttendanceRequest {
    @NotNull
    private LocalDate date;
    @NotEmpty
    private List<StudentAttendanceRecord> records;
}
