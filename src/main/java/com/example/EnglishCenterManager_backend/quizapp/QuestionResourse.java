package com.example.EnglishCenterManager_backend.quizapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quizapp")
public class QuestionResourse {
    
    @Autowired
    private QuestionService questionService;

    @GetMapping("/all")
    public List<Question> getAll(){
        return questionService.getAll();
    }

    @PostMapping("")
    public ResponseEntity<String> createQuestion( @RequestBody Question question){
        questionService.createQuestion(question);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("category/{category}")
     public List<Question> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }
}
