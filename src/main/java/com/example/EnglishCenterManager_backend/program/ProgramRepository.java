package com.example.EnglishCenterManager_backend.program;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProgramRepository extends JpaRepository<Program, Integer>{


    @Query("SELECT c FROM Program c WHERE c.id = :id")
    Program findByIdLevel(@Param("id") Integer id);

}
