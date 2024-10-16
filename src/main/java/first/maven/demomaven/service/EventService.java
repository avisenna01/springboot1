//package first.maven.demomaven.service;
//
//import first.maven.demomaven.model.Event;
//import first.maven.demomaven.event.EventNotFoundException;
//import first.maven.demomaven.repository.EventRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class EventService {
//    //    @GetMapping("/hello")
////    String home() {
////        return "Hello, Guest!";
////    }
////    @GetMapping("/test")
////    String test() {
////        return "Hello, test!";
////    }
//    private final EventRepository eventRepository;
//
//    public EventService(EventRepository eventRepository) {
//        this.eventRepository = eventRepository;
//    }
//
////    @GetMapping("")
//    public List<Event> findAll() {
//        return eventRepository.findAll();
//    }
//
//    // GET DATA BY ID (METHOD 1)
////    @GetMapping("/{id}")
////    public Event findById(@PathVariable Integer id) {
////        return eventRepository.findById(id);
////    }
//
////    @GetMapping("/{id}")
////    Event findById(@PathVariable Integer id) {
////        Optional<Event> event = eventRepository.findById(id);
////        if (event.isEmpty()) {
////            throw new ResponseStatusException(
////                    HttpStatus.NOT_FOUND, "Event not found xxxx"
////            );
//////            throw new EventNotFoundException();
////        }
////        return event.get();
////    }
//
//    // UPDATED EVENT SERVICE
//    public Event findById(Integer id) {
//        return eventRepository
//                .findById(id)
//                .orElseThrow(() -> new EventNotFoundException());
//    }
//
//
////    @GetMapping("/api/events/{id}")
////    Event findById(@PathVariable Integer id) {
////        Optional<Event> event = eventRepository.findById(id);
////        if(event.isEmpty()) {
////            throw new ResponseStatusException(
////                    HttpStatus.NOT_FOUND,"Event not found"
////            );
////        }
////        return event.get();
////    }
//
//    // .findByLocation is not working
////    @GetMapping("/api/events/{location}")
////    public Event findByLocation(@PathVariable Location location) {
////        return eventRepository.findByLocation(location);
////    }
//
//    //    // POST
////    @ResponseStatus(HttpStatus.CREATED)
////    @PostMapping("")
//    public Event create(Event event) {
////        eventRepository.create(event);
//        return eventRepository.save(event);
//    }
//    //
////    // PUT
////    @ResponseStatus(HttpStatus.NO_CONTENT)
////    @PutMapping("/{id}")
//    public void update(Event event, Integer id) {
//        if(!eventRepository.existsById(id)) {
//            throw new EventNotFoundException();
//        }
//        Event existingEvent = eventRepository
//                .findById(id).orElseThrow(() -> new EventNotFoundException());
//        Event updatedEvent = new Event(
//                id,
//                event.getTitle(),
//                event.getStartOn(),
//                event.getCompleteOn(),
//                event.getParticipant(),
//                event.getLocation(),
//                existingEvent.getVersion()
//        );
////        eventRepository.update(event, id);
//        eventRepository.save(updatedEvent);
//    }
//    //
////    // DELETE
////    @ResponseStatus(HttpStatus.NO_CONTENT)
////    @DeleteMapping("/{id}")
//    public void delete(Integer id) {
////        eventRepository.delete(id);
//        eventRepository.delete(eventRepository
//                .findById(id)
//                .orElseThrow(() -> new EventNotFoundException()));
//    }
//
////    @GetMapping("/location")
////    Optional<Event> findByLocation(@RequestParam String location) {
////        return eventRepository.findByLocation(location);
////    }
//
////    @GetMapping("/location")
////    List<Event> findByLocation(@RequestParam String location) {
//////        return eventRepository.findByLocation(location);
////        return eventRepository.findAllByLocation(location);
////    }
//
////    @GetMapping("/location")
//    public List<Event> findByLocationAndParticipant(
//            String location,
//            Integer participant) {
//        if(location != null && participant != null) {
//            return eventRepository.findAllByLocationAndParticipant(location, participant);
//        } else if(location != null) {
//            return eventRepository.findAllByLocation(location);
//        } else if(participant != null) {
//            return eventRepository.findAllByParticipant(participant);
//        } else {
//            return eventRepository.findAll();
//        }
//    }
//
//    // FIND WITH PATH
////    @GetMapping("/location/{location}")
//    public List<Event> findByLocation(String location) {
//        return eventRepository.findAllByLocation(location);
//    }
//}
