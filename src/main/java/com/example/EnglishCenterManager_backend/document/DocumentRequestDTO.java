package com.example.EnglishCenterManager_backend.document;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocumentRequestDTO {
    
    private String nameDocument;

    private String typeDocument;

    private MultipartFile file;
}
