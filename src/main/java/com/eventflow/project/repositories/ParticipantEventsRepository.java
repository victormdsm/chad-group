package com.eventflow.project.repositories;

import com.eventflow.project.entities.ParticipantsEntity;
import com.eventflow.project.entities.ParticipantsEventsEntity;
import com.eventflow.project.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipantEventsRepository extends JpaRepository<ParticipantsEventsEntity, Long> {

    @Query("SELECT COUNT(pe) FROM ParticipantsEventsEntity pe WHERE pe.event.id = :eventId AND pe.participantStatus = :status")
    long countByEventIdAndStatus(@Param("eventId") Long eventId, @Param("status") Status status);
}