package com.example.EnglishCenterManager_backend.timetable;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.EnglishCenterManager_backend.course.course;
import com.example.EnglishCenterManager_backend.course.courseRepository;
import com.example.EnglishCenterManager_backend.infoTeacher.InfoTeacher;
import com.example.EnglishCenterManager_backend.infoTeacher.InfoTeacherRepository;

@Service
public class TimetableService {


    @Autowired
    private TimetableRepository timetableRepository;

    // @Autowired
    // private EmailService2 emailService2;

    private InfoTeacherRepository infoTeacherRepository;

    private courseRepository courseRepository;

    private TimetableService(TimetableRepository timetableRepository, InfoTeacherRepository infoTeacherRepository, courseRepository courseRepository){
        this.timetableRepository = timetableRepository;
        this.infoTeacherRepository = infoTeacherRepository;
        this.courseRepository = courseRepository;

    }

    public void createTimetable(Integer courseId, String classroom, Integer teacherId){

        course course = courseRepository.findCourseById(courseId);

        InfoTeacher  infoTeacher = infoTeacherRepository.findTeacherById(teacherId);

        if(course == null){
            throw new IllegalArgumentException("Thông tin course bạn nhập không hiện có");
        }
        else if ( infoTeacher == null){
            throw new IllegalArgumentException("Thông tin infoTeacher bạn nhập không hiện có");
        }

        Timetable timetable = new Timetable();

        timetable.setClassroom(classroom);
        timetable.setCourse(course);
        timetable.setTeacher(infoTeacher);

        timetableRepository.save(timetable);
    }

    public List<Timetable> getTimetable(){
        return timetableRepository.findAll();
    }

    public void deleteTimetable(Integer id){
        timetableRepository.deleteById(id);
    }

    // public Timetable updateTimetable(Integer id, Timetable tb){

    //     Timetable timetable = timetableRepository.findById(id).orElse(null);
    //     if (timetable == null){
    //         return null;
    //     }

    //     // course course = courseRepository.findCourseById(courseId);

    //     // InfoTeacher  infoTeacher = infoTeacherRepository.findTeacherById(teacherId);

    //     // if(course == null){
    //     //     throw new IllegalArgumentException("Thông tin course bạn nhập không hiện có");
    //     // }
    //     // else if ( infoTeacher == null){
    //     //     throw new IllegalArgumentException("Thông tin infoTeacher bạn nhập không hiện có");
    //     // }

    //     // Timetable timetable = new Timetable();

    //     timetable.setClassroom(tb.getClassroom());
    //     timetable.setCourse(tb.getCourse());
    //     timetable.setTeacher(tb.getTeacher());

    //     return timetableRepository.save(timetable);
    // }
     
    public Optional<Timetable> getTimetableId(Integer id){
        return timetableRepository.findById(id);
    }

    public List<Timetable> findByTeacherId(Integer teacherId){
            return timetableRepository.findByTeacherId(teacherId);
    }

    public Optional<Timetable> findByCourseId(Integer courseId){
            return timetableRepository.findByCourseId(courseId);
    }
    // public class EmailService {
    //     public void sendTimetableEmail(String email, List<Timetable> timetables) {
    //         emailService.sendTimetableEmail(email, timetables);
    //     }
    // }

    public void sendTimetableEmail(String email, List<Timetable> timetables) {
    }

    // public Timetable findTimetableUser(Integer userId){
    //     return timetableRepository.findTimetableUser(userId);
    // }

    public double calculateSalary (Integer timetableId){
        Timetable timetable = timetableRepository.findTimeTableById(timetableId);
        course course = timetable.getCourse();
        InfoTeacher teacher = timetable.getTeacher();
        double time = course.getTime();
        double salaryPerLesson = teacher.getLevelSalary();
    
        // Tính lương
        double salary = time * salaryPerLesson;
    
        return salary;
    }

    public double calculateTotalSalary() {
        List<Timetable> timetables = timetableRepository.findByStatus(1);
        double totalSalary = 0;

        for (Timetable timetable : timetables) {
            totalSalary += calculateSalary(timetable.getId());
        }

        return totalSalary;
    }

    // @Scheduled(cron = "0 * * * * ?") // Chạy mỗi ngày lúc 8 giờ sáng
    // public void sendTimetableEmails() {
    //     LocalDateTime currentDateTime = LocalDateTime.now();
    //     LocalDateTime oneMinuteAfter = currentDateTime.plusMinutes(1);

    //     List<Timetable> upcomingTimetables = timetableRepository.findByCourse_OpenningGreaterThanEqualAndCourse_OpenningLessThan(oneMinuteAfter, currentDateTime);

    //     for (Timetable timetable : upcomingTimetables) {
    //         String teacherEmail = timetable.getTeacher().getEmail();

    //         // Gửi email với thông báo khai giảng
    //         emailService2.sendOpeningNotification(teacherEmail, timetable);
    //     }
    // }
}
