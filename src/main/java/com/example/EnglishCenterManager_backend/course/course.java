package com.example.EnglishCenterManager_backend.course;

import java.time.LocalDate;

import com.example.EnglishCenterManager_backend.courseType.courseType;
import com.example.EnglishCenterManager_backend.level.level;
import com.example.EnglishCenterManager_backend.period.period;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
    private String program;
    private String level;
    private float price;
    private String schedule;
    private LocalDate openning;

}
