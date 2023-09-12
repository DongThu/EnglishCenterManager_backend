package com.example.EnglishCenterManager_backend.user;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationRequestDTO {
    @NotBlank(message = "Name is mandatory")
    private String name;
    @NotBlank(message = "Gender is mandatory")
    private String address;
    
    private LocalDate birthday;

    private Number phone;
    @NotBlank(message = "username is mandatory")
    private String email;
    @NotBlank(message = "password is mandatory")
    private String password;

}
