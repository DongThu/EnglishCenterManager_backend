package com.example.EnglishCenterManager_backend.document;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.EnglishCenterManager_backend.courseType.courseType;
import com.example.EnglishCenterManager_backend.courseType.courseTypeRepository;

import jakarta.transaction.Transactional;

import java.io.IOException;

@Service
public class DocumentService {
    
    @Autowired
    private DocumentRepository documentRepository;

    private courseTypeRepository courseTypeRepository;

    public DocumentService(DocumentRepository documentRepository, courseTypeRepository courseTypeRepository){
        this.documentRepository = documentRepository;
        this.courseTypeRepository = courseTypeRepository;
    }
    public void addDocument(Document document){
        documentRepository.save(document);
    }

    public List<Document> getAll(){
        return documentRepository.findAll();
    }

    // public Document saveDocument(DocumentRequestDTO  documentRequestDTO){
    //     Document document = new Document();
    //     document.setNameDocument(documentRequestDTO.getNameDocument());
    //     document.setTypeDocument(documentRequestDTO.getTypeDocument());

    //     MultipartFile file = documentRequestDTO.getFile();
    //     document.setFileName(file.getOriginalFilename());
    //     document.setFileSize(file.getSize());
    //     document.setFileContent(file.getBytes());

    //     return documentRepository.save(document);
    // }

    public String uploadDocument(MultipartFile file, Integer nameD/*, String typeD */) throws IOException {

         courseType courseType = courseTypeRepository.findByIdEnglish(nameD);
            // .orElseThrow(() -> new ResourceNotFoundException("Course Type not found with id: " + nameD));

        Document document = documentRepository.save(Document.builder()
                .nameDocument(file.getOriginalFilename())
                .typeDocument(file.getContentType())
                .nameD(courseType)
                // .typeD(typeD)
                .fileData(DocumentUtils.compressDocument(file.getBytes())).build());
        if (document != null) {
            return "file uploaded successfully : " + file.getOriginalFilename();
        }
        return null;
    }

    @Transactional
    public byte[] downloadDocument(String fileName){
        Optional<Document> dbImageData = documentRepository.findByNameDocument(fileName);
        byte[] document=DocumentUtils.decompressDocument(dbImageData.get().getFileData());
        return document;
    }

    public Optional<Document> findByNameDocument(String nameDocument){
        return documentRepository.findByNameDocument(nameDocument);
    }

    public void deleteDocument(Integer id){
        documentRepository.deleteById(id);
    }

    @Transactional 
    public Optional<Document> findByDocumentId(Integer englishId){
        return documentRepository.findByDocumentId(englishId);
    }

        public Optional<Document> findById(Integer englishId){
        return documentRepository.findById(englishId);
    }
}
