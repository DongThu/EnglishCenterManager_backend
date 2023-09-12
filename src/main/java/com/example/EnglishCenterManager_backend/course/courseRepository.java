package com.example.EnglishCenterManager_backend.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.EnglishCenterManager_backend.course.course;
import com.example.EnglishCenterManager_backend.courseType.courseType;
import com.example.EnglishCenterManager_backend.level.level;
import com.example.EnglishCenterManager_backend.period.period;
@Repository
public interface courseRepository extends JpaRepository<course, Integer>{
}
