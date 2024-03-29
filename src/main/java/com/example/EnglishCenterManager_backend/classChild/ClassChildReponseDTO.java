package com.example.EnglishCenterManager_backend.classChild;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ClassChildReponseDTO {
        private String program;
        private String level;
        private float price;
        private String schedule;
        private LocalDate openning;
        private String time;
        private String username;
        private Number phone;
}
