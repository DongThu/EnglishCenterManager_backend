package com.example.EnglishCenterManager_backend.classChild;

import org.springframework.stereotype.Service;

import com.example.EnglishCenterManager_backend.course.course;
import com.example.EnglishCenterManager_backend.course.courseRepository;
import com.example.EnglishCenterManager_backend.user.User;
import com.example.EnglishCenterManager_backend.user.UserRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

@Service
public class ClassChildService {
    
    @Autowired
    private ClassChildRepository classChildRepository;

    private UserRepository userRepository;

    private courseRepository courseRepository;

    public ClassChildService(ClassChildRepository classChildRepository, UserRepository userRepository, courseRepository courseRepository) {
        this.classChildRepository = classChildRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    // public ClassChildService(courseRepository courseRepository) {
    //     this.courseRepository = courseRepository;
    // }

    // public ClassChild registerCourse(ClassChildRequestDTO classChildRequestDTO){

    //     User user = new User(classChildRequestDTO.getUsername());
    //     course course = new course(classChildRequestDTO.getCourseId());
    //     // ClassChild existingClassChild = classChildRepository.findByUserAndCourse(user, course);
    //     // if (existingClassChild != null) {
    //     //     throw new IllegalArgumentException("Student has already registered for this course");
    //     // }
    //     ClassChild classChild = new ClassChild();
    //     classChild.setUser(user);
    //     classChild.setCourse(course);
        
    //     return classChildRepository.save(classChild);
    // }

        public List<ClassChild> getAll(){
        return classChildRepository.findAll();
    }

    public List<Object[]> findClassChildWithUserName(Integer courseId) {
        return classChildRepository.findClassChildWithUserName(courseId);
    }

    public List<Object[]> getAllCourseStudentsWithStudentName() {
        return classChildRepository.findAllCourseStudentsWithStudentName();
    }

    // public void registerCourseStudent(String program, String level, float price, String schedule, LocalDate openning, String time,  String email) {
    //     User user = userRepository.findByEmailUser(email);

    //     course course = courseRepository.findByProgramAndLevelAndPriceAndScheduleAndOpenningAndTime(program, level, price, schedule, openning, time);
                        


    //     if (user == null || course == null) {
    //         throw new IllegalArgumentException("Invalid email or course name");
    //     }

    //     ClassChild classChild = new ClassChild();
    //     classChild.setUser(user);
    //     classChild.setCourse(course);

    //     classChildRepository.save(classChild);
    // }

        public void registerCourse(Integer id,  String email) {
        User user = userRepository.findByEmailUser(email);

        course course = courseRepository.findCourseById(id);
                        


        if (user == null || course == null) {
            throw new IllegalArgumentException("Invalid email or course name");
        }

        ClassChild classChild = new ClassChild();
        classChild.setUser(user);
        classChild.setCourse(course);

        classChildRepository.save(classChild);
    }


}
