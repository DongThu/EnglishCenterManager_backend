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

    @Query("SELECT c.course.program, c.course.level, c.course.price, c.course.schedule, c.course.openning, c.course.time, c.user.username, c.user.phone FROM ClassChild c")
    List<Object[]> getClassChildDetails();

    @Query("SELECT t FROM ClassChild t WHERE t.user.id = :userId")
    List<ClassChild> findByUserId(@Param("userId") Integer userId);

    // @Query("SELECT c.program, c.openning, c.schedule, t.classroom, t.teacher FROM ClassChild c JOIN course c ON  WHERE t.user.id = :userId")
    // List<ClassChild> findByTimetableUserId(@Param("userId") Integer userId);
}
