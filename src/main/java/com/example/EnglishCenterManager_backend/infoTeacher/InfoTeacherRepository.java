package com.example.EnglishCenterManager_backend.infoTeacher;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoTeacherRepository extends JpaRepository<InfoTeacher,Integer>{
  
    @Query("SELECT t FROM InfoTeacher t WHERE t.id = :id")
    InfoTeacher findTeacherById(@Param("id") Integer id);

    InfoTeacher findByFullName(String teacher);

    InfoTeacher findByEmail(String email);

    @Query("SELECT email FROM InfoTeacher WHERE id = :id")
    String getTeacherEmailById(@Param("id") Integer id);
}
