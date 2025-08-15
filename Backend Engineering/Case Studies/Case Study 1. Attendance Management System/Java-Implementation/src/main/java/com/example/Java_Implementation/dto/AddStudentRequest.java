package com.example.Java_Implementation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Setter @Getter
public class AddStudentRequest {
    @NotBlank(message = "Class Id cannot be empty")
    private String classId;
    @NotBlank(message = "Student name cannot be blank")
    private String name;
    @NotBlank(message = "Student enrollment number cannot be empty")
    private String enrollmentNumber;
}
