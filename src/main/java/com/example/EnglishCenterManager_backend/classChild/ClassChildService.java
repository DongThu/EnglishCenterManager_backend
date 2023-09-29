package com.example.EnglishCenterManager_backend.classChild;

import org.springframework.stereotype.Service;
import org.modelmapper.convention.MatchingStrategies;
import org.modelmapper.spi.MappingContext;
import org.modelmapper.ModelMapper;
import org.modelmapper.Converter;

import com.example.EnglishCenterManager_backend.course.course;
import com.example.EnglishCenterManager_backend.course.courseRepository;
import com.example.EnglishCenterManager_backend.user.User;
import com.example.EnglishCenterManager_backend.user.UserRepository;

import jakarta.annotation.PostConstruct;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

@Service
public class ClassChildService {
    
    @Autowired
    private ClassChildRepository classChildRepository;

    private UserRepository userRepository;

    private courseRepository courseRepository;

    // @Autowired
    // private ModelMapper modelMapper;

    public ClassChildService(ClassChildRepository classChildRepository, UserRepository userRepository, courseRepository courseRepository) {
        this.classChildRepository = classChildRepository;
        this.userRepository = userRepository;
        this.courseRepository = courseRepository;
    }

    // public ClassChildService(courseRepository courseRepository) {
    //     this.courseRepository = courseRepository;
    // }

    // public ClassChild registerCourse(ClassChildRequestDTO classChildRequestDTO){

    //     User user = new User(classChildRequestDTO.getUsername());
    //     course course = new course(classChildRequestDTO.getCourseId());
    //     // ClassChild existingClassChild = classChildRepository.findByUserAndCourse(user, course);
    //     // if (existingClassChild != null) {
    //     //     throw new IllegalArgumentException("Student has already registered for this course");
    //     // }
    //     ClassChild classChild = new ClassChild();
    //     classChild.setUser(user);
    //     classChild.setCourse(course);
        
    //     return classChildRepository.save(classChild);
    // }

        public List<ClassChild> getAll(){
        return classChildRepository.findAll();
    }

    // -------------------------------------------------------------------------------------------------------
    // @Bean
    // Converter<course, ClassChildReponseDTO> courseConverter(){
    //     return new Converter<course, ClassChildReponseDTO>() {
    //         @Override
    //         public ClassChildReponseDTO convert(MappingContext<course, ClassChildReponseDTO> context) {
    //             course source = context.getSource();
    //             ClassChildReponseDTO destination = new ClassChildReponseDTO();
        
    //             // Xử lý ánh xạ tùy chỉnh
    //             destination.setProgram(source.getProgram());
    //             destination.setLevel(source.getLevel());
    //             destination.setPrice(source.getPrice());
    //             destination.setSchedule(source.getSchedule());
    //             destination.setOpenning(source.getOpenning());
    //             return destination;

    //         }
    //     };
        
    // }

    // @Bean
    // public Converter<User, ClassChildReponseDTO> userConverter() {
    //     return new Converter<User, ClassChildReponseDTO>() {
    //         @Override
    //         public ClassChildReponseDTO convert(MappingContext<User, ClassChildReponseDTO> context) {
    //             User source = context.getSource();
    //             ClassChildReponseDTO destination = new ClassChildReponseDTO();
    //             // Xử lý ánh xạ tùy chỉnh
    //             destination.setUsername(source.getUsername());
    //             destination.setPhone(source.getPhone());

    //             return destination;
    //         }

    //    };
    // }
    
    // @PostConstruct
    // public void configureModelMapper() {
    //     modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
    //     modelMapper = new ModelMapper();
    //     modelMapper.addConverter(courseConverter());
    //     modelMapper.addConverter(userConverter());
    // }


    // public List<ClassChildReponseDTO> getClassChildDetails() {
    //     List<ClassChild> classChildren = classChildRepository.findAll();
    //     List<ClassChildReponseDTO> classChildReponseDTOs = classChildren.stream()
    //             .map(classChild -> modelMapper.map(classChild, ClassChildReponseDTO.class))
    //             .collect(Collectors.toList());
    //     return classChildReponseDTOs;
    // }
// ------------------------------------------------------
        // public List<ClassChildReponseDTO> getClassChildDetails() {
        //     List<ClassChild> classChildren = classChildRepository.findAll();

        //     // Ánh xạ dữ liệu từ lớp gốc sang DTO
        //     List<ClassChildReponseDTO> classChildReponseDTOs = classChildren.stream()
        //             .map(classChild -> modelMapper.map(classChild, ClassChildReponseDTO.class))
        //             .collect(Collectors.toList());

        //     return classChildReponseDTOs;
        //  }

    public List<Object[]> findClassChildWithUserName(Integer courseId) {
        return classChildRepository.findClassChildWithUserName(courseId);
    }

    public List<Object[]> getAllCourseStudentsWithStudentName() {
        return classChildRepository.findAllCourseStudentsWithStudentName();
    }

    // public void registerCourseStudent(String program, String level, float price, String schedule, LocalDate openning, String time,  String email) {
    //     User user = userRepository.findByEmailUser(email);

    //     course course = courseRepository.findByProgramAndLevelAndPriceAndScheduleAndOpenningAndTime(program, level, price, schedule, openning, time);
                        


    //     if (user == null || course == null) {
    //         throw new IllegalArgumentException("Invalid email or course name");
    //     }

    //     ClassChild classChild = new ClassChild();
    //     classChild.setUser(user);
    //     classChild.setCourse(course);

    //     classChildRepository.save(classChild);
    // }

        public void registerCourse(Integer id,  String email) {
        User user = userRepository.findByEmailUser(email);

        course course = courseRepository.findCourseById(id);
                        


        if (user == null || course == null) {
            throw new IllegalArgumentException("Invalid email or course name");
        }

        ClassChild classChild = new ClassChild();
        classChild.setUser(user);
        classChild.setCourse(course);

        classChildRepository.save(classChild);
    }


}
