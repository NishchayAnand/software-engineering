package com.example.Java_Implementation.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor @Getter @Setter
public class GenerateReportRequest {
    @NotNull(message = "Start date cannot be empty")
    private LocalDate startDate;
    @NotNull(message = "End date cannot be empty")
    private LocalDate endDate;
}
