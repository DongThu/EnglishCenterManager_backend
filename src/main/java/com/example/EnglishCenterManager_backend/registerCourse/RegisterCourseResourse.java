package com.example.EnglishCenterManager_backend.registerCourse;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EnglishCenterManager_backend.infoTeacher.InfoTeacher;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("register")
public class RegisterCourseResourse {

    @Autowired
    private RegisterCourseService registerCourseService;
     
    @GetMapping("/all")
    public List<RegisterCourse> getListRegister() {
        return registerCourseService.getListRegister();
    }
    @PostMapping("")
    public ResponseEntity<RegisterCourse> registerCourse(@RequestBody RegisterCourse register){
        registerCourseService.registerCourse(register);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<InfoTeacher> deleteRegister(@PathVariable("id") Integer id){
        registerCourseService.deleteRegister(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
