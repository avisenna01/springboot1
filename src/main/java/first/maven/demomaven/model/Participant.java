package first.maven.demomaven.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDateTime;

@Entity
@Table(name = "participant")
public class Participant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotNull
    private Integer eventId;
    private String name;
    @NotEmpty
    private String email;

    public Participant() {}
    public Participant(
            Integer id,
            Integer eventId,
            String name,
            String email
    ) {
        this.id = id;
        this.eventId = eventId;
        this.name = name;
        this.email = email;
    }
    // getter and setter
    public Integer getId() { return id;}
    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getEventId() { return eventId;}
    public void setEventId() {
        this.eventId = eventId;
    }
    public String getName() { return name;}
    public void setName() {
        this.name = name;
    }
    public String getEmail() { return email;}
    public void setEmail() {
        this.email = email;
    }
}
