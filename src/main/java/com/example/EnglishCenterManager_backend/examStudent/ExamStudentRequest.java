package com.example.EnglishCenterManager_backend.examStudent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamStudentRequest {
    
    private Integer userId;

    private Integer examId;

    private Integer score;

}
