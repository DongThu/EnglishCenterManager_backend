package com.example.EnglishCenterManager_backend.level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/level")
public class levelResoure {
    
    @Autowired
    private levelService levelService;

    @PostMapping("")
    public ResponseEntity<String> createLevel(@RequestBody levelRequest request){
       levelService.createLevel(request.getNameLevel(), request.getProgramId());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
