package com.example.EnglishCenterManager_backend.course;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
@Repository
public interface courseRepository extends JpaRepository<course, Integer>{

    // course findByProgram(String program);
        @Query("SELECT u FROM course u WHERE u.program = :program")
    course findByProgram(@Param("program") String program);

    
    course findByProgramAndLevelAndPriceAndScheduleAndOpenningAndTime(String program, String level, float price, String schedule, LocalDate openning, String time);

    @Query("SELECT c FROM course c WHERE c.id = :id")
    course findCourseById(@Param("id") Integer id);
}
