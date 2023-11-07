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



@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/examStudent")
public class ExamStudentResourse {
    
    @Autowired
    private ExamStudentService examStudentService;

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
}
