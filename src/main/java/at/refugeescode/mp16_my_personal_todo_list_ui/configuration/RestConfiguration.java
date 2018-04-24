package at.refugeescode.mp16_my_personal_todo_list_ui.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

    @Bean
    RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
