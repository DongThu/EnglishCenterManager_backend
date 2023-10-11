package com.example.EnglishCenterManager_backend.timetable;

import java.util.List;

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
}
