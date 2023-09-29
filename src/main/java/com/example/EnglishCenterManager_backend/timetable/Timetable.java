package com.example.EnglishCenterManager_backend.timetable;


import com.example.EnglishCenterManager_backend.course.course;
import com.example.EnglishCenterManager_backend.infoTeacher.InfoTeacher;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Timetable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // trường tăng tự động
    private Integer id;
    
    private String classroom;

    @OneToOne
    @JoinColumn(name = "courseId")
    private course course;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    private InfoTeacher teacher;

}
