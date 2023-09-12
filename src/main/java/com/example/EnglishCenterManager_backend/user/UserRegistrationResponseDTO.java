package com.example.EnglishCenterManager_backend.user;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRegistrationResponseDTO {

    private String name;

    private String address;

    private LocalDate birthday;

    private  Number phone;

}
