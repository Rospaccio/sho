package it.codevomit.sho.demo;

import it.codevomit.sho.api.DummyService;
import org.apache.commons.lang3.RandomStringUtils;

/**
 *
 * @author merka
 */
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
    
    
}
