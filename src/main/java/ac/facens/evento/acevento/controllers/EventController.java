package ac.facens.evento.acevento.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import ac.facens.evento.acevento.dto.EventDTO;
import ac.facens.evento.acevento.dto.EventInsertDTO;
import ac.facens.evento.acevento.dto.EventUpdateDTO;
import ac.facens.evento.acevento.services.EventService;

@RestController
@RequestMapping("/events")
public class EventController {

    @Autowired
    private EventService service;

    @GetMapping
    public ResponseEntity<Page<EventDTO>> getEvents(

            @RequestParam(value = "page",           defaultValue = "0") Integer page,
            @RequestParam(value = "linesPerPage",   defaultValue = "6") Integer linesPerPage,
            @RequestParam(value = "direction",      defaultValue = "ASC") String direction,
            @RequestParam(value = "orderBy",        defaultValue = "id") String orderBy,
            @RequestParam(value = "name",           defaultValue = "") String name,
            @RequestParam(value = "description",    defaultValue = "") String description,
            @RequestParam(value = "place",    defaultValue = "") String place,
            @RequestParam(value = "datainicio",    defaultValue = "2019-05-10") String datainicio,
            @RequestParam(value = "tempoinicio",    defaultValue = "00:00:00") String tempoinicio
            

    ) {

        PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

        Page<EventDTO> list = service.getEvents(pageRequest, name.trim(), description.trim(), place.trim(), datainicio.trim(), tempoinicio.trim());
        return ResponseEntity.ok(list);
    }

    @GetMapping("{id}")
    public ResponseEntity<EventDTO> getEventById(@PathVariable Long id) {
        EventDTO dto = service.getEventById(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<EventDTO> insert(@RequestBody EventInsertDTO insertDto) {
        EventDTO dto = service.insert(insertDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<EventDTO> update(@RequestBody EventUpdateDTO updateDto, @PathVariable Long id) {
        EventDTO dto = service.update(id, updateDto);
        return ResponseEntity.ok().body(dto);
    }

}
