package com.example.EnglishCenterManager_backend.course;

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
@RequestMapping("course")
public class courseResourse {
    @Autowired
    private courseService courseService;

    @GetMapping("/all")
    public List<course> getAllCourse() {
        return courseService.getAll();
    }

    @PostMapping("/add")
     public ResponseEntity<course> addCourse( @RequestBody course Course){
        courseService.addCourse(Course);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<course> deleteCourse(@PathVariable("id") Integer id){
        courseService.deleteCourse(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<course> updateCourse(@PathVariable("id") Integer id, @RequestBody course Course){
        courseService.updateCourse(id,Course);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    @GetMapping("/{id}")
    public Optional<course> getCourseById(@PathVariable("id") Integer id){
       return courseService.getCourseById(id);
    }
}
