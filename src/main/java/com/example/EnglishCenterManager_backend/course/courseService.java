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
        fromDB.setCourseType_id(course.getCourseType_id());
        fromDB.setPeriod_id(course.getPeriod_id());
        fromDB.setPrice(course.getPrice());
        fromDB.setStart_time(course.getStart_time());
        fromDB.setCourseType_id(course.getCourseType_id());
        fromDB.setDescription(course.getDescription());
        fromDB.setLevel_id(course.getLevel_id());
        return courseRepository.save(fromDB);
    }
     
    public Optional<course> getCourseById(Integer id){
        return courseRepository.findById(id);
    }
}
