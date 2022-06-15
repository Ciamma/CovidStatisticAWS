package covidStatistics.counters.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;
import covidStatistics.counters.model.User;

public interface UsersRepository extends CrudRepository<User, String> {

    List<User> findAll();

    Optional<User> findById(String id);

    List<User> findByStatus(boolean status);

    List<User> findByStatusAndTimestamp(boolean status, LocalDateTime timestamp);

    void deleteByStatus(Boolean status);

}
