// package com.example.EnglishCenterManager_backend.config;
// import java.util.Arrays;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;
// import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
// import org.springframework.web.cors.CorsConfiguration;
// import org.springframework.web.cors.CorsConfigurationSource;
// import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

// @Configuration // biết để quét qua cấu hình của Security
// @EnableWebSecurity // Bật bảo mật web

// public class SecurityConfigAdmin {
//     @Autowired
//     private JwtAuthEntryPoint jwtAuthEntryPoint;

    
//     @Bean
//     public SecurityFilterChain securityFilterChainAdmin(HttpSecurity http) throws Exception {
//         http
//         .csrf((a) -> a.disable())
//         .cors((a) -> a.disable())
//         .exceptionHandling((ex) -> ex.authenticationEntryPoint(jwtAuthEntryPoint))
//         .sessionManagement((session)-> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
//         .authorizeHttpRequests(
//             (request) -> request.anyRequest().permitAll()
//             // .requestMatchers("/api/v1/user/**").authenticated()

//         )
//         ;

//         http.addFilterBefore(jwtAuthenticationFilterAdmin(), UsernamePasswordAuthenticationFilter.class);

//         return http.build();
//     }

//     //https://docs.spring.io/spring-security/reference/reactive/integrations/cors.html
//     // @Bean
//     // CorsConfigurationSource corsConfigurationSource() {
//     //     CorsConfiguration configuration = new CorsConfiguration();
//     //     configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
//     //     configuration.addAllowedMethod("*");
//     //     UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
//     //     source.registerCorsConfiguration("/**", configuration);
//     //     return source;
//     // }


//     @Bean // Cấu hình bean cho mã hóa mật khẩu
//     public PasswordEncoder passwordEncoderAdmin() {
//         return new BCryptPasswordEncoder();
//     }

//     @Bean // Cấu hình bean cho authenticationManager
//     public AuthenticationManager authenticationManagerAdmin(AuthenticationConfiguration authenticationConfiguration) throws Exception {
//         return authenticationConfiguration.getAuthenticationManager();
//     }

//     @Bean
//     public JwtAuthenticationFilterAdmin jwtAuthenticationFilterAdmin() {
//         return new JwtAuthenticationFilterAdmin();
//     }

// }
