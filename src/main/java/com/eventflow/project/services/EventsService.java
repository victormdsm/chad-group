package com.eventflow.project.services;

import com.eventflow.project.dto.eventsdto.CreatEventDTO;
import com.eventflow.project.dto.eventsdto.EventDTO;
import com.eventflow.project.dto.eventsdto.ReturnEventDataDTO;
import com.eventflow.project.entities.EventsEntitiy;
import com.eventflow.project.entities.UsersEntity;
import com.eventflow.project.repositories.EventsRepository;
import com.eventflow.project.repositories.UsersRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    @Autowired
    private UsersRepository usersRepository;

    public EventsEntitiy save(@Valid EventsEntitiy eventsEntitiy) {
       return this.eventsRepository.save(eventsEntitiy);
    }

    public EventsEntitiy update(@Valid EventsEntitiy eventsEntitiy) {
       this.eventsRepository.save(eventsEntitiy);
       return eventsEntitiy;
    }

    public String delete(@Valid Long id){
        if (eventsRepository.existsById(id)){
            eventsRepository.deleteById(id);
            return "Evento Excluido";
        }
        return "Evento não encontrado";
    }

    public EventsEntitiy findById(Long id) {
        EventsEntitiy event = eventsRepository.findById(id).get();
        return event;
    }

    public List<EventsEntitiy> findAll() {
        List<EventsEntitiy> events = eventsRepository.findAll();
       return events;
    }

    public UsersEntity findUserById(Long userId) {

        UsersEntity user = usersRepository.findById(userId).orElse(null);
        if (user == null) {
            throw new IllegalArgumentException("Usuário não encontrado para o ID: " + userId);
        }

        return user;
    }

    public List<EventsEntitiy> findEventsByDate(LocalDate date) {
        return eventsRepository.findByDate(date);
    }

    public List<EventsEntitiy> findEventsBetweenDates(LocalDate startDate, LocalDate endDate) {
        return eventsRepository.findByDateBetween(startDate, endDate);
    }

    public List<EventsEntitiy> findEventsByUserName(String userName) {
        return eventsRepository.findByUser_Username(userName);
    }
}
