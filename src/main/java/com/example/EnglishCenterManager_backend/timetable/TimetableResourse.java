package com.example.EnglishCenterManager_backend.timetable;

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
@RequestMapping("timetable")
@CrossOrigin(origins = "http://localhost:4200")
public class TimetableResourse {
    
    @Autowired
    private TimetableService timetableService;

    @PostMapping("")
    public ResponseEntity<String> createTimetable(@RequestBody TimetableRequestDTO request) {

            timetableService.createTimetable( request.getCourseId(), request.getClassroom(), request.getTeacherId());
            return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // @PutMapping("{id}")
    // public ResponseEntity<Timetable> updateTimetable(@PathVariable("id") Integer id, Timetable timetable) {

    //         timetableService.updateTimetable(id,  timetable);
    //         return ResponseEntity.status(HttpStatus.OK).build();
    // }

    @GetMapping("/all")
    public List<Timetable> getTimetable() {
        return timetableService.getTimetable();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Timetable> deleteTimetable(@PathVariable("id") Integer id){
        timetableService.deleteTimetable(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
    // @PutMapping("/update/{id}")
    // public ResponseEntity<TeacherSchedule> updateTeacherSchedule(@PathVariable("id") Integer id, @RequestBody TeacherSchedule teacherSchedule){
    //     timetableService.updateTeacherSchedule(id,teacherSchedule);
    //     return ResponseEntity.status(HttpStatus.OK).build();
    // }
    
    @GetMapping("/{id}")
    public Optional<Timetable> getTimetableId(@PathVariable("id") Integer id){
       return timetableService.getTimetableId(id);
    }
}
