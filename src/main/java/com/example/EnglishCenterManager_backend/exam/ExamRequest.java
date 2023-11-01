package com.example.EnglishCenterManager_backend.exam;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamRequest {
    
    private Integer courseId;

    private Integer quizId;
}
