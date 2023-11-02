package com.example.EnglishCenterManager_backend.exam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EnglishCenterManager_backend.course.course;
import com.example.EnglishCenterManager_backend.course.courseRepository;
import com.example.EnglishCenterManager_backend.quiz.Quiz;
import com.example.EnglishCenterManager_backend.quiz.QuizRepository;

@Service
public class ExamService {
    
    @Autowired
    private ExamRepository examRepository;

    @Autowired 
    private courseRepository courseRepository;

    @Autowired
    private QuizRepository quizRepository;

    public void createExam(Integer courseId, Integer quizId){

        course course = courseRepository.findCourseById(courseId);

        Quiz quiz = quizRepository.findQuizById(quizId);

        Exam exam = new Exam();
        
        exam.setCourse(course);
        exam.setQuiz(quiz);

        examRepository.save(exam);
    }

    public List<Exam> getAll(){
        return examRepository.findAll();
    }

    public List<Exam> findByCourseId(Integer courseId){
        return examRepository.findByCourseId(courseId);
    }

    public void delete(Integer id){
        examRepository.deleteById(id);
    }
}
