package first.maven.demomaven.participant;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Integer> {
    List<Participant> findAllByName(String name);
    List<Participant> findAllByEmail(String email);
}
