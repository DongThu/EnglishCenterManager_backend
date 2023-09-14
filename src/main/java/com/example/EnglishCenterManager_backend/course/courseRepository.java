package com.example.EnglishCenterManager_backend.course;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface courseRepository extends JpaRepository<course, Integer>{
}
