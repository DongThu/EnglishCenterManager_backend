package com.example.EnglishCenterManager_backend.student;

import com.example.EnglishCenterManager_backend.role.Role;
import com.example.EnglishCenterManager_backend.user.User;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // Tạo bảng trong CSDL
public class Student {

    @Id // Đánh dấu đây là ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // trường tăng tự động
    private Integer id;

    @Column(unique = true)
    private String numberStudent;

    private String nameStudent;
    
    private String address;

    private String email;

    private String phone;

    private String major;

    private String birthday;

    // private Integer gender;

    private String classroom;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "role_id")
    private Role role;

    public Student(String numberStudent, String nameStudent, String address, String email, String phone, String major,
        String birthday, String classroom) {
            this.numberStudent = numberStudent;
            this.nameStudent = nameStudent;
            this.address = address;
            this.email = email;
            this.phone = phone;
            this.major = major;
            this.birthday = birthday;
            this.classroom = classroom;

    }


}
