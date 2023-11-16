package com.example.EnglishCenterManager_backend.timetable;

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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EnglishCenterManager_backend.course.course;
import com.example.EnglishCenterManager_backend.infoTeacher.InfoTeacherRepository;



@RestController
@RequestMapping("timetable")
@CrossOrigin(origins = "http://localhost:4200")
public class TimetableResourse {
    
    @Autowired
    private TimetableService timetableService;
    
    @Autowired
    private TimetableRepository timetableRepository;

    @Autowired
    private InfoTeacherRepository infoTeacheRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private EmailService2 emailService2;

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

    @GetMapping("/teacher/{teacherId}")
    public List<Timetable> findByTeacherId(@PathVariable Integer teacherId) {
        return timetableService.findByTeacherId(teacherId);
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

    // @PostMapping("/sendEmail/{teacherId}")
    // public void sendTimetableEmail(@PathVariable Integer teacherId) {
    //    List<Timetable> timetables = timetableService.findByTeacherId(teacherId);
    //    String teacher = infoTeacheRepository.getTeacherEmailById(teacherId);
    //    System.out.println("Địa chỉ email người nhận: " + teacher);
    //    emailService.sendTimetableEmail(teacher, timetables);
    // }

    @PostMapping("/sendEmail/{teacherId}")
    public List<Timetable>  sendTimetableEmail(@PathVariable Integer teacherId) {
        List<Timetable> timetables = timetableService.findByTeacherId(teacherId);
        String teacherEmail = infoTeacheRepository.getTeacherEmailById(teacherId);
        emailService.sendTimetableEmailToTeacher(teacherEmail, timetables);
        return timetables;
    }

    @GetMapping("find/timetable/{courseId}")
        public ResponseEntity<?> findByCourseId(@PathVariable Integer courseId){
            Optional<Timetable> timetable = timetableService.findByCourseId(courseId);
            if (timetable.isPresent()) {
                return ResponseEntity.ok(timetable.get().getId());
            } else {
                return ResponseEntity.notFound().build();
            }
        }
    // @GetMapping("/find/timetable/{userId}")
    // public Timetable findTimetableUser(@PathVariable Integer userId){
    //     return timetableService.findTimetableUser(userId);
    // }
    
    @GetMapping("salary/{id}")
    public double Salary(@PathVariable("id") Integer timetableId){
        return timetableService.calculateSalary(timetableId);
    }


    @GetMapping("/total-salary")
    public ResponseEntity<Double> calculateTotalSalary() {
        double totalSalary = timetableService.calculateTotalSalary();
        return ResponseEntity.ok(totalSalary);
    }

    // @GetMapping("/send")
    // public String sendTimetableReminders() {
    //     timetableService.sendTimetableEmails();
    //     return "Reminders sent successfully!";
    // }
 
    
    // @GetMapping("/sendEmail2/{teacherId}")
    // public Timetable sendTimetableEmail2(@PathVariable Integer teacherId) {
    //     Timetable timetables = timetableRepository.findById(teacherId).get();
    //     String teacherEmail = infoTeacheRepository.getTeacherEmailById(teacherId);
    //     emailService2.sendOpeningNotification(teacherEmail, timetables);
    //     return timetables;
    // }

    // @GetMapping("/send")
    // public String sendEmailManually() {
    //     try {
    //         // Gửi email với thông báo khai giảng
    //         emailService2.sendOpeningNotification("dongthu1512@gmail.com", createSampleTimetable());
    //         return "Email sent manually!";
    //     } catch (Exception e) {
    //         e.printStackTrace();
    //         return "Failed to send email manually!";
    //     }
    // }

    // private Timetable createSampleTimetable() {
    //     Timetable timetable = new Timetable();
    //     course course = new course();
    //     course.setProgram("English Course");
    //     course.setOpenning(LocalDate.now().plusDays(1)); // Thiết lập ngày mở khóa học vào ngày mai
    //     course.setSchedule("Mon, Wed, Fri 10:00 AM - 12:00 PM");
    //     timetable.setCourse(course);
    //     timetable.setClassroom("101");
    //     return timetable;
    // }
}

