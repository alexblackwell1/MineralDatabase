
public class Range
{
    private double min;
    private double max;

    public Range()
    {
        min = 0;
        max = 0;
    }

    public Range(double d)
    {
        min = d;
        max = d;
    }

    public Range(double min, double max)
    {
        this.min = min;
        this.max = max;
    }
    
    public double getRange()
    {
        return max - min;
    }

    public double getMin() 
    {
        return min;
    }

    public double getMax()
    {
        return max;
    }

    public void setMin(double min)
    {
        this.min = min;
    }

    public void setMax(double max)
    {
        this.max = max;
    }

    public int compareTo(Range r2)
    {
        if (min < r2.getMin())
            return -1;
        else if (min == r2.getMin())
            return 0;
        else
            return 1;
    }
}
