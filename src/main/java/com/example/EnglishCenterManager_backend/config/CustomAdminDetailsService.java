// package com.example.EnglishCenterManager_backend.config;

// import java.util.Collection;
// import java.util.List;
// import java.util.stream.Collectors;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.GrantedAuthority;
// import org.springframework.security.core.authority.SimpleGrantedAuthority;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import com.example.EnglishCenterManager_backend.admin.Admin;
// import com.example.EnglishCenterManager_backend.admin.AdminRepository;
// import com.example.EnglishCenterManager_backend.role.Role;

// @Service
// public class CustomAdminDetailsService implements UserDetailsService{
//     @Autowired
//     private AdminRepository adminRepository;

//      @Override
//     public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//         Admin user = adminRepository.findByUsernameAd(username).orElseThrow(() -> new UsernameNotFoundException("Lỗi"));
//         return new org.springframework.security.core.userdetails.User(user.getUsernameAd(),user.getPasswordAd()/* */,mapRolesToAuthorities(user.getRoles()));
//     }
    
//     private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
//         return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
//     }
// }
