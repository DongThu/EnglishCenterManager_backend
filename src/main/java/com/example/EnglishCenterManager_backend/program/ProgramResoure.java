package com.example.EnglishCenterManager_backend.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EnglishCenterManager_backend.infoTeacher.InfoTeacher;


@RestController
@RequestMapping("/program")
public class ProgramResoure {
    
    @Autowired
    private ProgramService levelService;

    @PostMapping("")
    public ResponseEntity<String> createLevel(@RequestBody ProgramRequest request){
       levelService.createLevel(request.getNameProgram(), request.englishId);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/all")
    public List<Program> getAllTeacher() {
        return levelService.getAll();
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Program> deleteCTeacher(@PathVariable("id") Integer id){
        levelService.deleteTeacher(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
