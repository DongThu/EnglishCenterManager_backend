package com.example.EnglishCenterManager_backend.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("user")
public class UserResource {
    
    @Autowired
    private UserService userService;

    @GetMapping("all")
    public UserRegistrationResponseDTO getAll() {
    return  userService.getAll();
    }

    @PostMapping("register")
    public ResponseEntity<UserRegistrationResponseDTO> registerUser(@Valid @RequestBody UserRegistrationRequestDTO userRegistrationRequestDTO){
        UserRegistrationResponseDTO user = userService.registerUser(userRegistrationRequestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(user);
    }

}
