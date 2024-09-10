package first.maven.demomaven.service;

import first.maven.demomaven.event.EventNotFoundException;
import first.maven.demomaven.model.Participant;
import first.maven.demomaven.repository.ParticipantRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;
    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    public List<Participant> findAll() {
        return participantRepository.findAll();
    }

    public List<Participant> findByName(String name) {
        return participantRepository.findAllByName(name);
    }

    public List<Participant> findByEmail(String email) {
        return participantRepository.findAllByEmail(email);
    }

    // POST
    public Participant create(Participant participant) {
        return participantRepository.save(participant);
    }

    // PUT
    public void update(Participant participant, Integer id) {
        if(!participantRepository.existsById(id)) {
            throw new EventNotFoundException();
        }
        Participant updatedParticipant = new Participant(
                id,
                participant.getEventId(),
                participant.getName(),
                participant.getEmail()
        );
        participantRepository.save(updatedParticipant);
    }

    // DELETE
    public void delete(Integer id) {
        participantRepository.delete(participantRepository
                .findById(id)
                .orElseThrow(() -> new EventNotFoundException()));
    }

}
