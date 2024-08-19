package com.eventflow.project.dto.usersdto;

import com.eventflow.project.entities.UserType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record UserRegistrationDTO(
        @NotBlank String username,
        @NotBlank String password,
        @Email String email,
        @Pattern(regexp = "^\\(?\\d{2}\\)?\\s?\\d{4,5}-\\d{4}$", message = "Número de telefone inválido")
        String phone,
        @NotNull UserType userType) {
}
