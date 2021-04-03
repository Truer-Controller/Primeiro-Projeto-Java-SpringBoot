package ac.facens.evento.acevento.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ac.facens.evento.acevento.entities.Event;

@Repository
public interface EventRepository extends JpaRepository <Event, Long>{

    @Query("SELECT c FROM Event c")
    public Page <Event> find(Pageable pageRequest);


}