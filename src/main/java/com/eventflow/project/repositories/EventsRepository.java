package com.eventflow.project.repositories;

import com.eventflow.project.entities.EventsEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface EventsRepository extends JpaRepository<EventsEntitiy, Long> {

    List<EventsEntitiy> findByUserId(Long userId);

    List<EventsEntitiy> findByStartDateTime(LocalDateTime date);

    List<EventsEntitiy> findByStartDateTimeBetween(LocalDateTime startDate, LocalDateTime endDate);

    List<EventsEntitiy> findByUser_Username(String userName);
}
