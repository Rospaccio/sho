package it.codevomit.sho.host.js;

import it.codevomit.sho.demo.SimpleDummyService;
import it.codevomit.sho.demo.TempBean;
import it.codevomit.sho.exception.EvalException;
import it.codevomit.sho.support.MockShoApplicationContext;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author merka
 */
public class JavaScriptEngineHostTest
{
    JavaScriptEngineHost host;
    MockShoApplicationContext appContext; 
    
    public static final String SIMPLE_SCRIPT = "1 + 2 + 3";
    public static final String INTEROP_SCRIPT = "var service = applicationContext.getBean('testBean');"
            + "var data = service.getRandomString();"
            + "var TempType = Java.type('it.codevomit.sho.demo.TempBean');"
            + "var temp = new TempType();"
            + "temp.name = data;"
            + "temp;";
    public static final String WRONG_SCRIPT = "return 13.13";
    public static final String WRONG_INTEROP_SCRIPT = "var service = applicationContext.getBean('IdoNOTexist');"
            + "var data = service.getRandomString();";
    
    public JavaScriptEngineHostTest()
    {
        appContext = new MockShoApplicationContext();
        appContext.addBean("testBean", new SimpleDummyService());
        host = new JavaScriptEngineHost(appContext);
    }

    @Test
    public void testSimpleScript()
    {
        assertNotNull(host.applicationContext);
        
        Integer result = (Integer)host.eval(SIMPLE_SCRIPT);
        
        assertEquals(6, result.intValue());
    }
    
    @Test
    public void testInteropScript(){
        TempBean result = (TempBean)host.eval(INTEROP_SCRIPT);
        
        assertTrue(StringUtils.isNotBlank(result.getName()));
    }
 
    @Test(expected = EvalException.class)
    public void testWrongScript(){
        host.eval(WRONG_SCRIPT);
    }
    
    @Test(expected = EvalException.class)
    public void testWrongInteropScript(){
        host.eval(WRONG_INTEROP_SCRIPT);
    }
}
