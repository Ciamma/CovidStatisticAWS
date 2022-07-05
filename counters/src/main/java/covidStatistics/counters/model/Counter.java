package covidStatistics.counters.model;

import java.time.LocalDate;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "counters")
public class Counter {

    @Id
    private LocalDate day;

    @NotNull
    @PositiveOrZero
    Integer malati;

    @NotNull
    @PositiveOrZero
    Integer guariti;

    public Counter() {}

    public Counter(LocalDate day, Integer nMalati, Integer nGuariti) {
        this.day = day;
        this.malati = nMalati;
        this.guariti = nGuariti;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setNMalati(Integer n) {
        this.malati = n;
    }

    public Integer getNMalati() {
        return malati;
    }

    public void setNGuariti(Integer n) {
        this.guariti = n;
    }

    public Integer getNGuariti() {
        return guariti;
    }
}
