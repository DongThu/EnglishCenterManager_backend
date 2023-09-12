package com.example.EnglishCenterManager_backend.student;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data //Setter + Getter + ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // trường khóa chính tăng tự động
    private Integer id;//1
    @NotBlank(message = "studentNumber must not be blank") 
    private String studentNumber;//null
    @NotBlank(message = "name must not be blank") 
    private String name;//khoa
    @NotNull(message = "birthday must not be null") 
    private LocalDate birthday;//2001-10-10
    @NotBlank(message = "major must not be blank") 
    private String major;//CNTT
    @NotNull(message = "weight must not be null") 
    private Float weight;//63.9
    @NotBlank(message = "gender must not be blank") 
    private String gender;//Nam
    // public Student(String studentNumber, String name, LocalDate birthday, String major, Float weight, String gender) {
    //     this.studentNumber = studentNumber;
    //     this.name = name;
    //     this.birthday = birthday;
    //     this.major = major;
    //     this.weight = weight;
    //     this.gender = gender;
    // }
}
