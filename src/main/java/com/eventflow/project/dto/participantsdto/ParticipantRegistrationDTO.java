package com.eventflow.project.dto.participantsdto;

import com.eventflow.project.entities.UsersEntity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ParticipantRegistrationDTO(
        @NotBlank String name,
        @Email String email,
        @Pattern(regexp = "^\\(?\\d{2}\\)?\\s?\\d{4,5}-\\d{4}$",
                message = "Número de telefone inválido")
        String phone,
        @NotNull Long id) {
}
