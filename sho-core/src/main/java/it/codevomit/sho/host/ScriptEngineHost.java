package it.codevomit.sho.host;

/**
 *
 * @author merka
 */
public interface ScriptEngineHost
{
    public Object eval(String scriptText);
    // public <T> T evalAndGet(String script, Class<T> expectedType);
}
