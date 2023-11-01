package com.example.EnglishCenterManager_backend.admin;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Integer>{
    
    // boolean existsByUsernameAd(String usernameAd);

    // @Query("SELECT r.name FROM Admin u JOIN u.roles r WHERE u.usernameAd = :usernameAd")
    // List<String> findRoleNamesByUsernameAd(@Param("usernameAd") String usernameAd);

    // Optional<Admin> findByUsernameAd(String usernameAd);


}
