package com.example.EnglishCenterManager_backend.document;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer>{
    
    Optional<Document> findByNameDocument(String nameDocument);

    @Query("SELECT t FROM Document t WHERE t.nameD.id = :englishId")
    Optional<Document> findByDocumentId(@Param("englishId") Integer englishId);

}
