package com.example.EnglishCenterManager_backend.course;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class courseService {

    @Autowired
    private courseRepository courseRepository;

    public List<course> getAll(){
        return courseRepository.findAll();
    }
    @Transactional
    public void addCourse(course Course){
        courseRepository.save(Course);
    }
    public void deleteCourse(Integer id){
        courseRepository.deleteById(id);
    }
    // public course findByCourseId(Integer Course_id){
    //     course Course = courseRepository.findByCourseId(Course_id);
    //     return Course;
    // }
    public course updateCourse(Integer id, course course) {
        course fromDB = courseRepository.findById(id).orElse(null);
        if (fromDB == null){
            return null;
        }
        fromDB.setProgram(course.getProgram());
        fromDB.setLevel(course.getLevel());
        fromDB.setPrice(course.getPrice());
        fromDB.setSchedule(course.getSchedule());
        fromDB.setOpenning(course.getOpenning());
        return courseRepository.save(fromDB);
    }
     
    public Optional<course> getCourseById(Integer id){
        return courseRepository.findById(id);
    }
}
