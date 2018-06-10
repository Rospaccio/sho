package it.codevomit.sho.exception;

/**
 *
 * @author merka
 */
public class ShoException extends RuntimeException
{
    public ShoException()
    {
    }

    public ShoException(String message)
    {
        super(message);
    }

    public ShoException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ShoException(Throwable cause)
    {
        super(cause);
    }
    
}
