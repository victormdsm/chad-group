package com.eventflow.project.repositories;

import com.eventflow.project.entities.InvitationsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvitationsRepository extends JpaRepository<InvitationsEntity, Long> {
}
