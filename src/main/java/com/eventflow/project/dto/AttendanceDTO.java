package com.eventflow.project.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AttendanceDTO {
    private long id;
    private long eventId;
    private long participantId;
    private LocalDateTime arrivalDateTime;
    private String status;
}
