package com.example.Java_Implementation.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Setter
public class CreateClassResponse {
    private String classId;
    private LocalDateTime createAt;
    private String statusMessage;
}
