package com.example.EnglishCenterManager_backend.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.ManyToAny;

import com.example.EnglishCenterManager_backend.role.Role;
import com.example.EnglishCenterManager_backend.role.RoleEnum;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity // Tạo bảng trong CSDL
@Table(name = "users") // tên bảng được đặt là users vì user trùng với CSDL
public class User {

    @Id // Đánh dấu đây là ID
    @GeneratedValue(strategy = GenerationType.IDENTITY) // trường tăng tự động
    private Integer id;

    @NotEmpty(message = "name cannot be null")
    private String name;
        
    @NotEmpty(message = "address cannot be null")
    private String address;
        
    @NotNull(message = "phone cannot be null")
    private Number phone;
       
    // @NotEmpty(message = "Username cannot be null")
    private LocalDate birthday;

    @NotEmpty(message = "Username cannot be null")
    private String username;

    @NotEmpty(message = "Password cannot be null")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.ALL) //EAGER tải toàn bộ dữ liệu cùng lúc của bảng khóa ngoại, CascadeType.ALL lan truyền sự kiện giữa Parent Table and Child Table
    @JoinTable(name = "user_role"
        ,joinColumns = @JoinColumn(name = "user_id",referencedColumnName = "id") //Đem cột id trong bảng user vào thành user_id
        ,inverseJoinColumns  = @JoinColumn(name = "role_id",referencedColumnName = "id") //Đem cột id trong bảng Role vào thành role_id
    )
    private List<Role> roles = new ArrayList<>();

    public User(String username) {
        this. username = username;

    }
   
}
