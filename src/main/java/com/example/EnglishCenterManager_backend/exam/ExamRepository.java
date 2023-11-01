package com.example.EnglishCenterManager_backend.exam;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer>{
     
    @Query("SELECT t FROM Exam t WHERE t.course.id = :courseId")
    List<Exam> findByCourseId(@Param("courseId") Integer courseId);
}
