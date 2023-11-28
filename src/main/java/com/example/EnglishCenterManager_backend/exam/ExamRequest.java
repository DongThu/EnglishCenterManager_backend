package com.example.EnglishCenterManager_backend.exam;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamRequest {
    
    @NotNull
    private Integer courseId;

    @NotNull
    private Integer quizId;
}
