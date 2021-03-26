public class Mineral
{
    private String name;
    private String crystalSystem;


}

public class Range<T>
{
    private bool range;
    private <T> data;

    public Range(bool range, <T> data)
    {
        this.range = range;
        this.data = data;
    }
}