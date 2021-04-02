package ac.facens.evento.acevento.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ac.facens.evento.acevento.dto.EventDTO;
import ac.facens.evento.acevento.services.EventService;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping
    public ResponseEntity<List<EventDTO>> getEvent() {
        List<EventDTO> list = service.getEvents();
        return ResponseEntity.ok(list);
    }

}
