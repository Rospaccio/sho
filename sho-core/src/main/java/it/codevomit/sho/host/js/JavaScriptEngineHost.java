package it.codevomit.sho.host.js;

import it.codevomit.sho.exception.EvalException;
import it.codevomit.sho.host.ScriptEngineHost;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import org.apache.commons.lang3.NotImplementedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 *
 * @author merka
 */
public class JavaScriptEngineHost implements ScriptEngineHost
{
    public static final String SCRIPT_ENGINE_NAME = "nashorn";

    ApplicationContext applicationContext;

    @Autowired
    public JavaScriptEngineHost(ApplicationContext context)
    {
        this.applicationContext = context;
    }

    @Override
    public Object eval(String scriptText)
    {
        try {
            ScriptEngine engine = new ScriptEngineManager().getEngineByName(SCRIPT_ENGINE_NAME);
            engine.put("applicationContext", applicationContext);

            return engine.eval(scriptText);
        }
        catch (Exception e) {
            throw new EvalException(e);
        }
    }

}
