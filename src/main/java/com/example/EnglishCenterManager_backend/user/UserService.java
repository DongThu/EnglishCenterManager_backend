package com.example.EnglishCenterManager_backend.user;

import org.springframework.beans.factory.annotation.Autowired;
import static org.springframework.http.HttpStatus.BAD_REQUEST;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.EnglishCenterManager_backend.config.JwtGenerator;
import com.example.EnglishCenterManager_backend.exception.UsernameAlreadyExistsException;
import com.example.EnglishCenterManager_backend.infoTeacher.InfoTeacher;
import com.example.EnglishCenterManager_backend.login.LoginDTO;
import com.example.EnglishCenterManager_backend.role.Role;
import com.example.EnglishCenterManager_backend.role.RoleRepository;


import jakarta.transaction.Transactional;

@Service
public class UserService {
    
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;

    private RoleRepository roleRepository;

    private AuthenticationManager authenticationManager;

    private JwtGenerator jwtGenerator;

    @Autowired //tiêm phụ thuộc vào
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository,
            AuthenticationManager authenticationManager, JwtGenerator jwtGenerator) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.roleRepository = roleRepository;
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
    }

    @Transactional //Đánh dấu là 1 giao dịch, nếu có vấn đề nó rollback hết
    public void register(User user) {

        // Nếu tài khoản tồn tại thì ném ra exception
        if(userRepository.existsByUsername(user.getUsername())) {
            throw new UsernameAlreadyExistsException("Account already exists", BAD_REQUEST);
        }

        //Tìm role
        Role role = roleRepository.findByName("ADMIN");

        // Set role
        user.setRoles(Collections.singletonList(role));
        
        // Mã hóa mật khẩu
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        // Save Mật khẩu
        userRepository.save(user);
    }

    public String login(LoginDTO loginDTO) {

        Authentication authentication = authenticationManager
            .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
        
        SecurityContextHolder.getContext().setAuthentication(authentication);
        
        String token = jwtGenerator.generateToken(authentication);

        return token;
    }

    public List<String> getRoleByUsername(String username) {
        if(!userRepository.existsByUsername(username)) {
            throw new UsernameNotFoundException(username + " not found");
        }else { 
            return userRepository.findRoleNamesByUsername(username);
        }
    }

    public List<User> getListRegister(){
        return userRepository.findAll();
    }

    public void deleteRegister(Integer id){
        userRepository.deleteById(id);
    }

    public Optional<User> getUserById(Integer id){
       return userRepository.findById(id);
    }

     public Optional<User> findByUsername(String username){
       return userRepository.findByUsername(username);
    }

    public void findByUsernameusername() {
    }

    public User updateUser(Integer id, User user) {
        User fromDB = userRepository.findById(id).orElse(null);
        if (fromDB == null){
            return null;
        }
        fromDB.setName(user.getName());
        fromDB.setAddress(user.getAddress());
        fromDB.setBirthday(user.getBirthday());
        fromDB.setPhone(user.getPhone());
        fromDB.setUsername(user.getUsername());
        fromDB.setPassword(user.getPassword());
        return userRepository.save(fromDB);
    }
}

