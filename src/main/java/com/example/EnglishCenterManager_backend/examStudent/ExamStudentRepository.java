package com.example.EnglishCenterManager_backend.examStudent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.EnglishCenterManager_backend.course.course;
import com.example.EnglishCenterManager_backend.quiz.Quiz;


@Repository
public interface ExamStudentRepository extends JpaRepository<ExamStudent, Integer>{
    
     @Query("SELECT t FROM ExamStudent t WHERE t.user.id = :userId")
    List<ExamStudent> findByUserId(@Param("userId") Integer userId);

    List<ExamStudent> findByUser_NameContainingIgnoreCase(String name);

    @Query("SELECT es FROM ExamStudent es " +
           "JOIN es.exam e " +
           "WHERE e.course = :course " +
           "AND e.quiz = :quiz")
    List<ExamStudent> findExamStudentsByCourseAndQuiz(@Param("course") course course,
                                                      @Param("quiz") Quiz quiz);
}
