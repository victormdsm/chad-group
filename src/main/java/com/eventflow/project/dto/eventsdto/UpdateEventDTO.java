package com.eventflow.project.dto.eventsdto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record UpdateEventDTO (
        Long id,
        @NotBlank String title,
        @NotBlank String description,
        @NotNull LocalDateTime startDateTime,
        @NotNull LocalDateTime endDateTime,
        @NotBlank String location,
        @Min(1) Integer capacity) {
}
