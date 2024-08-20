package com.eventflow.project.entities;

import com.eventflow.project.dto.eventsdto.EventDTO;
import com.eventflow.project.dto.participantsdto.ParticipantDTO;
import com.eventflow.project.dto.participantseventsdto.ParticipantsEventsUpdateDTO;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.w3c.dom.events.Event;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "participants_events_tb")
public class ParticipantsEventsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "registration_date_time",nullable = false)
    private LocalDateTime registrationDateTime;

    @Column(name = "participant_status") @Enumerated(EnumType.STRING)
    private Status participantStatus;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "participant_id",nullable = false)
    private ParticipantsEntity participant;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private EventsEntitiy event;

    public void update(ParticipantsEventsUpdateDTO dto) {
        this.id = dto.id();
        this.participantStatus = dto.status();
    }
}
