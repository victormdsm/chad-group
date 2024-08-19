package com.eventflow.project.entities;

import com.eventflow.project.dto.usersdto.UserRegistrationDTO;
import com.eventflow.project.dto.usersdto.UserUpdateDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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
    @Email @Column(name = "email", unique = true, nullable = false)
    private String email;
    @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    @OneToMany(mappedBy = "users")
    List<ParticipantsEntity> participantsEntityList;

    @Enumerated(EnumType.STRING) @Column(name = "user_type", nullable = false)
    private UserType userType;

    public UsersEntity (UserRegistrationDTO dto){
        this.username = dto.username();
        this.password = dto.password();
        this.email = dto.email();
        this.phone = dto.phone();
        this.userType = dto.userType();;
    }

    public void updateFromDto(UserUpdateDTO dto) {
        if(dto.username() != null && !dto.username().isEmpty()){
            this.username = dto.username();
        }

        if(dto.email() != null && !dto.email().isEmpty()){
            this.email = dto.email();
        }

        if(dto.phone() != null && !dto.phone().isEmpty()){
            this.phone = dto.phone();
        }
    }

}
