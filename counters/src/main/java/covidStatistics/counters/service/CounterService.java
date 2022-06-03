package covidStatistics.counters.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import covidStatistics.counters.model.User;
import covidStatistics.counters.repository.UsersRepository;



@Service
public class CounterService {

    @Autowired
    private UsersRepository repo;

    public Integer getNmalati() {
        return repo.findByStatus(true).size();
    }

    public User setMalato(String id, String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date = LocalDateTime.parse(time, formatter);
        User u = new User(id, true, date);
        return repo.save(u);
    }
}
