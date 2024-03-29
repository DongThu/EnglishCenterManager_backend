package com.example.EnglishCenterManager_backend.level;

import com.example.EnglishCenterManager_backend.program.Program;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "englishId")
    private Program english;
}
