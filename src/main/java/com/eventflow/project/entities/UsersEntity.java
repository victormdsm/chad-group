package com.eventflow.project.entities;

import com.eventflow.project.dto.usersdto.UserRegistrationDTO;
import com.eventflow.project.dto.usersdto.UserUpdateDTO;
import com.eventflow.project.entities.enums.UserType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users_tb")
public class UsersEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "username", unique = true,nullable = false)
    private String username;
    @Column(name = "user_password", nullable = false)
    private String password;
    @Column(name = "phone", unique = true, nullable = false)
    private String phone;
    @Column(name = "user_name", nullable = false)
    private String name;


    @Enumerated(EnumType.STRING) @Column(name = "user_type", nullable = false)
    private UserType userType;

    @OneToMany(mappedBy = "users")
    private List<UsersEventsEntity> usersEvents;

    public UsersEntity (UserRegistrationDTO dto){
        this.username = dto.username();
        this.password = dto.password();
        this.phone = dto.phone();
        this.userType = dto.userType();;
    }

    public void updateFromDto(UserUpdateDTO dto) {
        if(dto.username() != null && !dto.username().isEmpty()){
            this.username = dto.username();
        }

        if(dto.phone() != null && !dto.phone().isEmpty()){
            this.phone = dto.phone();
        }
    }

}
