package it.codevomit.sho.services.rest;

import it.codevomit.sho.ShoCoreAutoConfiguration;
import it.codevomit.sho.host.ScriptEngineHost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author merka
 */
@RestController
@ConditionalOnClass(ShoCoreAutoConfiguration.class)
@RequestMapping("/sho")
public class ScriptController
{
    ScriptEngineHost scriptEngineHost;

    @Autowired
    public ScriptController(ScriptEngineHost host)
    {
        this.scriptEngineHost = host;
    }
    
    @GetMapping("/is-alive")
    public Boolean isAlive(){
        
        return true;
    }

    @PostMapping(path = "/eval")
    public ResponseEntity<Object> eval(
        @RequestBody String scriptText){
        
        Object evaluationResult = scriptEngineHost.eval(scriptText);
        
        return ResponseEntity.ok().body(evaluationResult);
    }

}
