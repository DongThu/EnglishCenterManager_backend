package com.example.EnglishCenterManager_backend.infoTeacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface InfoTeacherRepository extends JpaRepository<InfoTeacher,Integer>{
    
}
