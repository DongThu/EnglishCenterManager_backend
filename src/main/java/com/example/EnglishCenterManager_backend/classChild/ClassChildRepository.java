package com.example.EnglishCenterManager_backend.classChild;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ClassChildRepository extends JpaRepository<ClassChild,Integer>{

    @Query("SELECT cs, s.name FROM ClassChild cs JOIN cs.user s WHERE cs.course.id = :courseId")
    List<Object[]> findClassChildWithUserName(@Param("courseId") Integer courseId);
    
    @Query("SELECT cs, s.name FROM ClassChild cs JOIN cs.user s")
    List<Object[]> findAllCourseStudentsWithStudentName();

    @Query("SELECT cs.course.program, cs.course.level, cs.course.price, cs.course.schedule, cs.course.openning, cs.course.time FROM ClassChild cs WHERE cs.course.id = :courseId")
    List<Object[]> findCourseInfoByCourseId(@Param("courseId") Integer courseId);
}
