package com.eventflow.project.dto.eventsdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EventDTO {
    private long id;
    private String title;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String location;
    private int capacity;
    private List<Long> participantIds;
    private List<Long> registrationIds;
    private List<Long> invitationIds;
    private List<Long> attendanceIds;
}
