package com.example.EnglishCenterManager_backend.level;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface levelRepository extends JpaRepository<level, Integer>{


    @Query("SELECT c FROM level c WHERE c.id = :id")
    level findByIdLevel(@Param("id") Integer id);

}
