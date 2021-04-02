package ac.facens.evento.acevento.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ac.facens.evento.acevento.dto.EventDTO;
import ac.facens.evento.acevento.dto.EventInsertDTO;
import ac.facens.evento.acevento.entities.Event;
import ac.facens.evento.acevento.repositories.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository repo;

    public List<EventDTO> getEvents() {

        List<Event> list = repo.findAll();
        return toDTOList(list);
       
    }

    public EventDTO getEventById(Long id){

      Optional<Event> op = repo.findById(id);

      Event eve = op.orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Client Not Found"));

      return new EventDTO(eve);

    }

    public EventDTO insert(EventInsertDTO dto){
        Event entity = new Event(dto);
        entity =  repo.save(entity);
        return new EventDTO(entity);
    }

    public void delete(Long id){
        try{
        repo.deleteById(id);
        }
        catch(EmptyResultDataAccessException a){
           throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Client Not Found");
        }
    }
    
    public List<EventDTO> toDTOList(List<Event> list){

        List<EventDTO> listDTO = new ArrayList<>();

        for (Event e : list) {
            EventDTO dto = new EventDTO(e.getId(), e.getName(), e.getDescription(), e.getPlace(), e.getEmail());
            listDTO.add(dto);
        }
        return listDTO;
    }

}
