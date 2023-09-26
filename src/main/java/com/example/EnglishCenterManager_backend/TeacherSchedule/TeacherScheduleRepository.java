package com.example.EnglishCenterManager_backend.TeacherSchedule;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherScheduleRepository extends JpaRepository<TeacherSchedule, Integer>{
    
}
