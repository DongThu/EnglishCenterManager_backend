package com.example.EnglishCenterManager_backend.document;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer>{
    
    Optional<Document> findByNameDocument(String nameDocument);
}
