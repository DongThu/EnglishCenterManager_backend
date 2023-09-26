package com.example.EnglishCenterManager_backend.TeacherSchedule;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EnglishCenterManager_backend.infoTeacher.InfoTeacher;
import com.example.EnglishCenterManager_backend.infoTeacher.InfoTeacherRepository;

@Service
public class TeacherScheduleService {
 
    @Autowired
    private TeacherScheduleRepository teacherScheduleRepository;
    private InfoTeacherRepository infoTeacherRepository;
    public TeacherScheduleService(TeacherScheduleRepository teacherScheduleRepository, InfoTeacherRepository infoTeacherRepository){
        this.teacherScheduleRepository = teacherScheduleRepository;
        this.infoTeacherRepository = infoTeacherRepository;
    }

    public void AddTeacherSchedule(Integer id, LocalDate startTime, LocalDate endTime){

        InfoTeacher teacher = infoTeacherRepository.findTeacherById(id);
        if(teacher == null){
            throw new IllegalArgumentException("không tồn tại giáo viên");
        }

        TeacherSchedule teacherSchedule = new TeacherSchedule();

        teacherSchedule.setTeacher(teacher);
        teacherSchedule.setStartTime(startTime);
        teacherSchedule.setEndTime(endTime);
        teacherScheduleRepository.save(teacherSchedule);
    }


    public List<TeacherSchedule> getTeacherSchedule(){
        return teacherScheduleRepository.findAll();
    }

    public void deleteTeacherSchedule(Integer id){
        teacherScheduleRepository.deleteById(id);
    }

    public TeacherSchedule updateTeacherSchedule(Integer id, TeacherSchedule teacher) {
        TeacherSchedule fromDB = teacherScheduleRepository.findById(id).orElse(null);
        if (fromDB == null){
            return null;
        }
        fromDB.setStartTime(teacher.getStartTime());
        fromDB.setEndTime(teacher.getEndTime());
        return teacherScheduleRepository.save(fromDB);
    }
     
    public Optional<TeacherSchedule> getTeacherById(Integer id){
        return teacherScheduleRepository.findById(id);
    }
}
