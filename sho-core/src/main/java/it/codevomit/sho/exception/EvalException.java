package it.codevomit.sho.exception;

/**
 *
 * @author merka
 */
public class EvalException extends ShoException
{
    public EvalException()
    {
    }

    public EvalException(String message)
    {
        super(message);
    }

    public EvalException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public EvalException(Throwable cause)
    {
        super(cause);
    }
    
}
