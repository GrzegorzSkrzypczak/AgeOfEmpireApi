package pl.grzegorz.ageofempire.empires2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AppComponentProvider {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
