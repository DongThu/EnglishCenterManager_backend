package com.example.EnglishCenterManager_backend.student;

import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.EnglishCenterManager_backend.role.Role;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentRequestDTO {

    @NotEmpty(message = "Username cannot be empty")
    private String numberStudent;

    @NotEmpty(message = "Name cannot be empty")
    private String nameStudent;

    @NotEmpty(message = "Address cannot be empty")
    private String address;

    @NotEmpty(message = "Email cannot be empty")
    // @Email(message = "Email invalid")
    private String email;

    @NotEmpty(message = "Phone cannot be empty")
    private String phone;
    
    @NotEmpty(message = "Major cannot be empty")
    private String major;

    @NotEmpty(message = "Birthday cannot be empty")
    private String birthday;

    // @NotNull(message = "Gender cannot be null")
    // private Integer gender;

    @NotEmpty(message = "Classroom cannot be empty")
    private String classroom;

    @NotEmpty(message = "username cannot be empty")
    private String username;

    @NotEmpty(message = "password cannot be empty")
    private String password;

    @NotEmpty(message = "role cannot be empty")
    private String role;


    //  public String setUsername(String username){
    //     return this.username = username;
    //  }
    //  public String setPassword(String password){
    //     return this.password = password;
    //  }
    //  private PasswordEncoder passwordEncoder;
    //  public String getPassword(String pw){
    //     pw = password;
    //     return pw;
        
    //  }
}
