package it.codevomit.sho.experimental;

import it.codevomit.sho.api.DummyService;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author merka
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class NashornInSpringBootTests
{
    @Autowired
    DummyService dummy;

    @Autowired
    ApplicationContext appContext;

    public NashornInSpringBootTests()
    {
    }

    @Test
    public void testInvokeSpringService() throws ScriptException
    {
        assertNotNull(dummy);

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.put("dummy", dummy);

        String result = (String) engine.eval("dummy.getRandomString();");
        log.info("Random String from Javascript: {}", result);

        assertTrue(StringUtils.isNotBlank(result));
    }
    
    public static final String SCRIPT_BOOT = "var service = applicationContext.getBean('simpleDummyService');"
            + "var randomString = service.getRandomString();"
            + "print('Inside the Javascript: ', randomString);"
            + "randomString;";

    @Test
    public void testGetSpringBean() throws ScriptException
    {

        ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
        engine.put("applicationContext", appContext);
        
        assertNotNull((appContext.getBean("simpleDummyService")));

        String result = (String)engine.eval(SCRIPT_BOOT);
        log.info("Inside Java: {}", result);
        
        assertTrue(StringUtils.isNotBlank(result));
    }
}
