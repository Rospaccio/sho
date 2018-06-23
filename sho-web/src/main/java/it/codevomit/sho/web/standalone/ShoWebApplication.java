package it.codevomit.sho.web.standalone;

import it.codevomit.sho.api.DummyService;
import it.codevomit.sho.demo.SimpleDummyService;
import it.codevomit.sho.web.home.HomeController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackageClasses = HomeController.class)
public class ShoWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShoWebApplication.class, args);
	}
        
        @Bean
        public DummyService dummyService(){
            return new SimpleDummyService();
        }
}
