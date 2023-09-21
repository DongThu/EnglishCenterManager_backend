package com.example.EnglishCenterManager_backend.course;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;
    private String program;
    private String level;
    private float price;
    private String schedule;
    private LocalDate openning;
    private String time;
    
    public course(Integer course_id) {
        this.course_id = course_id;
    }

    
}
