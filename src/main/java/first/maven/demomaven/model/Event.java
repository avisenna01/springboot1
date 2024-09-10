package first.maven.demomaven.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Positive;
import org.springframework.data.annotation.Version;

import java.time.LocalDateTime;
@Entity
@Table(name = "event")
public class Event{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer id;
        @NotEmpty
        private String title;
        private LocalDateTime startOn;
        private LocalDateTime completeOn;
        @Positive
        private Integer participant;
        private String location;
        @Version
        private Integer version;
        public Event() {}
        public Event(
                Integer id,
                String title,
                LocalDateTime startOn,
                LocalDateTime completeOn,
                Integer participant,
                String location,
                Integer version
        ) {
            if(!completeOn.isAfter(startOn)) {
                throw new IllegalArgumentException(
                        "Complete must be after start"
                );
            }
            this.id = id;
            this.title = title;
            this.startOn = startOn;
            this.completeOn = completeOn;
            this.participant = participant;
            this.location = location;
            this.version = version;

        }

        // Getters and Setters
    public Integer getId() {
        return id;
    }
    public Integer getParticipant() {
        return participant;
    }
    public Integer getVersion() {
        return version;
    }
    public LocalDateTime getCompleteOn() {
        return completeOn;
    }
    public LocalDateTime getStartOn() {
        return startOn;
    }
    public String getLocation() {
        return location;
    }
    public String getTitle() {
        return title;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public void setParticipant(Integer participant) {
        this.participant = participant;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public void setCompleteOn(LocalDateTime completeOn) {
        this.completeOn = completeOn;
    }

    public void setStartOn(LocalDateTime startOn) {
        this.startOn = startOn;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}

//public record Event(
//    @Id Integer id,
//    @NotEmpty String title,
//    LocalDateTime startOn,
//    LocalDateTime completeOn,
//    @Positive Integer participant,
//    Location location,
//    @Version Integer version
//){
////    public Integer getId() {
////        return id;
////    }
////    public Location getLocation() {
////        return location;
////    }
//    public Event {
//        if(!completeOn.isAfter(startOn)) {
//            throw new IllegalArgumentException(
//                    "Complete must be after start"
//            );
//        }
//    }
//}
