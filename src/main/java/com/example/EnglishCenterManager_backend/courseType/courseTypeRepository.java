package com.example.EnglishCenterManager_backend.courseType;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface courseTypeRepository extends JpaRepository<courseType, Integer>{
        
    @Query("SELECT c FROM courseType c WHERE c.id = :id")
    courseType findByIdEnglish(@Param("id") Integer id);

}
