package com.example.EnglishCenterManager_backend.classChild;

import org.springframework.stereotype.Service;

import com.example.EnglishCenterManager_backend.course.course;
import com.example.EnglishCenterManager_backend.course.courseRepository;
import com.example.EnglishCenterManager_backend.timetable.Timetable;
import com.example.EnglishCenterManager_backend.user.User;
import com.example.EnglishCenterManager_backend.user.UserRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

@Service
public class ClassChildService {
    
    @Autowired
    private ClassChildRepository classChildRepository;

     @Autowired
    private EmailService3 emailService3;
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

    public void deleteChildClass(Integer id){
        classChildRepository.deleteById(id);
    }

    public Optional<ClassChild> findById(Integer id){
        return classChildRepository.findById(id);
    }

    public List<ClassChild> findByUserId(Integer userId){
        return classChildRepository.findByUserId(userId);
    }

    public double calculateTotalRevenue() {
        List<ClassChild> paidClassChildren = classChildRepository.findByStatus(1);
        double totalRevenue = 0.0;

        for (ClassChild classChild : paidClassChildren) {
            totalRevenue += classChild.getCourse().getPrice();
        }

        return totalRevenue;
    }

    @Scheduled(cron = "0/1 * * * * ?")
    // @Scheduled(cron = "0 0 0 * * 0")
    // @Scheduled(cron = "0 0 0 */2 * ?")
    public void sendTimetableEmails() {
        // System.out.println("Scheduled task is running at " + LocalDateTime.now());
        LocalDate currentDate = LocalDate.now();
        LocalDate oneDayBefore = currentDate.plusDays(2);

        List<ClassChild> upcomingTimetables = classChildRepository.findTimetablesByCourseOpenningBetween(currentDate,oneDayBefore);

        for (ClassChild timetable : upcomingTimetables) {
            // System.out.println("Processing timetable with openning: " + timetable.getCourse().getOpenning());
            String teacherEmail = timetable.getUser().getUsername();

            // Gửi email với thông báo khai giảng
            // emailService3.sendOpeningNotification(teacherEmail, timetable);
            // System.out.println("Email sent to: " + timetable);
            // System.out.println("Email sent to: " + teacherEmail);
            
        }
    }
}
