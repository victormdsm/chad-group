package com.eventflow.project.repositories;

import com.eventflow.project.entities.ParticipantsEventsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantEventsRepository extends JpaRepository<ParticipantsEventsEntity, Long> {
}
