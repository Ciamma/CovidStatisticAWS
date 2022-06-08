package covidStatistics.counters.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import covidStatistics.counters.model.Counter;

public interface CounterRepository extends JpaRepository<Counter, LocalDate> {
 
    List<Counter> findAll();
}