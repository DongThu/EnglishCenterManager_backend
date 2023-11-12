package com.example.EnglishCenterManager_backend.course;

import java.time.LocalDate;
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

    @PostMapping("/programOpenning")
    public course findByProgramAndOpenning(@RequestBody courseRequestDTO requestDTO) {
        String program = requestDTO.getProgram();
        LocalDate openning = requestDTO.getOpenning();
        return courseService.findByProgramAndOpenning(program, openning);
    }

    @PostMapping("/add")
     public ResponseEntity<String> addCourse( @RequestBody courseRequest request){
        courseService.addCourse(request.getId(), request.getProgram(), request.getLevel(), request.getPrice(), request.getSchedule(), request.getOpenning(), request.getTime());
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

    @GetMapping("/getEnglish")
    public List<course> findByEnglishId(){
       return courseService.findCoursesByEnglishId();
    }

     @GetMapping("/getEnglish2")
    public List<course> findByEnglishId2(){
       return courseService.findCoursesByEnglishId2();
    }

     @GetMapping("/getEnglish3")
    public List<course> findByEnglishId3(){
       return courseService.findCoursesByEnglishId3();
    }

     @GetMapping("/getEnglish4")
    public List<course> findByEnglishId4(){
       return courseService.findCoursesByEnglishId4();
    }

     @GetMapping("/getEnglish5")
    public List<course> findByEnglishId5(){
       return courseService.findCoursesByEnglishId5();
    }

    @GetMapping("/by-month/{month}")
    public List<course> getCoursesByMonth(@PathVariable int month) {
        return courseService.findCoursesByMonth(month);
    }
}
