package com.eventflow.project.controllers;

import com.eventflow.project.dto.eventsdto.CreatEventDTO;
import com.eventflow.project.dto.eventsdto.ReturnEventDataDTO;
import com.eventflow.project.dto.eventsdto.UpdateEventDTO;
import com.eventflow.project.entities.EventsEntitiy;
import com.eventflow.project.services.EventsService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/events")
public class EventsController {

    @Autowired
    private EventsService eventsService;

    @PostMapping("/create")
    public ResponseEntity<ReturnEventDataDTO> save(@RequestBody @Valid CreatEventDTO dto) {
        try {
            var user = eventsService.findUserById(dto.userID());
            var event = new EventsEntitiy(dto, user);
            ReturnEventDataDTO retorno = new ReturnEventDataDTO(eventsService.save(event));
            return new ResponseEntity<>(retorno, HttpStatus.CREATED);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ReturnEventDataDTO> update(@PathVariable Long id, @RequestBody @Valid UpdateEventDTO dto) {
        try {
            var event = eventsService.findById(id);
            event.updateFromDto(dto);
            ReturnEventDataDTO retorno = new ReturnEventDataDTO(eventsService.update(event));
            return new ResponseEntity<>(retorno, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findbyid/{id}")
    public ResponseEntity<ReturnEventDataDTO> findById(@PathVariable Long id) {
        try {
            var event = eventsService.findById(id);
            ReturnEventDataDTO retorno = new ReturnEventDataDTO(event);
            return new ResponseEntity<>(retorno, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findall")
    public ResponseEntity<List<ReturnEventDataDTO>> findAll() {
        try {
            List<EventsEntitiy> events = eventsService.findAll();
            return new ResponseEntity<>(events.stream()
                    .map(ReturnEventDataDTO::new)
                    .collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        try {
            String message = eventsService.delete(id);
            return new ResponseEntity<>(message, HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/findbydate/{date}")
    public ResponseEntity<List<ReturnEventDataDTO>> findByDate(@PathVariable LocalDate date) {
        try {
            List<EventsEntitiy> events = eventsService.findEventsByDate(date);
            return new ResponseEntity<>(events.stream()
                    .map(ReturnEventDataDTO::new)
                    .collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findbetween")
    public ResponseEntity<List<ReturnEventDataDTO>> findBetweenDates(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate startDate,
                                                                     @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDate endDate) {
        try {
            List<EventsEntitiy> events = eventsService.findEventsBetweenDates(startDate, endDate);
            return new ResponseEntity<>(events.stream()
                    .map(ReturnEventDataDTO::new)
                    .collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/findbyusername")
    public ResponseEntity<List<ReturnEventDataDTO>> findByUserName(@RequestParam("username") String username) {
        try {
            List<EventsEntitiy> events = eventsService.findEventsByUserName(username);
            return new ResponseEntity<>(events.stream()
                    .map(ReturnEventDataDTO::new)
                    .collect(Collectors.toList()), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
        }
    }
}
