package com.example.EnglishCenterManager_backend.course;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.EnglishCenterManager_backend.courseType.courseType;
@Repository
public interface courseRepository extends JpaRepository<course, Integer>{

    // course findByProgram(String program);
        @Query("SELECT u FROM course u WHERE u.program = :program")
    course findByProgram(@Param("program") String program);

    
    course findByProgramAndLevelAndPriceAndScheduleAndOpenningAndTime(String program, String level, float price, String schedule, LocalDate openning, String time);

    @Query("SELECT c FROM course c WHERE c.id = :id")
    course findCourseById(@Param("id") Integer id);


    course findByProgramAndOpenning(String program, LocalDate openning);

    // @Query("SELECT c FROM course c WHERE c.courseType = :courseType")
    // public course findCourseByCourseType(@Param("coursetype") courseType coursetype);

    // @Query("SELECT cs, s.id FROM course cs JOIN cs.user s WHERE cs.course.id = :courseId")
    // List<Object[]> findClassChildWithUserName(@Param("courseId") Integer courseId);

    List<course> findByEnglishId(Integer englishId);
}
