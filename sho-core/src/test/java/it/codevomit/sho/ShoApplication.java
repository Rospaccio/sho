package it.codevomit.sho;

import it.codevomit.sho.api.DummyService;
import it.codevomit.sho.demo.SimpleDummyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoApplication.class, args);
	}
        
        @Bean(name = "simpleDummyService")
        public DummyService dummyService(){
            return new SimpleDummyService();
        }
}
