package com.example.EnglishCenterManager_backend.quiz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.example.EnglishCenterManager_backend.quizapp.QuestionWrapper;

@RestController
@RequestMapping("quiz")
@CrossOrigin(origins = "http://localhost:4200")
public class QuizResourse {
   
    @Autowired
    private QuizSevice quizSevice;

    @PostMapping("create")
    public ResponseEntity<String>  createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title){
        return quizSevice.createQuiz(category, numQ, title);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestion(@PathVariable Integer id){
        return quizSevice.getQuizQuestion(id);
    }

    @GetMapping("getAll")
    public List<Quiz> getQuizAll(){
        return quizSevice.getAll();
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id,@RequestBody List<Response> responses){
        return quizSevice.calculateResult(id, responses);
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") Integer id){
        quizSevice.delete(id);
    }
}
