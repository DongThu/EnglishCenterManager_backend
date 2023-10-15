package com.example.EnglishCenterManager_backend.program;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProgramRequest {
    String nameProgram;
    Integer englishId;
}
