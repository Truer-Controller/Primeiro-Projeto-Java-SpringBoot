package ac.facens.evento.acevento.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ac.facens.evento.acevento.dto.EventDTO;
import ac.facens.evento.acevento.entities.Event;
import ac.facens.evento.acevento.repositories.EventRepository;

@Service
public class EventService {

    @Autowired
    private EventRepository repo;

    public List<EventDTO> getEvents() {

        List<Event> list = repo.getEvents();
        List<EventDTO> listDTO = new ArrayList<>();

        for (Event e : list) {
            EventDTO dto = new EventDTO(e.getId(), e.getName(), e.getDescription(), e.getPlace());
            listDTO.add(dto);
        }
        return listDTO;
    }

}
