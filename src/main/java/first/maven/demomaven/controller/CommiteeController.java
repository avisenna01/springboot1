//package first.maven.demomaven.controller;
//
//import first.maven.demomaven.model.Commitee;
//import first.maven.demomaven.model.Participant;
//import first.maven.demomaven.service.CommiteeService;
//import first.maven.demomaven.service.ParticipantService;
//import jakarta.validation.Valid;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/commitees")
//public class CommiteeController {
//    private final CommiteeService commiteeService;
//
//    public CommiteeController(CommiteeService commiteeService) {
//        this.commiteeService = commiteeService;
//    }
//
//    @GetMapping("")
//    public List<Commitee> findAll() {
//        return commiteeService.findAll();
//    }
//
//    @GetMapping("/name")
//    public List<Commitee> findByName( @RequestParam(required = false) String name) {
//        return commiteeService.findByName(name);
//    }
//
//    @GetMapping("/email")
//    public List<Commitee> findByEmail(String email) {
//        return commiteeService.findByEmail(email);
//    }
//
//    @ResponseStatus(HttpStatus.CREATED)
//    @PostMapping("")
//    public Commitee create(@Valid @RequestBody Commitee commitee) {
//        return commiteeService.create(commitee);
//    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Integer id) {
//        commiteeService.delete(id);
//    }
//
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    @PutMapping("/{id}")
//    public void update(@Valid @RequestBody Commitee commitee,
//                       @PathVariable Integer id) {
//        commiteeService.update(commitee, id);
//    }
//}
