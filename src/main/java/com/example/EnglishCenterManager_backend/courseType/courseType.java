package com.example.EnglishCenterManager_backend.courseType;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class courseType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String englishName;

    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "course_id")
    // private course Course;
}
