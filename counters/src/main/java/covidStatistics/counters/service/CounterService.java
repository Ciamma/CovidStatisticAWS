package covidStatistics.counters.service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import covidStatistics.counters.model.Counter;
import covidStatistics.counters.model.User;
import covidStatistics.counters.repository.UsersRepository;
import covidStatistics.counters.repository.CounterRepository;



@Service
public class CounterService {

    @Autowired
    private UsersRepository Urepo;

    @Autowired
    private CounterRepository Crepo;

    public Integer getNmalati() {
        return Urepo.findByStatus(true).size();
    }

    public Integer getNguariti() {
        return Urepo.findByStatus(false).size();
    }

    public void deleteGuariti(){
        Urepo.deleteByStatus(false);
    }

    public User setMalato(String id, String time) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date = LocalDateTime.parse(time, formatter);
        User u = new User(id, true, date);
        return Urepo.save(u);
    }

    public User setGuarito(String id, String time){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date = LocalDateTime.parse(time, formatter);
        User u = new User(id, false, date);
        return Urepo.save(u);
    }

    public void CounterDaily(){
        LocalDate today = LocalDate.now();
        Counter c = new Counter(today, getNmalati(), getNguariti());
        Crepo.save(c);
        deleteGuariti();
    }
}
