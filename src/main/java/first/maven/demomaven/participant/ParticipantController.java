package first.maven.demomaven.participant;

import first.maven.demomaven.event.Event;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {
    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @GetMapping("")
    public List<Participant> findAll() {
        return participantService.findAll();
    }

    @GetMapping("/name")
    public List<Participant> findByName( @RequestParam(required = false) String name) {
        return participantService.findByName(name);
    }

    @GetMapping("/email")
    public List<Participant> findByEmail(String email) {
        return participantService.findByEmail(email);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public Participant create(@Valid @RequestBody Participant participant) {
        return participantService.create(participant);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        participantService.delete(id);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@Valid @RequestBody Participant participant,
                       @PathVariable Integer id) {
        participantService.update(participant, id);
    }

}
