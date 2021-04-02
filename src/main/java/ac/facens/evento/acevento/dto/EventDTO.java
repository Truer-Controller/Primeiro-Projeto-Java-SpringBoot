package ac.facens.evento.acevento.dto;

import ac.facens.evento.acevento.entities.Event;

public class EventDTO {

    private Long id;
    private String name;
    private String description;
    private String place;
    private String email;

    public EventDTO() {

    }

    public EventDTO(Long id, String name, String description, String place, String email) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.place = place;
        this.email = email;
    }

    public EventDTO(Event eve) {
        this.id = eve.getId();
        this.name = eve.getName();
        this.description = eve.getDescription();
        this.place = eve.getPlace();
        this.email = eve.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
