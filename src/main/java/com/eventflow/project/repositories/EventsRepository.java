package com.eventflow.project.repositories;

import com.eventflow.project.entities.EventsEntitiy;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EventsRepository extends JpaRepository<EventsEntitiy, Long> {

    List<EventsEntitiy> findByUserId(Long userId);

    List<EventsEntitiy> findByDate(LocalDate date);

    List<EventsEntitiy> findByDateBetween(LocalDate startDate, LocalDate endDate);

    List<EventsEntitiy> findByUser_Username(String userName);
}
