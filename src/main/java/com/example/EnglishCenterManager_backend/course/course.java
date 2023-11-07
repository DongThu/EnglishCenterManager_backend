package com.example.EnglishCenterManager_backend.course;

import java.time.LocalDate;

import com.example.EnglishCenterManager_backend.courseType.courseType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer course_id;
        
    @ManyToOne
    @JoinColumn(name = "englishId")
    private courseType english;
    private String program;
    private String level;
    private float price;
    private String schedule;
    private LocalDate openning;
    private double time;
    
    public course(Integer course_id) {
        this.course_id = course_id;
    }

    
}
