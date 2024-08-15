package com.eventflow.project.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "events")
public class EventsEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull(message = "Esse campo não pode ser nulo")
    @NotBlank(message = "Esse campo não pode ser vazio")
    private String title;
    private String description;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private String location;
    private int capacity;

    @ManyToMany(mappedBy = "events")
    private List<ParticipantsEntity> participants = new ArrayList<>();

    @OneToMany(mappedBy = "event")
    private List<RegistrationEntity> registrations;

    @OneToMany(mappedBy = "event")
    private List<InvitationsEntity> invitations;

    @OneToMany(mappedBy = "event")
    private List<AttendancesEntity> attendances;

}
