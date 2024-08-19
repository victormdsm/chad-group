package com.eventflow.project.entities;

import com.eventflow.project.dto.eventsdto.CreatEventDTO;
import com.eventflow.project.dto.eventsdto.EventDTO;
import com.eventflow.project.dto.eventsdto.UpdateEventDTO;
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
@Table(name = "events_tb")
public class EventsEntitiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "event_description")
    private String description;

    @Column(name = "start_date_time", nullable = false)
    private LocalDateTime startDateTime;

    @Column(name = "end_date_time", nullable = false)
    private LocalDateTime endDateTime;

    @Column(name = "location", nullable = false)
    private String location;

    @Column(name = "capacity",nullable = false)
    private int capacity;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UsersEntity user;

    //TODO COMENTADO PARA TESTE
//    @ManyToMany( mappedBy = "events")
//    private List<ParticipantsEntity> participants = new ArrayList<>();

    @OneToMany(mappedBy = "event")
    private List<ParticipantsEventsEntity> participantsEvents;

    @OneToMany(mappedBy = "event")
    private List<InvitationsEntity> invitations;

    public EventsEntitiy(CreatEventDTO dto, UsersEntity user) {
        this.title = dto.title();
        this.description = dto.description();
        this.startDateTime = dto.dateTime();
        this.endDateTime = dto.endDateTime();
        this.location = dto.location();
        this.capacity = dto.capacity();
        this.user = user;
    }


    public void updateFromDto(UpdateEventDTO dto) {
        this.title = dto.title();
        this.description = dto.description();
        this.startDateTime = dto.startDateTime();
        this.endDateTime = dto.endDateTime();
        this.location = dto.location();
        this.capacity = dto.capacity();
    }
}
