package com.eventflow.project.entities;

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
@Table(name = "Registrations")
public class RegistrationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "event_id", nullable = false)
    private EventsEntitiy event;

    @ManyToOne
    @JoinColumn(name = "participant_id", nullable = false)
    private ParticipantsEntity participant;

    private LocalDateTime registrationDate;

    @Enumerated(EnumType.STRING)
    private Status status;

}


