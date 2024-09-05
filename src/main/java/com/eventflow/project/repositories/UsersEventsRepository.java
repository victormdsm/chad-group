package com.eventflow.project.repositories;

import com.eventflow.project.entities.UsersEventsEntity;
import com.eventflow.project.entities.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UsersEventsRepository extends JpaRepository<UsersEventsEntity, Long> {

//    @Query("SELECT COUNT(pe) FROM ParticipantsEventsEntity pe WHERE pe.event.id = :eventId AND pe.participantStatus = :status")
//    long countByEventIdAndStatus(@Param("eventId") Long eventId, @Param("status") Status status);
}