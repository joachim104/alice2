public class Word
{
    private String key;
    private int value;

    public String getKey()
    {
        return key;
    }

    public void setKey(String key)
    {
        this.key = key;
    }

    public int getValue()
    {
        return value;
    }

    public void setValue(int value)
    {
        this.value = value;
    }

    @Override
    public String toString()
    {
        return key + " " + value;
    }

    public Word(String key, int value)
    {
        this.key = key;
        this.value = value;
    }

    public Word()
    {

    }
}
