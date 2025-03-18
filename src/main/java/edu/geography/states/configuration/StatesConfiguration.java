package edu.geography.states.configuration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class StatesConfiguration {
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(3000);
        factory.setReadTimeout(3000);
        return new RestTemplate(factory);
    }

    /*
    //Commented this as it is now deprecrated

import org.springframework.http.client.ClientHttpRequestFactory;
import java.time.Duration;

    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        //HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
        return builder.setConnectTimeout(Duration.ofMillis(3000))
                    .setReadTimeout(Duration.ofMillis(3000))
                    .requestFactory(this::getClientHttpRequestFactory)
                    .build();
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory() {
        HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
        clientHttpRequestFactory.setConnectTimeout(3000);
        clientHttpRequestFactory.setReadTimeout(3000);
        return clientHttpRequestFactory;
    }
    */

    /*
    //import org.springframework.web.reactive.function.client.WebClient;
    @Bean
    public WebClient.Builder getWebClientBuilder() {
        return WebClient.builder();
    }
    */

    /*
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
    */
}
