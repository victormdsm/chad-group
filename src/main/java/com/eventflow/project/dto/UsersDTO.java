package com.eventflow.project.dto;

import com.eventflow.project.entities.UserType;
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
public class UsersDTO {

    private Long id;

    @NotNull @NotBlank
    private String username;

    @NotNull @NotBlank
    private String password;

    @NotNull @NotBlank @Email
    private String email;

    @NotNull @NotBlank
    private String phone;

    @NotNull
    private UserType userType;
}
