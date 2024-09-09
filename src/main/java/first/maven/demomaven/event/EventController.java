package first.maven.demomaven.event;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/events")
public class EventController {
//    @GetMapping("/hello")
//    String home() {
//        return "Hello, Guest!";
//    }
//    @GetMapping("/test")
//    String test() {
//        return "Hello, test!";
//    }
    private final EventRepository eventRepository;

    public EventController(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @GetMapping("")
    public List<Event> findAll() {

        return eventRepository.findAll();
    }

    // GET DATA BY ID (METHOD 1)
//    @GetMapping("/{id}")
//    public Event findById(@PathVariable Integer id) {
//        return eventRepository.findById(id);
//    }

    @GetMapping("/{id}")
    Event findById(@PathVariable Integer id) {
        Optional<Event> event = eventRepository.findById(id);
        if (event.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Event not found xxxx"
            );
//            throw new EventNotFoundException();
        }
        return event.get();
    }


//    @GetMapping("/api/events/{id}")
//    Event findById(@PathVariable Integer id) {
//        Optional<Event> event = eventRepository.findById(id);
//        if(event.isEmpty()) {
//            throw new ResponseStatusException(
//                    HttpStatus.NOT_FOUND,"Event not found"
//            );
//        }
//        return event.get();
//    }

    // .findByLocation is not working
//    @GetMapping("/api/events/{location}")
//    public Event findByLocation(@PathVariable Location location) {
//        return eventRepository.findByLocation(location);
//    }

//    // POST
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    void create(@Valid @RequestBody Event event) {
//        eventRepository.create(event);
        eventRepository.save(event);
    }
//
//    // PUT
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@Valid @RequestBody Event event, @PathVariable Integer id) {
        if(!eventRepository.existsById(id)) {
            throw new EventNotFoundException();
        }
        Event existingEvent = eventRepository
                .findById(id).orElseThrow(EventNotFoundException::new);
        Event updatedEvent = new Event(
                id,
                event.title(),
                event.startOn(),
                event.completeOn(),
                event.participant(),
                event.location(),
                existingEvent.version()
        );
//        eventRepository.update(event, id);
        eventRepository.save(updatedEvent);
    }
//
//    // DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
//        eventRepository.delete(id);
        eventRepository.delete(eventRepository.findById(id).get());
    }

//    @GetMapping("/location")
//    Optional<Event> findByLocation(@RequestParam String location) {
//        return eventRepository.findByLocation(location);
//    }

//    @GetMapping("/location")
//    List<Event> findByLocation(@RequestParam String location) {
////        return eventRepository.findByLocation(location);
//        return eventRepository.findAllByLocation(location);
//    }

    @GetMapping("/location")
    List<Event> findByLocationAndParticipant(
            @RequestParam(required = false) String location,
            @RequestParam(required = false) Integer participant) {
        if(location != null && participant != null) {
            return eventRepository.findAllByLocationAndParticipant(location, participant);
        } else if(location != null) {
            return eventRepository.findAllByLocation(location);
        } else if(participant != null) {
            return eventRepository.findAllByParticipant(participant);
        } else {
            return eventRepository.findAll();
        }
    }

    // FIND WITH PATH
//    @GetMapping("/location/{location}")
//    List<Event> findByLocation(@PathVariable String location) {
//        return eventRepository.findAllByLocation(location);
//    }
}
