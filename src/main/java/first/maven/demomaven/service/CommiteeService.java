//package first.maven.demomaven.service;
//
//import first.maven.demomaven.event.EventNotFoundException;
//import first.maven.demomaven.model.Commitee;
//import first.maven.demomaven.model.Participant;
//import first.maven.demomaven.repository.CommiteeRepository;
//import first.maven.demomaven.repository.ParticipantRepository;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class CommiteeService {
//    private final CommiteeRepository commiteeRepository;
//    public CommiteeService(CommiteeRepository commiteeRepository) {
//        this.commiteeRepository = commiteeRepository;
//    }
//
//    public List<Commitee> findAll() {
//        return commiteeRepository.findAll();
//    }
//
//    public List<Commitee> findByName(String name) {
//        return commiteeRepository.findAllByName(name);
//    }
//
//    public List<Commitee> findByEmail(String email) {
//        return commiteeRepository.findAllByEmail(email);
//    }
//
//    // POST
//    public Commitee create(Commitee commitee) {
//        return commiteeRepository.save(commitee);
//    }
//
//    // PUT
//    public void update(Commitee commitee, Integer id) {
//        if(!commiteeRepository.existsById(id)) {
//            throw new EventNotFoundException();
//        }
//        Commitee updatedCommitee = new Commitee(
//                id,
//                commitee.getEventId(),
//                commitee.getName(),
//                commitee.getEmail()
//        );
//        commiteeRepository.save(updatedCommitee);
//    }
//
//    // DELETE
//    public void delete(Integer id) {
//        commiteeRepository.delete(commiteeRepository
//                .findById(id)
//                .orElseThrow(() -> new EventNotFoundException()));
//    }
//}
