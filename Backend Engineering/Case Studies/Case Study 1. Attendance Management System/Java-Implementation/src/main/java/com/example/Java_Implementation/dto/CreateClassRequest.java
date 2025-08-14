package com.example.Java_Implementation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class CreateClassRequest {

    private String className;
    private String teacherName;
}
