package com.example.EnglishCenterManager_backend.quiz;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>{
    @Query("SELECT c FROM Quiz c WHERE c.id = :id")
    Quiz findQuizById(@Param("id") Integer id);

}
