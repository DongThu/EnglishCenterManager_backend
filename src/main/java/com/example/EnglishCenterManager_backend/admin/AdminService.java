// package com.example.EnglishCenterManager_backend.admin;

// import java.util.Collections;
// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// import com.example.EnglishCenterManager_backend.config.JwtGenerator;
// import com.example.EnglishCenterManager_backend.exception.UsernameAlreadyExistsException;
// import com.example.EnglishCenterManager_backend.login.LoginDTO;
// import com.example.EnglishCenterManager_backend.role.Role;
// import com.example.EnglishCenterManager_backend.role.RoleRepository;
// import static org.springframework.http.HttpStatus.BAD_REQUEST;
// import jakarta.transaction.Transactional;

// @Service
// public class AdminService {

//     @Autowired
//     private AdminRepository adminRepository;

//     private PasswordEncoder passwordEncoder;

//     private RoleRepository roleRepository;

//     private AuthenticationManager authenticationManager;

//     private JwtGenerator jwtGenerator;

//     @Autowired //tiêm phụ thuộc vào
//     public AdminService(AdminRepository adminRepository, PasswordEncoder passwordEncoder, RoleRepository roleRepository,
//             AuthenticationManager authenticationManager, JwtGenerator jwtGenerator) {
        
//         this.adminRepository = adminRepository;
//         this.passwordEncoder = passwordEncoder;
//         this.roleRepository = roleRepository;
//         this.authenticationManager = authenticationManager;
//         this.jwtGenerator = jwtGenerator;
//     }

//     @Transactional //Đánh dấu là 1 giao dịch, nếu có vấn đề nó rollback hết
//     public void register(Admin admin) {

//         // Nếu tài khoản tồn tại thì ném ra exception
//         if(adminRepository.existsByUsernameAd(admin.getUsernameAd())) {
//             throw new UsernameAlreadyExistsException("Account already exists", BAD_REQUEST);
//         }

//         //Tìm role
//         Role role = roleRepository.findByName("ADMIN");

//         // Set role
//         admin.setRoles(Collections.singletonList(role));
        
//         // Mã hóa mật khẩu
//         admin.setPasswordAd(passwordEncoder.encode(admin.getPasswordAd()));

//         // Save Mật khẩu
//         adminRepository.save(admin);
//     }

//     public String login(LoginDTO loginDTO) {

//         Authentication authentication = authenticationManager
//             .authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword()));
        
//         SecurityContextHolder.getContext().setAuthentication(authentication);
        
//         String token = jwtGenerator.generateToken(authentication);

//         return token;
//     }

//     public List<String> getRoleByUsername(String usernameAd) {
//         if(!adminRepository.existsByUsernameAd(usernameAd)) {
//             throw new UsernameNotFoundException(usernameAd + " not found");
//         }else { 
//             return adminRepository.findRoleNamesByUsernameAd(usernameAd);
//         }
//     }

//     public List<Admin> getListRegister(){
//         return adminRepository.findAll();
//     }

//     public void deleteRegister(Integer id){
//         adminRepository.deleteById(id);
//     }
// }


