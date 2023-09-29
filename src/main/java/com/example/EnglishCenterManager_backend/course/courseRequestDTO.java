package com.example.EnglishCenterManager_backend.course;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class courseRequestDTO {
    
    private String program;

    private LocalDate openning;
}
