package com.example.EnglishCenterManager_backend.classChild;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("register-course")
@CrossOrigin(origins = "http://localhost:4200")
public class ClassChildResourse {
    @Autowired
    private ClassChildService classChildService;


    @GetMapping("/all")
    public List<ClassChild> getAllCourse() {
        return classChildService.getAll();
    }

    // @GetMapping
    // public ResponseEntity<List<ClassChildReponseDTO>> getClassChildDetails() {
    //     List<ClassChildReponseDTO> classChildDetails = classChildService.getClassChildDetails();
    //     return ResponseEntity.ok(classChildDetails);
    // }
    // @PostMapping("")
    // public ClassChild registerStudent(@RequestBody ClassChildRequestDTO request) {
    //     return classChildService.registerCourse(request);
    // }

    // @GetMapping("/{courseId}")
    // public List<Object[]> findClassChildWithUserName(@PathVariable Integer courseId) {
    //     return classChildService.findClassChildWithUserName(courseId);
    // }
    @GetMapping("/{id}")
    public Optional<ClassChild> findById(@PathVariable Integer id) {
        return classChildService.findById(id);
    }

    @GetMapping("/user/{id}")
    public List<ClassChild> findByUserId(@PathVariable Integer id) {
        return classChildService.findByUserId(id);
    }

    // @GetMapping
    // public List<Object[]> getAllCourseStudentsWithStudentName() {
    //     return classChildService.getAllCourseStudentsWithStudentName();
    // }



    //  @PostMapping("")
    // public ResponseEntity<String> registerCourseStudent(@RequestBody ClassChildRequestDTO request) {
    //     // try {
    //         classChildService.registerCourseStudent(request.getProgram(),request.getLevel(), request.getPrice(), request.getSchedule(), request.getOpenning(), request.getTime(), request.getEmail());
    //         // return ResponseEntity.ok("Registered successfully");
    //         return ResponseEntity.status(HttpStatus.CREATED).build();
    //     // } catch (Exception e) {
    //         // return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to register");
    //     // }
    // }

    @PostMapping("/{id}")
    public ResponseEntity<String> registerCourse(@PathVariable Integer id, @RequestBody ClassChildRequestDTO request) {

            classChildService.registerCourse(id, request.getEmail());
            return ResponseEntity.status(HttpStatus.CREATED).build();
        
    }

    @DeleteMapping("/delete/{id}")
    public void deleteChildClass(@PathVariable("id") Integer id){
        classChildService.deleteChildClass(id);
    }

    @GetMapping("find/courseId/{classChildId}")
    public ResponseEntity<?> findByclassChildId(@PathVariable Integer classChildId){
        Optional<ClassChild> classChild = classChildService.findById(classChildId);
        if (classChild.isPresent()) {
            return ResponseEntity.ok(classChild.get().getCourse().getCourse_id());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // lấy id chương trình english để lấy thông tin tài liệu cho user
    @GetMapping("find/EnglishId/{id}")
    public ResponseEntity<?> findByEnglishId(@PathVariable Integer id) {
        Optional<ClassChild> classChild = classChildService.findById(id);
         if (classChild.isPresent()) {
            return ResponseEntity.ok(classChild.get().getCourse().getEnglish().getId());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/total-revenue")
    public ResponseEntity<Double> calculateTotalRevenue() {
        double totalRevenue = classChildService.calculateTotalRevenue();
        return ResponseEntity.ok(totalRevenue);
    }
}
