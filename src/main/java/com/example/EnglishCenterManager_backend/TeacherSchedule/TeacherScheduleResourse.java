package com.example.EnglishCenterManager_backend.TeacherSchedule;

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
@RequestMapping("teacher-schedule")
@CrossOrigin(origins = "http://localhost:4200")
public class TeacherScheduleResourse {
    @Autowired
    private TeacherScheduleService teacherScheduleService;
    
    @PostMapping("/{id}")
    public ResponseEntity<String> AddTeacherSchedule(@PathVariable Integer id, @RequestBody TeacherScheduleRequestDTO request) {

            teacherScheduleService.AddTeacherSchedule(id, request.getStartTime(), request.getEndTime());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        
    }

    @GetMapping("/all")
    public List<TeacherSchedule> getTeacherSchedule() {
        return teacherScheduleService.getTeacherSchedule();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<TeacherSchedule> deleteTeacherSchedule(@PathVariable("id") Integer id){
        teacherScheduleService.deleteTeacherSchedule(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<TeacherSchedule> updateTeacherSchedule(@PathVariable("id") Integer id, @RequestBody TeacherSchedule teacherSchedule){
        teacherScheduleService.updateTeacherSchedule(id,teacherSchedule);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
    
    @GetMapping("/{id}")
    public Optional<TeacherSchedule> getTeacherById(@PathVariable("id") Integer id){
       return teacherScheduleService.getTeacherById(id);
    }
}
