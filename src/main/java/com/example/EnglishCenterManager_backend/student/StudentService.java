package com.example.EnglishCenterManager_backend.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    
    @Transactional // Nhiệm vụ rollback toàn bộ nếu nó ko hoàn thành
    public void createStudent(Student student){
        studentRepository.save(student);
    }

    public void deleteStudent(Integer id){
        studentRepository.deleteById(id);
    }
}
