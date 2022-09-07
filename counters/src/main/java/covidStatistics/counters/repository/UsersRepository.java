package covidStatistics.counters.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import covidStatistics.counters.model.User;

@Repository
public interface UsersRepository extends CrudRepository<User, String> {

    List<User> findAll();

    Optional<User> findById(String id);

    List<User> findByStatus(boolean status);

    @Modifying
    @Query(value="select * from UTENTI where status=:status or timestamp<:timestamp", nativeQuery=true)
    List<String> findByStatusAndTimestampLess(@Param("status") boolean status,
            @Param("timestamp") LocalDateTime timestamp);

    @Modifying
    @Query(value="delete from UTENTI f where f.status=:status or f.timestamp<:timestamp", nativeQuery=true)
    List<String> deleteSchedulata(@Param("status") boolean status,
            @Param("timestamp") LocalDateTime timestamp);
}
