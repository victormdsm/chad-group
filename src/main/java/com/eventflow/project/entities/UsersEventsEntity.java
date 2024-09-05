package com.eventflow.project.entities;

import com.eventflow.project.dto.participantseventsdto.ParticipantsEventsUpdateDTO;
import com.eventflow.project.entities.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users_events_tb")
public class UsersEventsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_date_time",nullable = false)
    private LocalDateTime registrationDateTime;

    @Column(name = "participant_status") @Enumerated(EnumType.STRING)
    private Status participantStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private UsersEntity users;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private EventsEntitiy event;

    public void update(ParticipantsEventsUpdateDTO dto) {
        this.id = dto.id();
        this.participantStatus = dto.status();
    }
}
