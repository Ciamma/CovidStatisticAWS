package covidStatistics.counters.model;

import java.time.LocalDateTime;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;


@Entity
@Table(name = "nome tabella")
public class User {

    @Id
    private String id;

    @NotNull
    private boolean status;

    @PastOrPresent
    @NotNull
    private LocalDateTime timestamp;

    public User(String id, boolean status, LocalDateTime timestamp) {
        this.id = id;
        this.status = status;
        this.timestamp = timestamp;
    }

    public String getId() {
        return id;
    }

    public void setStatus(boolean s) {
        this.status = s;
    }

    public boolean getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
