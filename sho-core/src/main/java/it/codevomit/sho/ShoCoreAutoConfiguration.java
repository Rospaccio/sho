package it.codevomit.sho;

import it.codevomit.sho.host.ScriptEngineHost;
import it.codevomit.sho.host.js.JavaScriptEngineHost;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author merka
 */
@Configuration
@Slf4j
public class ShoCoreAutoConfiguration
{
    @Bean(name = "scriptEngineHost")
    @Autowired
    @ConditionalOnProperty(name = "sho.host.type", havingValue = "javascript", matchIfMissing = true)
    public ScriptEngineHost scriptEngineHost(ApplicationContext context){
        return new JavaScriptEngineHost(context);
    }
}
