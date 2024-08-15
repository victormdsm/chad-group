package com.eventflow.project.repositories;

import com.eventflow.project.entities.EventsEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<EventsEntitiy, Long> {
}
