package com.eventflow.project.dto.participantsdto;

import com.eventflow.project.dto.usersdto.UserDto;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record ParticipantDTO(
        @NotNull Long id,
        String name,
        String email,
        String phone,
        UserDto dto
) {

}
