package first.maven.demomaven.event;

import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface EventRepository extends ListCrudRepository<Event, Integer> {

    List<Event> findAllByLocation(String location);

    List<Event> findAllByLocationAndParticipant(String location, Integer participant);

    List<Event> findAllByParticipant(Integer participant);
}
