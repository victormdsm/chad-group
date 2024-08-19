package com.eventflow.project.controllers;

import com.eventflow.project.dto.eventsdto.CreatEventDTO;
import com.eventflow.project.dto.eventsdto.EventDTO;
import com.eventflow.project.dto.eventsdto.ReturnEventDataDTO;
import com.eventflow.project.dto.eventsdto.UpdateEventDTO;
import com.eventflow.project.services.EventsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventsController {

    @Autowired
    private EventsService eventsService;

    @PostMapping("/create")
    public ResponseEntity<ReturnEventDataDTO> createEvent(@Valid @RequestBody CreatEventDTO creatEventDTO){
        try {
            ReturnEventDataDTO eventCreated = this.eventsService.save(creatEventDTO);
            return new ResponseEntity<>(eventCreated, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update")
    public ResponseEntity<ReturnEventDataDTO> updateEvent(@Valid @RequestBody EventDTO eventDTO){
        try {
            ReturnEventDataDTO eventUpdated = this.eventsService.update(eventDTO);
            return new ResponseEntity<>(eventUpdated, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteEvent(@PathVariable Long id){
        try {
            String msg = this.eventsService.delete(id);
            return new ResponseEntity<>(msg, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findOne/{id}")
    public ResponseEntity<ReturnEventDataDTO> getEventById(@PathVariable Long id) {
        try {
            ReturnEventDataDTO event = this.eventsService.findById(id);
            return new ResponseEntity<>(event, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findAll")
    public ResponseEntity<List<ReturnEventDataDTO>> getAllEvents() {
        try {
            List<ReturnEventDataDTO> events = this.eventsService.findAll();
            return new ResponseEntity<>(events, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
