package com.example.EnglishCenterManager_backend.infoTeacher;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("teacher")
public class InfoTeacherResourse {
 @Autowired
    private InfoTeacherService infoTeacherService;

    @GetMapping("/all")
    public List<InfoTeacher> getAllTeacher() {
        return infoTeacherService.getAll();
    }

    @PostMapping("/add")
     public ResponseEntity<InfoTeacher> addTeacher( @RequestBody InfoTeacher Teacher){
        infoTeacherService.addTeacher(Teacher);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<InfoTeacher> deleteCTeacher(@PathVariable("id") Integer id){
        infoTeacherService.deleteTeacher(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<InfoTeacher> updateTeacher(@PathVariable("id") Integer id, @RequestBody InfoTeacher infoTeacher){
        infoTeacherService.updateTeacher(id,infoTeacher);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    @GetMapping("/{id}")
    public Optional<InfoTeacher> getTeacherById(@PathVariable("id") Integer id){
       return infoTeacherService.getTeacherById(id);
    }
}
