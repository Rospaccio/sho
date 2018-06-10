package it.codevomit.sho.demo;

/**
 *
 * @author merka
 */
public class TempBean
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
        System.out.print("Nothing else to do for me!");
    }
}
