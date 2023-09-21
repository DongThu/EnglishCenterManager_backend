package com.example.EnglishCenterManager_backend.classChild;


import com.example.EnglishCenterManager_backend.course.course;
import com.example.EnglishCenterManager_backend.user.User;

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
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class ClassChild {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
       
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    
    @ManyToOne
    @JoinColumn(name = "courseId")
    private course course;


    public ClassChild(User user, course course) {
        this.user = user;
        this.course = course;
    }
}
