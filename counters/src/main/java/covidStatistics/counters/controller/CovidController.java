package covidStatistics.counters.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import covidStatistics.counters.service.CounterService;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("api/covidcounters")
public class CovidController {

    @Autowired
    private CounterService service;

    @GetMapping("/nMalati")
    public Integer getNmalati() {
        return service.getNmalati();
    }
}
