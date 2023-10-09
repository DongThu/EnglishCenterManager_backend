package com.example.EnglishCenterManager_backend.courseType;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class courseTypeService {
    
    @Autowired
    private courseTypeRepository courseTypeRepository;

    public void createEngilsh(courseType english){
        courseTypeRepository.save(english);
    }

    public List<courseType> getAll(){
        return courseTypeRepository.findAll();
    }

    public courseType getId(Integer id){
        return courseTypeRepository.findByIdEnglish(id);
    }
}
