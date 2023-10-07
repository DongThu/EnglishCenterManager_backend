// package com.example.EnglishCenterManager_backend.admin;

// import java.util.List;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.EnglishCenterManager_backend.authentication.AuthResponseDTO;
// import com.example.EnglishCenterManager_backend.login.LoginDTO;
// import com.example.EnglishCenterManager_backend.message.SuccessMessage;

// import jakarta.validation.Valid;

// @RestController
// @RequestMapping("/admin")
// public class AdminResourse {
//     @Autowired //tiêm phụ thuộc vào
//     private AdminService adminService;
//     public AdminResourse(AdminService adminService) {
//         this.adminService = adminService;
//     }

//     @PostMapping("register")
//     public ResponseEntity<SuccessMessage> register( @Valid @RequestBody Admin admin) {
//         adminService.register(admin);
//         return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessMessage("Account successfully created"));
//     }

//     @PostMapping("login")
//     public ResponseEntity<AuthResponseDTO> login(@Valid @RequestBody LoginDTO loginDTO){ 
//         String token = adminService.login(loginDTO);
//         return ResponseEntity.status(HttpStatus.OK).body(new AuthResponseDTO(token));
//     }

//     @GetMapping("role/{username}")
//     public ResponseEntity<List<String>> getRoleByUsername(@PathVariable("username") String username) {
//         return ResponseEntity.status(HttpStatus.OK).body(this.adminService.getRoleByUsername(username));
//     }

// }
