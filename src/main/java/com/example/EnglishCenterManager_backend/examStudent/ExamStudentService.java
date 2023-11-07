package com.example.EnglishCenterManager_backend.examStudent;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EnglishCenterManager_backend.exam.Exam;
import com.example.EnglishCenterManager_backend.exam.ExamRepository;
import com.example.EnglishCenterManager_backend.user.User;
import com.example.EnglishCenterManager_backend.user.UserRepository;

@Service
public class ExamStudentService {
    
    @Autowired
    private ExamStudentRepository examStudentRepository;

    @Autowired 
    private UserRepository userRepository;

    @Autowired
    private ExamRepository examRepository;

    public void exam(Integer userId, Integer examId, Integer score){

        User user = userRepository.findUserById(userId);

        Exam exam = examRepository.findById(examId).get();

        ExamStudent  examStudent = new ExamStudent();

        examStudent.setUser(user);
        examStudent.setExam(exam);
        examStudent.setScore(score);

        examStudentRepository.save(examStudent);
    }

    public List<ExamStudent> getAll(){
        return examStudentRepository.findAll();
    }

    public void deleteExamStudent(Integer id){
        examStudentRepository.deleteById(id);
    }

    public List<ExamStudent> findByUserId(Integer userId){
        return examStudentRepository.findByUserId(userId);
    }

    public List<ExamStudent> searchStudentsByName(String name) {
        return examStudentRepository.findByUser_NameContainingIgnoreCase(name);
    }
}
