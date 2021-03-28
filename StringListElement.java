

public class StringListElement
{
    private String value;
    private Mineral mineral;
    
    public StringListElement()
    {
        value = "";
        mineral = new Mineral();
    }
    
    public StringListElement(String val, Mineral min)
    {
        value = val;
        mineral = min;
    }

    public String getValue() {return value;}
    public void setValue(String val) {value = val;}

    public Mineral getMineral() {return mineral;}
    public void setMineral(Mineral min) {mineral = min;}

    public int compareTo(String val)
    {
        return value.compareTo(val);
    }
}
