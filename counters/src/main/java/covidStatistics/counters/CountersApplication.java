package covidStatistics.counters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
// @EnableEurekaClient
@EnableScheduling
//@EneableDiscoveryClient Valido per Discovery CLient diversi da Eureka
public class CountersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountersApplication.class, args);
	}

}
