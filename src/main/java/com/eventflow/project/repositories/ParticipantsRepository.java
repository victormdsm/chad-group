package com.eventflow.project.repositories;

import com.eventflow.project.entities.ParticipantsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantsRepository extends JpaRepository<ParticipantsEntity, Long>{
}
