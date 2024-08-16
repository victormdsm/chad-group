package com.eventflow.project.dto.participantsdto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantDTO {
    private long id;
    private String name;
    private String email;
    private String phone;
    private List<Long> eventIds;
    private List<Long> registrationIds;
    private List<Long> invitationIds;
    private List<Long> attendanceIds;
}
