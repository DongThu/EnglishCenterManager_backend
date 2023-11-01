package com.example.EnglishCenterManager_backend.level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EnglishCenterManager_backend.program.Program;
import com.example.EnglishCenterManager_backend.program.ProgramRepository;

@Service
public class levelService {
    
    @Autowired
    private levelRepository levelRepository;

    private ProgramRepository courseTypeRepository;

    public levelService(levelRepository levelRepository, ProgramRepository courseTypeRepository){
        this.levelRepository = levelRepository;
        this.courseTypeRepository = courseTypeRepository;
    }

    public void createLevel(String nameLevel, Integer englishId){

        Program english = courseTypeRepository.findByIdLevel(englishId);

        level level = new level();

        level.setLevelName(nameLevel);
        level.setEnglish(english);

        levelRepository.save(level);
    }
}
