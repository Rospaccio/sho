package it.codevomit.sho.demo;

import it.codevomit.sho.api.DummyService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author merka
 */
@Slf4j
public class SimpleDummyService implements DummyService
{

    public static final char[] CHARS = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h',
        'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
        'x', 'y', 'z'};

    @Override
    public String getRandomString()
    {
        return RandomStringUtils.random(32, CHARS);
    }

    @Override
    public void doSomeSideEffects()
    {
        log.info(System.lineSeparator());
        log.info("This log is just a placeholder for a simulation of a side "
                + "effect. Enjoy.");
        log.info(System.lineSeparator());
        log.info(System.lineSeparator());
    }

}
