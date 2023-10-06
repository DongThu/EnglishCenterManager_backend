package com.example.EnglishCenterManager_backend.document;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.EnglishCenterManager_backend.infoTeacher.InfoTeacher;

@RestController
@RequestMapping("document")
@CrossOrigin(origins = "http://localhost:4200")
public class DocumentResourse {
    
    @Autowired 
    private DocumentService documentService;

    @PostMapping("add")
    public ResponseEntity<Document> addDocument(@RequestBody Document document){
        documentService.addDocument(document);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("all")
    public List<Document> getAll(){
        return documentService.getAll();
    }

    @PostMapping
	public ResponseEntity<?> uploadDocument(@RequestParam("nameDocument")MultipartFile file, @RequestParam("nameD") String nameD, @RequestParam("typeD") String typeD) throws IOException {
		String uploadDocument = documentService.uploadDocument(file, nameD, typeD);
		return ResponseEntity.status(HttpStatus.OK)
				.body(uploadDocument);
	}

	@GetMapping("/{fileName}")
	public ResponseEntity<?> downloadDocument(@PathVariable String fileName){
		byte[] DocumentData=documentService.downloadDocument(fileName);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(ContentDisposition.attachment().filename(fileName).build());

    return ResponseEntity.ok()
            .headers(headers)
            .body(DocumentData);
	}

    @GetMapping("find/{filename}")
    public Optional<Document> findByNameDocument(@PathVariable String filename){
      return  documentService.findByNameDocument(filename);
        
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<InfoTeacher> deleteCTeacher(@PathVariable("id") Integer id){
        documentService.deleteDocument(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}

