package com.example.EnglishCenterManager_backend.period;


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
public class period {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer level_id;
    private String periodName;

    // @OneToMany(cascade = CascadeType.ALL)
    // @JoinColumn(name = "course_id")
    // private course Course;
}
