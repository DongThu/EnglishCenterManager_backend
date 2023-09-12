package com.example.EnglishCenterManager_backend.level;

import com.example.EnglishCenterManager_backend.course.course;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class level {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer level_id;
    private String levelName;
    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "course_id")
    // private course Course;
}
