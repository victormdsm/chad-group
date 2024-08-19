package com.eventflow.project.dto.participantsdto;


import jakarta.validation.constraints.Pattern;

public record UpdateParticipantDTO(
         Long id,
         String nome,
         String email,
        @Pattern(regexp = "^\\(?\\d{2}\\)?\\s?\\d{4,5}-\\d{4}$",
                message = "Número de telefone inválido")
        String phone) {
}
