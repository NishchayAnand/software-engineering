package com.example.Java_Implementation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Setter @Getter
public class AddStudentRequest {
    @NotBlank(message = "Student enrollment number cannot be empty")
    private String enrollmentId;
    @NotBlank(message = "Student name cannot be blank")
    private String name;
}
