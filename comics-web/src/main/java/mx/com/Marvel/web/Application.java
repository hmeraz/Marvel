package mx.com.Marvel.web;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@ComponentScan("mx.com.Marvel")
@EnableJpaRepositories("mx.com.Marvel.persistence")
@EntityScan("mx.com.Marvel.model")
public class Application {

    static final Logger LOG = LogManager.getLogger(Application.class);

    public static void main(String[] args) {

        ApplicationContext applicationContext = SpringApplication.run(Application.class);

        for (String name : applicationContext.getBeanDefinitionNames()) {
            LOG.info(name);
        }
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }
    
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
