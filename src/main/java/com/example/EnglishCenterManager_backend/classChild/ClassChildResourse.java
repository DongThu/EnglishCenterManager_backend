package com.example.EnglishCenterManager_backend.classChild;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("register-course")
@CrossOrigin(origins = "http://localhost:4200")
public class ClassChildResourse {
    @Autowired
    private ClassChildService classChildService;


    @GetMapping("/all")
    public List<ClassChild> getAllCourse() {
        return classChildService.getAll();
    }

    // @PostMapping("")
    // public ClassChild registerStudent(@RequestBody ClassChildRequestDTO request) {
    //     return classChildService.registerCourse(request);
    // }

    @GetMapping("/{courseId}")
    public List<Object[]> findClassChildWithUserName(@PathVariable Integer courseId) {
        return classChildService.findClassChildWithUserName(courseId);
    }


    @GetMapping
    public List<Object[]> getAllCourseStudentsWithStudentName() {
        return classChildService.getAllCourseStudentsWithStudentName();
    }

    //  @PostMapping("")
    // public ResponseEntity<String> registerCourseStudent(@RequestBody ClassChildRequestDTO request) {
    //     // try {
    //         classChildService.registerCourseStudent(request.getProgram(),request.getLevel(), request.getPrice(), request.getSchedule(), request.getOpenning(), request.getTime(), request.getEmail());
    //         // return ResponseEntity.ok("Registered successfully");
    //         return ResponseEntity.status(HttpStatus.CREATED).build();
    //     // } catch (Exception e) {
    //         // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register");
    //     // }
    // }

    @PostMapping("/{id}")
    public ResponseEntity<String> registerCourse(@PathVariable Integer id, @RequestBody ClassChildRequestDTO request) {

            classChildService.registerCourse(id, request.getEmail());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        
    }
}
