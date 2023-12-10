package com.example.EnglishCenterManager_backend.timetable;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface TimetableRepository extends JpaRepository<Timetable, Integer>{
        
    @Query("SELECT c FROM Timetable c WHERE c.id = :id")
    Timetable findTimeTableById(@Param("id") Integer id);

    @Query("SELECT t FROM Timetable t WHERE t.teacher.id = :teacherId")
    List<Timetable> findByTeacherId(@Param("teacherId") Integer teacherId);

    @Query("SELECT t FROM Timetable t WHERE t.course.id = :courseId")
    Optional<Timetable> findByCourseId(@Param("courseId") Integer courseId);
    // @Query("SELECT t.id, t.classroom, i.fullName AS teacher_name, c.program, c.openning, c.schedule FROM Timetable t JOIN course c ON t.course.course_id = :courseId JOIN InfoTeacher i ON t.teacher.id = :teacherId JOIN ClassChild cc ON t.course.course_id = :courseId JOIN User u ON cc.user.id = :userId WHERE u.id = :userId")
    // @Query("SELECT t FROM Timetable t JOIN t.course c JOIN t.teacher i JOIN t.ClassChild cc JOIN cc.user u WHERE u.id = :userId")
    // Timetable findTimetableUser(@Param("userId") Integer userId);

    List<Timetable> findByStatus(Integer status);

    List<Timetable> findByCourse_OpenningGreaterThanEqualAndCourse_OpenningLessThan(LocalDate start, LocalDate end);
    // List<Timetable> findByTeacherAndOpenning(InfoTeacher teacher, LocalDate openning);
    @Query("SELECT t FROM Timetable t WHERE t.course.openning >= :start AND t.course.openning < :end")
    List<Timetable> findTimetablesByCourseOpenningBetween(@Param("start") LocalDate start, @Param("end") LocalDate end);

    boolean existsByClassroomAndCourse_Schedule(String classroom, String schedule);

    boolean existsByTeacher_IdAndCourse_Schedule(Integer teacherId, String schedule);
}
