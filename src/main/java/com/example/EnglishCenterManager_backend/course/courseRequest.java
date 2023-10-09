package com.example.EnglishCenterManager_backend.course;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class courseRequest {
    private Integer id;
    private String program;
    private String level;
    private float price;
    private String schedule;
    private LocalDate openning;
    private String time;
}
