package com.eventflow.project.services;

import com.eventflow.project.entities.EventsEntitiy;
import com.eventflow.project.repositories.EventsRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventsService {

    @Autowired
    private EventsRepository eventsRepository;

    public EventsEntitiy save(@Valid EventsEntitiy eventsEntitiy){
        return this.eventsRepository.save(eventsEntitiy);
    }

    public EventsEntitiy update(@Valid EventsEntitiy eventsEntitiy, Long id){
        if (eventsRepository.existsById(id)){
            eventsEntitiy.setId(id);
            return eventsRepository.save(eventsEntitiy);
        }
        return  null;
    }

    public String delete(@Valid Long id){
        if (eventsRepository.existsById(id)){
            eventsRepository.deleteById(id);
            return "Evento Excluido";
        }
        return null;
    }

    public EventsEntitiy findById(@Valid Long id){
        EventsEntitiy eventsEntitiy = eventsRepository.findById(id).get();
        return eventsEntitiy;
    }

    public List<EventsEntitiy> findAll(){
        List<EventsEntitiy> list = eventsRepository.findAll();
        return list;
    }
}
