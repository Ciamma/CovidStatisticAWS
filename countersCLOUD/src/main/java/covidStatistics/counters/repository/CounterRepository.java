package covidStatistics.counters.repository;

import java.time.LocalDate;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import covidStatistics.counters.model.Counter;

@Repository
public interface CounterRepository extends CrudRepository<Counter, LocalDate> {
 
    List<Counter> findAll();
}