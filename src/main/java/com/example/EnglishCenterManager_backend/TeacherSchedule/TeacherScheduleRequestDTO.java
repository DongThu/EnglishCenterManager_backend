package com.example.EnglishCenterManager_backend.TeacherSchedule;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeacherScheduleRequestDTO {
    private Integer id;
    
    private LocalDate startTime;

    private LocalDate endTime;
}
