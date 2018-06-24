package it.codevomit.sho.web;

import it.codevomit.sho.api.DummyService;
import it.codevomit.sho.demo.SimpleDummyService;
import it.codevomit.sho.web.home.HomeController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author merka
 */
@Configuration
@ComponentScan(basePackageClasses = {ShoWebSecurityConfig.class, HomeController.class})
public class ShoWebAutoConfiguration
{
    @Bean
    public DummyService dummyService()
    {
        return new SimpleDummyService();
    }
}
