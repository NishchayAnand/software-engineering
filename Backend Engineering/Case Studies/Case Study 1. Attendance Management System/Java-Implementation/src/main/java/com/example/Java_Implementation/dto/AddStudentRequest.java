package com.example.Java_Implementation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Setter @Getter
public class AddStudentRequest {
    @NotBlank(message = "Roll number cannot be empty")
    private String rollNumber;
    @NotBlank(message = "Student name cannot be empty")
    private String name;
}
