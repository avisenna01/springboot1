package first.maven.demomaven.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Repository // EventRepository -> JdbcClientEventRepository
public class JdbcClientEventRepository {
    private static final Logger log = LoggerFactory.getLogger(JdbcClientEventRepository.class);
    private final JdbcClient jdbcClient;
    public JdbcClientEventRepository(JdbcClient jdbcClient) {
        this.jdbcClient = jdbcClient;
    }
//    public List<Event> findAll() {
//        return jdbcClient.sql("select * from event").query(Event.class).list();
//    }
//    public Optional<Event> findById(Integer id) {
//        return jdbcClient.sql("select id, title, start_on, complete_on,participant,location" +
//                " from Event where id = :id").param("id",id).query(Event.class).optional();
//    }
    public void create(Event event) {
        var updated = jdbcClient.sql("insert into Event(id,title,start_on,complete_on,participant,location) " +
                "values (?,?,?,?,?,?)")
                .params(List.of(
                        event.getId(),
                        event.getTitle(),
                        event.getStartOn(),
                        event.getCompleteOn(),
                        event.getParticipant(),
                        event.getLocation()))
                .update();

        Assert.state(updated == 1, "Failed to create event " + event.getTitle());
    }
//    public void update(Event event, Integer id) {
//        var updated = jdbcClient.sql("UPDATE event SET title = ?, start_on = ?, complete_on = ?, " +
//                "participant = ?, location = ? WHERE id = ?")
//                .params(List.of(
//                        event.title(),
//                        event.startOn(),
//                        event.completeOn(),
//                        event.participant(),
//                        event.location().toString(),id))
//                .update();
//        Assert.state(updated == 1, "Failed to update event " + event.title());
//    }
//
//    public void delete(Integer id) {
//        var updated = jdbcClient.sql("DELETE FROM event where id = :id")
//                .param("id",id)
//                .update();
//        Assert.state(updated == 1, "Failed to delete event " + id);
//    }

//    public Optional<Event> findByLocation(String location) {
//        return jdbcClient.sql("select id,title,start_on,complete_on,participant,location " +
//                "from Event where location = :location")
//                .param("location",location)
//                .query(Event.class)
//                .optional();
//    }

//    public List<Event> findByLocation(String location) {
//        return jdbcClient.sql("select * from event where location = :location")
//                .param("location",location)
//                .query(Event.class)
//                .list();
//    }

    public void saveAll(List<Event> events) {
        events.forEach(this::create);
    }

    public int count() {
        return jdbcClient.sql("select * from event")
                .query()
                .listOfRows()
                .size();
    }
}

//@Repository
//public class EventRepository {
//    List<Event> events = new ArrayList<>();
//
//    List<Event> findAll() {
//        return events;
//    }
//
////    Event findById(Integer id) {
////         return events.stream().filter(
////                 run -> run.id() == id).findFirst().orElse(null);
////    }
//
//    // FIND BY ID (METHOD 1)
////    public Event findById(Integer id) {
////        return events.stream().filter(event -> event.getId().equals(id)).findFirst().orElse(null);
////    }
//
//    // FIND BY ID (METHOD 2)
//    Optional<Event> findById(Integer id) {
//        return events.stream().filter(
//                event -> Objects.equals(event.id(),id)
//        ).findFirst();
//    }
//
//    // NOT WORKING
////    Event findByLocation(Location location) {
////        return events.stream().filter(event -> event.getLocation().
////                equals(location)).findFirst().orElse(null);
////    }
//
//    // INSERT/CREATE NEW DATA
//    void create(Event event) {
//        events.add(event);
//    }
//
//    // UPDATE/MODIFY EXISTING DATA
//    void update(Event event, Integer id) {
//        Optional<Event> existingEvent = findById(id);
//        existingEvent.ifPresent(value -> events.set(events.indexOf(value), event));
//    }
//
//    // DELETE/REMOVE EXISTING DATA
//    void delete(Integer id) {
//        events.removeIf(event -> event.id().equals(id));
//    }
//
//    @PostConstruct
//    private void init() {
//        events.add(new Event(
//                1,
//                "Konser A",
//                LocalDateTime.now(),
//                LocalDateTime.now().plusHours(5),
//                1000,
//                Location.BEKASI));
//        events.add(new Event(
//                2,
//                "Konser B",
//                LocalDateTime.now(),
//                LocalDateTime.now().plusHours(6),
//                1500,
//                Location.JAKARTA)
//        );
//        events.add(new Event(
//                3,
//                "Konser C",
//                LocalDateTime.now(),
//                LocalDateTime.now().plusHours(7),
//                2000,
//                Location.BOGOR
//        ));
//    }
//}
