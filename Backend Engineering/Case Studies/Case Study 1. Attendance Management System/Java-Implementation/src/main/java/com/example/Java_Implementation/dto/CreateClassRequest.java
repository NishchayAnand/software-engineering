package com.example.Java_Implementation.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CreateClassRequest {
    @NotBlank(message = "Class name is required")
    private String className;
    @NotBlank(message = "Teacher name is required")
    private String teacherName;
}
