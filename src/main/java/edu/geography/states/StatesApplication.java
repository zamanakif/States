package edu.geography.states;

import org.springframework.boot.SpringApplication;
//import org.springframework.cloud.client.EnableCircuitBreaker;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "edu.geography.states")
//@EnableCircuitBreaker
//@EnableEurekaClient
//@EnableDiscoveryClient
public class StatesApplication {

	public static void main(String[] args) {
		SpringApplication.run(StatesApplication.class, args);
	}

}
