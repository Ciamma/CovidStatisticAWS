package covidStatistics.counters.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import covidStatistics.counters.repository.UsersRepository;

@Service
public class CounterService {

    @Autowired
    private UsersRepository repo;

    public Integer getNmalati() {
        repo.findAll();
        return 1;
    }
}
