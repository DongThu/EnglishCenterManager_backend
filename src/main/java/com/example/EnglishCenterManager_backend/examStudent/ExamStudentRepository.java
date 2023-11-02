package com.example.EnglishCenterManager_backend.examStudent;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface ExamStudentRepository extends JpaRepository<ExamStudent, Integer>{
    
     @Query("SELECT t FROM ExamStudent t WHERE t.user.id = :userId")
    List<ExamStudent> findByUserId(@Param("userId") Integer userId);
}
