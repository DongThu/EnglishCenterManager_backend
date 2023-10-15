package com.example.EnglishCenterManager_backend.program;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EnglishCenterManager_backend.courseType.courseType;
import com.example.EnglishCenterManager_backend.courseType.courseTypeRepository;

import jakarta.transaction.Transactional;

@Service
public class ProgramService {
    
    @Autowired
    private ProgramRepository levelRepository;

    private courseTypeRepository courseTypeRepository;

    public ProgramService(ProgramRepository levelRepository, courseTypeRepository courseTypeRepository){
        this.levelRepository = levelRepository;
        this.courseTypeRepository = courseTypeRepository;
    }

    public void createLevel(String nameLevel, Integer englishId){

        courseType english = courseTypeRepository.findByIdEnglish(englishId);

        Program level = new Program();

        level.setProgramName(nameLevel);
        level.setEnglish(english);

        levelRepository.save(level);
    }

        public List<Program> getAll(){
        return levelRepository.findAll();
    }

    public void deleteTeacher(Integer id){
        levelRepository.deleteById(id);
    }
}
