package ac.facens.evento.acevento.dto;

import java.time.LocalDate;
import java.time.LocalTime;

import ac.facens.evento.acevento.entities.Event;

public class EventDTO {

    private Long id;
    private String name;
    private String description;
    private String place;
    private String email;
    private LocalDate datainicio;
    private LocalDate datatermino;
    private LocalTime tempoinicio;
    private LocalTime tempotermino;

    public EventDTO() {

    }

    public EventDTO(Long id, String name, String description, String place, String email, LocalDate datainicio, LocalDate datatermino, LocalTime tempoinicio, LocalTime tempotermino) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.place = place;
        this.email = email;
        this.datainicio = datainicio;
        this.datatermino = datatermino;
        this.tempoinicio = tempoinicio;
        this.tempotermino = tempotermino;
    }

    public EventDTO(Event eve) {
        this.id = eve.getId();
        this.name = eve.getName();
        this.description = eve.getDescription();
        this.place = eve.getPlace();
        this.email = eve.getEmail();
        this.datainicio = eve.getDatainicio();
        this.datatermino = eve.getDatatermino();
        this.tempoinicio = eve.getTempoinicio();
        this.tempotermino = eve.getTempotermino();
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

    public LocalDate getDatainicio() {
        return datainicio;
    }

    public void setDatainicio(LocalDate datainicio) {
        this.datainicio = datainicio;
    }

    public LocalDate getDatatermino() {
        return datatermino;
    }

    public void setDatatermino(LocalDate datatermino) {
        this.datatermino = datatermino;
    }

    public LocalTime getTempoinicio() {
        return tempoinicio;
    }

    public void setTempoinicio(LocalTime tempoinicio) {
        this.tempoinicio = tempoinicio;
    }

    public LocalTime getTempotermino() {
        return tempotermino;
    }

    public void setTempotermino(LocalTime tempotermino) {
        this.tempotermino = tempotermino;
    }

    

}
