package com.eventflow.project.repositories;

import com.eventflow.project.entities.ParticipantsEventsEntity;
import com.eventflow.project.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ParticipantEventsRepository extends JpaRepository<ParticipantsEventsEntity, Long> {

    @Query("SELECT COUNT(p) FROM ParticipantsEventsEntity p WHERE p.event.id = :eventId AND p.status = :status")
    long countByEventIdAndStatus(@Param("eventId") Long eventId, @Param("status") Status status);
}
