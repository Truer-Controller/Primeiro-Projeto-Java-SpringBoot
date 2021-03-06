package ac.facens.evento.acevento.repositories;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ac.facens.evento.acevento.entities.Event;

@Repository
public interface EventRepository extends JpaRepository <Event, Long>{

    @Query("SELECT e FROM Event e" + 
    " WHERE " +
    "(LOWER(e.name)            LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
    "(LOWER(e.description)     LIKE LOWER(CONCAT('%', :description, '%'))) AND " +
    "(LOWER(e.place)           LIKE LOWER(CONCAT('%', :place, '%')))AND " +
    "e.datainicio >= :datainicio AND " +
    "e.tempotermino >= :tempoinicio"

    )

    public Page <Event> find(Pageable pageRequest, String name, String description, String place, LocalDate datainicio, LocalTime tempoinicio);


}