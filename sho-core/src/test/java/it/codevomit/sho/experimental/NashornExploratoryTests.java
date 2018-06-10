package it.codevomit.sho.experimental;

import javax.script.Bindings;
import javax.script.ScriptContext;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.script.SimpleScriptContext;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author merka
 */
@Slf4j
public class NashornExploratoryTests
{

    public NashornExploratoryTests()
    {
    }

    @Test
    public void testScriptEngine() throws ScriptException
    {
        ScriptEngine engine = (new ScriptEngineManager()).getEngineByName("nashorn");
        Object result = engine.eval("1 + 1 + 2 + 3 + 5");

        assertNotNull(result);
        assertTrue(result instanceof Number);
        assertEquals(12, ((Number) result).intValue());
    }

    public static final String SCRIPT_INTERACTION = "var tempObject = bean.getSimulatedObject();"
            + "tempObject.name = 'Gonfio Man';"
            + "tempObject.value = 88.6;"
            + "tempObject;";

    @Test
    public void testInteractionWithJavaObject() throws ScriptException
    {

        ScriptEngine engine = (new ScriptEngineManager()).getEngineByName("nashorn");

//        ScriptContext context = new SimpleScriptContext();
//        context.setBindings(engine.createBindings(), ScriptContext.ENGINE_SCOPE);
//        Bindings engineBindings = context.getBindings(ScriptContext.ENGINE_SCOPE);
        engine.put("bean", new SimulatedService());

        Object result = engine.eval(SCRIPT_INTERACTION);

        assertNotNull(result);
        log.info("Object from eval: {}", ToStringBuilder.reflectionToString(result));
        assertTrue(result instanceof TempBean);
        TempBean tempBean = (TempBean)result;
        assertEquals("Gonfio Man", tempBean.getName());
        assertEquals(88.6, tempBean.getValue(), 0.0001);
    }

    public static class TempBean
    {
        String name;
        Double value;

        public String getName()
        {
            return name;
        }

        public void setName(String name)
        {
            this.name = name;
        }

        public Double getValue()
        {
            return value;
        }

        public void setValue(Double value)
        {
            this.value = value;
        }

        public void DoNothing()
        {
            log.info("TEST");
        }
    }

    public static class SimulatedService
    {
        public SimulatedService()
        {
        }

        public TempBean getSimulatedObject()
        {

            return new TempBean();
        }
    }
}
