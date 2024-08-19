package com.eventflow.project.repositories;

import com.eventflow.project.entities.EventsEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventsRepository extends JpaRepository<EventsEntitiy, Long> {

    List<EventsEntitiy> findByUserId(Long userId);
}
