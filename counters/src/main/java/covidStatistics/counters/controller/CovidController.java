package covidStatistics.counters.controller;

import java.net.ConnectException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.server.ResponseStatusException;
import covidStatistics.counters.model.User;
import covidStatistics.counters.service.CounterService;
import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("covidcounters")
@EnableScheduling
public class CovidController {

    // Error Handling
    @ExceptionHandler(ConnectException.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    void connectHandle(ConnectException exc) {}

    @ExceptionHandler(HttpClientErrorException.NotFound.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    void notFoundHandle(HttpClientErrorException.NotFound exc) {}

    @ExceptionHandler(HttpClientErrorException.BadRequest.class)
    @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    void badRequestHandle(HttpClientErrorException.BadRequest exc) {}

    @ExceptionHandler(HttpServerErrorException.ServiceUnavailable.class)
    @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
    void serviceUnavaliableHandle(HttpServerErrorException.ServiceUnavailable exc) {}

    @ExceptionHandler(ResourceAccessException.class)
    @ResponseStatus(value = HttpStatus.GATEWAY_TIMEOUT)
    void timeoutHandle(ResourceAccessException exc) {}

    @Autowired
    private CounterService service;

    @GetMapping("/nMalati")
    public Integer getNmalati() {
        return service.getNmalati();
    }

    @GetMapping("/nGuariti")
    public Integer getNguariti() {
        return service.getNguariti();
    }

    @PostMapping("/malato/{id}")
    public User setMalato(@PathVariable String id) {
        return service.setMalato(id);
    }

    @PostMapping("/guarito/{id}")
    public User setGuarito(@PathVariable String id) {
        return service.setGuarito(id);
    }

    // @Scheduled(initialDelay = 64800000, fixedRate = 86400000) // il primo delay è di 18 ore, i
    // prosimi sono di 24 ore.
    @Scheduled(initialDelay = 20, fixedRate = 86400000)
    public void CounterDaily() {
        service.CounterDaily();
    }
}