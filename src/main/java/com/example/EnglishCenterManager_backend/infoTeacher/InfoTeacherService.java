package com.example.EnglishCenterManager_backend.infoTeacher;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service
public class InfoTeacherService {
    @Autowired
    private InfoTeacherRepository teacherRepository;

    public List<InfoTeacher> getAll(){
        return teacherRepository.findAll();
    }
    @Transactional
    public void addTeacher(InfoTeacher teacher){
        teacherRepository.save(teacher);
    }
    public void deleteTeacher(Integer id){
        teacherRepository.deleteById(id);
    }

    public InfoTeacher updateTeacher(Integer id, InfoTeacher teacher) {
        InfoTeacher fromDB = teacherRepository.findById(id).orElse(null);
        if (fromDB == null){
            return null;
        }
        fromDB.setFullName(teacher.getFullName());
        fromDB.setImage(teacher.getImage());
        fromDB.setBirthDay(teacher.getBirthDay());
        fromDB.setEmail(teacher.getEmail());
        fromDB.setPhone(teacher.getPhone());
        fromDB.setAddress(teacher.getAddress());
        fromDB.setTeachProgram(teacher.getTeachProgram());
        return teacherRepository.save(fromDB);
    }
     
    public Optional<InfoTeacher> getTeacherById(Integer id){
        return teacherRepository.findById(id);
    }
}


