package com.example.EnglishCenterManager_backend.infoTeacher;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="infoteacher")
public class InfoTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String fullName;
    // private String image;
    private LocalDate birthDay;
    private String email;
    private Number phone;
    private String address;
    private String teachProgram;
    private Integer levelSalary;


}
