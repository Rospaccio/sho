package it.codevomit.sho.services;

import it.codevomit.sho.ShoCoreAutoConfiguration;
import it.codevomit.sho.services.rest.ScriptController;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author merka
 */
@Configuration
@ConditionalOnClass(ShoCoreAutoConfiguration.class)
@ComponentScan(basePackageClasses = ScriptController.class)
public class ShoServicesAutoConfiguration
{

}
