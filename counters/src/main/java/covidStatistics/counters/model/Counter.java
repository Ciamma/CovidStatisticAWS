package covidStatistics.counters.model;

import java.time.LocalDate;
import javax.persistence.Id;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Table(name = "counter")
public class Counter {

    @Id
    private LocalDate day;

    @NotNull
    @PositiveOrZero
    Integer nMalati;

    @NotNull
    @PositiveOrZero
    Integer nGuariti;

    public Counter(LocalDate day, Integer nMalati, Integer nGuariti) {
        this.day = day;
        this.nMalati = nMalati;
        this.nGuariti = nGuariti;
    }

    public LocalDate getDay() {
        return day;
    }

    public void setNMalati(Integer n) {
        this.nMalati = n;
    }

    public Integer getNMalati() {
        return nMalati;
    }

    public void setNGuariti(Integer n) {
        this.nGuariti = n;
    }

    public Integer getNGuariti() {
        return nGuariti;
    }
}
