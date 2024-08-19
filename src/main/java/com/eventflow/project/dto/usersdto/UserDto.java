package com.eventflow.project.dto.usersdto;

import com.eventflow.project.entities.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
public record UserDto(
        @NotNull Long id,
        String username,
        String password,
        String email,
        String phone,
        UserType userType) {
}
