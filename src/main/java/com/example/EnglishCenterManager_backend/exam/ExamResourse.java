package com.example.EnglishCenterManager_backend.exam;

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
import org.springframework.web.bind.annotation.RestController;



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/exam")
public class ExamResourse {
    
    @Autowired
    private ExamService examService;

    @PostMapping("")
    public ResponseEntity<String> createExam(@RequestBody ExamRequest request) {

            examService.createExam( request.getCourseId(), request.getQuizId());
            return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("all")
    public List<Exam> getAll(){
        return examService.getAll();
    }

    @GetMapping("courseId/{courseId}")
    public List<Exam> searchByCourseId(@PathVariable Integer courseId) {
      return examService.findByCourseId(courseId); 
    //   List<Exam> exams = 
      
        // List<Exam> quizIds = new ArrayList<>();
        
        // for (Exam exam : exams) {
        //     quizIds.add(exam.getId());
        // }
        
        // return quizIds;
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        examService.delete(id);
    }
    
     
}
