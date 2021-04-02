package ac.facens.evento.acevento.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ac.facens.evento.acevento.entities.Event;

@Repository
public interface EventRepository extends JpaRepository <Event, Long>{


}