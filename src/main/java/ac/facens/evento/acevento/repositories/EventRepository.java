package ac.facens.evento.acevento.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import ac.facens.evento.acevento.entities.Event;

@Component
public class EventRepository {



    public List<Event> getEvents() {

        Event e = new Event();
        e.setId(1l);
        e.setName("gostoso");
        e.setDescription("perto do lago");
        e.setPlace("planalto central, 99");

        Event e1 = new Event();
        e1.setId(2l);
        e1.setName("ameba");
        e1.setDescription("em frente a quadra");
        e1.setPlace("tabuao da cerra, 1089");

        List<Event> list = new ArrayList<>();
        list.add(e);
        list.add(e1);

        return list;
    
    }
}