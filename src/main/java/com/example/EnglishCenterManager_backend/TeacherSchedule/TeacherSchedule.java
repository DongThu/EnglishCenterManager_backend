package com.example.EnglishCenterManager_backend.TeacherSchedule;

import java.time.LocalDate;

import com.example.EnglishCenterManager_backend.infoTeacher.InfoTeacher;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TeacherSchedule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // trường tăng tự động
    private Integer id;

    @OneToOne
    @JoinColumn(name = "teacherId")
    private InfoTeacher teacher;

    private LocalDate startTime;

    private LocalDate endTime;

    
}
