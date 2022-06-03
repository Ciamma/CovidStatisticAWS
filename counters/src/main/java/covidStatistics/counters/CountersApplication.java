package covidStatistics.counters;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//@EneableDiscoveryClient Valido per Discovery CLient diversi da Eureka
public class CountersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountersApplication.class, args);
	}

}
