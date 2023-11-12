package com.example.EnglishCenterManager_backend.examStudent;

import java.util.List;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.EnglishCenterManager_backend.course.course;
import com.example.EnglishCenterManager_backend.course.courseRepository;
import com.example.EnglishCenterManager_backend.quiz.Quiz;
import com.example.EnglishCenterManager_backend.quiz.QuizRepository;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/examStudent")
public class ExamStudentResourse {
    
    @Autowired
    private ExamStudentService examStudentService;

    @Autowired
    private courseRepository courseService;

    @Autowired
    private QuizRepository quizService;

    @PostMapping("")
    public ResponseEntity<String> createExam(@RequestBody ExamStudentRequest request) {

            examStudentService.exam( request.getUserId(), request.getExamId(), request.getScore());
            return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("all")
    public List<ExamStudent> getAll(){
        return examStudentService.getAll();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ExamStudent> deleteExamStudent(@PathVariable("id") Integer id){
        examStudentService.deleteExamStudent(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/user/{id}")
    public List<ExamStudent> findByUserId(@PathVariable Integer id) {
        return examStudentService.findByUserId(id);
    }

    @GetMapping("/search")
    public ResponseEntity<List<ExamStudent>> searchStudentsByName(@RequestParam("name") String name) {
        List<ExamStudent> students = examStudentService.searchStudentsByName(name);
        return ResponseEntity.ok(students);
    }

    // @GetMapping("/filtered")
    // public ResponseEntity<List<ExamStudent>> getFilteredExamStudents(
    //         @RequestParam(name = "courseId") Integer courseId,
    //         @RequestParam(name = "quizId") Integer quizId) {
    //     // Fetch Course and Quiz objects from your database based on courseId and quizId
    //     course course = (courseId != null) ? courseService.findById(courseId).orElse(null) : null;
    //     Quiz quiz = (quizId != null) ? quizService.findById(quizId).orElse(null) : null;

    //     List<ExamStudent> filteredExamStudents = examStudentService.getExamStudentsByCourseAndQuiz(course, quiz);
    //     return ResponseEntity.ok(filteredExamStudents);
    // }

    @GetMapping("/filtered")
    public ResponseEntity<List<ExamStudent>> getFilteredExamStudents(
        @RequestParam(name = "courseId", required = false) String courseIdStr,
        @RequestParam(name = "quizId", required = false) String quizIdStr) {

    Integer courseId = parseInteger(courseIdStr);
    Integer quizId = parseInteger(quizIdStr);

    course course = (courseId != null) ? courseService.findById(courseId).orElse(null) : null;
    Quiz quiz = (quizId != null) ? quizService.findById(quizId).orElse(null) : null;

    List<ExamStudent> filteredExamStudents = examStudentService.getExamStudentsByCourseAndQuiz(course, quiz);
    return ResponseEntity.ok(filteredExamStudents);
}

private Integer parseInteger(String str) {
    try {
        return (str != null && !str.trim().isEmpty()) ? Integer.parseInt(str) : null;
    } catch (NumberFormatException e) {
        return null; // Xử lý trường hợp chuỗi không phải là số nguyên hợp lệ
    }
}

}
