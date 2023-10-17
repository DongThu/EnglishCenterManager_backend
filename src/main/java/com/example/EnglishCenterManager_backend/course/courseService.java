package com.example.EnglishCenterManager_backend.course;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EnglishCenterManager_backend.courseType.courseType;
import com.example.EnglishCenterManager_backend.courseType.courseTypeRepository;
import com.example.EnglishCenterManager_backend.level.levelRepository;
import jakarta.transaction.Transactional;

@Service
public class courseService {

    @Autowired
    private courseRepository courseRepository;

    private courseTypeRepository courseTypeRepository;

    private levelRepository levelRepository;

    public courseService(courseRepository courseRepository, courseTypeRepository courseTypeRepository,  levelRepository levelRepository){
        this.courseRepository = courseRepository;
        this.courseTypeRepository = courseTypeRepository;
        this.levelRepository = levelRepository;
    }

    public List<course> getAll(){
        return courseRepository.findAll();
    }

    public course findByProgramAndOpenning(String program, LocalDate openning){
        return courseRepository.findByProgramAndOpenning(program, openning);
    }
    
    @Transactional
    public void addCourse(Integer id, String program, String level, float price, String schedule, LocalDate openning, String time){
        courseType english = courseTypeRepository.findByIdEnglish(id);
        
        // level level = levelRepository.findByIdLevel(levelId);

        course course2 = new course();
        
        course2.setEnglish(english);
        course2.setProgram(program);
        course2.setLevel(level);
        course2.setPrice(price);
        course2.setSchedule(schedule);
        course2.setOpenning(openning);
        course2.setTime(time);

        courseRepository.save(course2);
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
        fromDB.setTime(course.getTime());
        return courseRepository.save(fromDB);
    }
     
    public Optional<course> getCourseById(Integer id){
        return courseRepository.findById(id);
    }

    public List<course> findCoursesByEnglishId() {
        List<course> courses = courseRepository.findByEnglishId(1);
        return courses;
    }
    public List<course> findCoursesByEnglishId2() {
        List<course> courses = courseRepository.findByEnglishId(2);
        return courses;
    }    

     public List<course> findCoursesByEnglishId3() {
        List<course> courses = courseRepository.findByEnglishId(3);
        return courses;
    }

    public List<course> findCoursesByEnglishId4() {
        List<course> courses = courseRepository.findByEnglishId(4);
        return courses;
    }

    public List<course> findCoursesByEnglishId5() {
        List<course> courses = courseRepository.findByEnglishId(5);
        return courses;
    }
}
