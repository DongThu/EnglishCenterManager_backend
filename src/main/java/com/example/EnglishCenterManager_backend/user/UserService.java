package com.example.EnglishCenterManager_backend.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.EnglishCenterManager_backend.account.Account;
import com.example.EnglishCenterManager_backend.account.Role;

import jakarta.transaction.Transactional;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;

    @Transactional
    public UserRegistrationResponseDTO registerUser(UserRegistrationRequestDTO userRegistrationRequestDTO){

        User user = new User(
            userRegistrationRequestDTO.getName(),
            userRegistrationRequestDTO.getAddress(),
            userRegistrationRequestDTO.getBirthday(),
             userRegistrationRequestDTO.getPhone()
        );
    
        Account account = new Account(
            userRegistrationRequestDTO.getEmail(),
            userRegistrationRequestDTO.getPassword(),
            Role.CUSTOMER
        );

        user.setAccount(account);

        userRepository.save(user);
        
        UserRegistrationResponseDTO userRegistrationResponseDTO = new UserRegistrationResponseDTO(
            userRegistrationRequestDTO.getName(), 
            userRegistrationRequestDTO.getAddress(),
            userRegistrationRequestDTO.getBirthday(),
            userRegistrationRequestDTO.getPhone());
        return userRegistrationResponseDTO;
    }

    public  UserRegistrationResponseDTO getAll(){
        return (UserRegistrationResponseDTO) userRepository.findAll();
    }

}
