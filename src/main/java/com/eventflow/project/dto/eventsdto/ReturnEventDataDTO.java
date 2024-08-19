package com.eventflow.project.dto.eventsdto;

import com.eventflow.project.entities.EventsEntitiy;

import java.time.LocalDateTime;

public record ReturnEventDataDTO(Long id, String title, String description, LocalDateTime startDateTime, LocalDateTime endDateTime, String location, int capacity) {
    public ReturnEventDataDTO(EventsEntitiy event) {
        this(event.getId(), event.getTitle(), event.getDescription(), event.getStartDateTime(), event.getEndDateTime(), event.getLocation(), event.getCapacity());
    }
}
