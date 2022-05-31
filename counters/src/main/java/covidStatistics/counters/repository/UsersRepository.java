package covidStatistics.counters.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import covidStatistics.counters.model.User;

public interface UsersRepository extends JpaRepository<User, String> {

    List<User> findAll();

}
