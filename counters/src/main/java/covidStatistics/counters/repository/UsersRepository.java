package covidStatistics.counters.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import covidStatistics.counters.model.User;

public interface UsersRepository implements JpaRepository<User, String> {

    List<User> findAll();

    Optional<User> findById(String id);

    List<User> findByStatus(boolean status);

    List<User> findByStatusAndDate(boolean status, LocalDateTime date);

}
