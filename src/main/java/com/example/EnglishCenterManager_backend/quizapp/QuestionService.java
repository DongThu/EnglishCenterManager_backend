package com.example.EnglishCenterManager_backend.quizapp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {
    
    @Autowired
    private QuestionRepository questionRepository;


    public void createQuestion(Question question){
        questionRepository.save(question);
    }

    public List<Question> getAll(){
        return questionRepository.findAll();
    }

    public List<Question> getQuestionByCategory(String category){
        return questionRepository.findByCategory(category);
    }
}
