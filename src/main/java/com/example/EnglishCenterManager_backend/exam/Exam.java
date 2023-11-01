package com.example.EnglishCenterManager_backend.exam;

import com.example.EnglishCenterManager_backend.course.course;
import com.example.EnglishCenterManager_backend.quiz.Quiz;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "courseId")
    private course course;

    @ManyToOne
    @JoinColumn(name = "quizId")
    private Quiz quiz;

    
}
