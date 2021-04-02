package ac.facens.evento.acevento.dto;

public class EventDTO {

    private Long id;
    private String name;
    private String description;
    private String place;

    public EventDTO() {

    }

    public EventDTO(Long id, String name, String description, String place) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.place = place;
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
    
}
