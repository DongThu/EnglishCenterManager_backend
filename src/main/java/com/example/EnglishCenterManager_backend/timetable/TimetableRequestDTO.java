package com.example.EnglishCenterManager_backend.timetable;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TimetableRequestDTO {

    private Integer courseId;
    
    private String classroom;

    private Integer teacherId;

    // private  String program;

    // private LocalDate openning;

}
