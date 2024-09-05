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
        eventRepository.create(event);
    }
//
//    // PUT
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    void update(@RequestBody Event event, @PathVariable Integer id) {
        eventRepository.update(event, id);
    }
//
//    // DELETE
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    void delete(@PathVariable Integer id) {
        eventRepository.delete(id);
    }
}
