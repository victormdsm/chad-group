package com.eventflow.project.controllers;

import com.eventflow.project.services.ParticipantEventsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/participants-events")
public class ParticipantEventsController {

    @Autowired
    private ParticipantEventsService participantEventsService;

    @GetMapping("/count/confirmed/{eventId}")
    public ResponseEntity<Long> countConfirmedParticipants(@PathVariable Long eventId) {
        try {
            long count = participantEventsService.countConfirmedParticipantsByEvent(eventId);
            return new ResponseEntity<>(count, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
