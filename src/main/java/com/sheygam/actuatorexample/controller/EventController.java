package com.sheygam.actuatorexample.controller;

import com.sheygam.actuatorexample.monitoring.EventControllerMetric;
import com.sheygam.actuatorexample.repository.EventEntity;
import com.sheygam.actuatorexample.repository.EventRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class EventController {

    private EventRepository repository;
    private EventControllerMetric metric;

    public EventController(EventRepository repository, EventControllerMetric metric) {
        this.repository = repository;
        this.metric = metric;
    }


    @PostMapping("event")
    public void addEvent(@RequestBody EventDto event){
        metric.handleGetEvents();
        repository.add(mapToEntity(event));
    }


    @GetMapping("event/all")
    public List<EventDto> getAll(){
        metric.handleAddEvent();
        return repository.getAll()
                .stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    private EventDto mapToDto(EventEntity entity) {
        EventDto dto = new EventDto();
        dto.authorEmail = entity.authorEmail;
        dto.title = entity.title;
        dto.description = entity.description;
        dto.date = entity.date;
        return dto;
    }

    private EventEntity mapToEntity(EventDto dto) {
        EventEntity entity = new EventEntity();
        entity.title = dto.title;
        entity.description = dto.description;
        entity.authorEmail = dto.authorEmail;
        entity.date = dto.date;
        return entity;
    }
}
