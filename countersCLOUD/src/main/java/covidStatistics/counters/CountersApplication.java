package covidStatistics.counters;

import java.time.Duration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients()

//@EneableDiscoveryClient //Valido per Discovery CLient diversi da Eureka
public class CountersApplication {

	public static void main(String[] args) {
		SpringApplication.run(CountersApplication.class, args);
	}

	@Bean
	RestTemplate getRestTemplate() {
		return new RestTemplateBuilder().setReadTimeout(Duration.ofMinutes(1)).build();
	}

}
