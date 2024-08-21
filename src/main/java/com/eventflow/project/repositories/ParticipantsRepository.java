package com.eventflow.project.repositories;

import com.eventflow.project.entities.ParticipantsEntity;
import com.eventflow.project.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ParticipantsRepository extends JpaRepository<ParticipantsEntity, Long>{

    List<ParticipantsEntity> findByName(String name);

    List<ParticipantsEntity> findByEmail(String email);
}
