package com.example.EnglishCenterManager_backend.student;

import java.util.Collections;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.EnglishCenterManager_backend.role.Role;
import com.example.EnglishCenterManager_backend.role.RoleEnum;
import com.example.EnglishCenterManager_backend.role.RoleRepository;
import com.example.EnglishCenterManager_backend.user.User;
import com.example.EnglishCenterManager_backend.user.UserRepository;
import com.example.EnglishCenterManager_backend.authentication.AuthResponseDTO;
import com.example.EnglishCenterManager_backend.config.JwtGenerator;
import com.example.EnglishCenterManager_backend.login.LoginDTO;
import com.example.EnglishCenterManager_backend.message.SuccessMessage;
import jakarta.transaction.Transactional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;
    private PasswordEncoder passwordEncoder;
   
    
    public StudentService(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
    public Optional<Student> getStudentByNoStudent(String noStudent) {
        return studentRepository.findByNumberStudent(noStudent);
    }

    // public String getPass(StudentRequestDTO studentRequestDTO){
    //     String pass = studentRequestDTO.getPassword();
    //      return studentRequestDTO.setPassword(passwordEncoder.encode(pass));
    //   }

    @Transactional
    public StudentResponseDTO registerUser(StudentRequestDTO studentRequestDTO){

        Student user = new Student(
            studentRequestDTO.getNumberStudent(),
            studentRequestDTO.getNameStudent(),
            studentRequestDTO.getAddress(),
            studentRequestDTO.getEmail(),
            studentRequestDTO.getPhone(),
            studentRequestDTO.getMajor(),
            studentRequestDTO.getBirthday(),
            studentRequestDTO.getClassroom()
            // studentRequestDTO.getGender()
        );
    
        User account = new User(
           studentRequestDTO.getUsername(),
           studentRequestDTO.getPassword()
            
        );
        // account.setUsername(passwordEncoder.encode(studentRequestDTO.getUsername()));
        account.setPassword(passwordEncoder.encode(studentRequestDTO.getUsername()));


        
        Role role = new Role(
            studentRequestDTO.getRole());
        
        user.setUser(account);
        user.setRole(role);
        
        
 
        studentRepository.save(user);

        StudentResponseDTO studentResponseDTO = new StudentResponseDTO(
            studentRequestDTO.getNumberStudent(),
            studentRequestDTO.getNameStudent(),
            studentRequestDTO.getAddress(),
            studentRequestDTO.getEmail(),
            studentRequestDTO.getPhone(),
            studentRequestDTO.getMajor(),
            studentRequestDTO.getBirthday(),
            // studentRequestDTO.getGender(),
            studentRequestDTO.getClassroom()
          );
        return studentResponseDTO;
    }

    public void saveStudent(Student student){
        studentRepository.save(student);
    }
}
