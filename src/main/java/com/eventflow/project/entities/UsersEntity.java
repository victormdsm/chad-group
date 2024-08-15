package com.eventflow.project.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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

    @NotNull @NotBlank @Column(name = "username", unique = true,nullable = false)
    private String username;

    @NotNull @NotBlank @Column(name = "user_password", nullable = false)
    private String password;

    @NotNull @NotBlank @Email @Column(name = "email", unique = true, nullable = false)
    private String email;

    @NotNull @NotBlank @Column(name = "phone", unique = true, nullable = false)
    private String phone;

    @NotNull @Enumerated(EnumType.STRING) @Column(name = "user_type", nullable = false)
    private UserType userType;

}
