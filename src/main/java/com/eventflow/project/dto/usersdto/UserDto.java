package com.eventflow.project.dto.usersdto;

import com.eventflow.project.entities.enums.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserDto(
        @NotNull Long id,
        @Email @NotBlank String username,
        @NotBlank String password,
        @NotBlank String phone,
        @NotBlank String name,
        @NotBlank UserType userType) {
}
