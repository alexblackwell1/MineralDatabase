
public class StringList
{
    private String[] list;
    private int key;
    private String keyedString;

    /*
        Default Getter
        Sets empty [], key 0, "" keyed
    */
    public StringList()
    {
        list = new String[0];
        key = 0;
        keyedString = "";
    }

    /*
        Requests lister entered
    */
    public StringList(String[] list)
    {
        this.list = list;
        key = 0;
        keyedString = "";
    }

    /*
        Requests list and key number
    */
    public StringList(String[] list, int key)
    {
        this.list = list;
        this.key = key;
        keyedString = "";
    }

    //Setters and Getters
    public String[] getList()
    {
        return list;
    }

    public String getAt(int i)
    {
        return list[i];
    }

    public void setList(String[] list)
    {
        this.list = list;
    }
    
    public int getStringListKey()
    {
        return key;
    }

    public void setStringListKey(int key)
    {
        this.key = key;
    }

    public String getKeyedString()
    {
        return keyedString;
    }

    public void setKeyedString(String keyedString)
    {
        this.keyedString=keyedString;
    }

    public int getLength()
    {
        return list.length;
    }

    public int compareTo(StringList list2)
    {
        String ks2 = list2.getKeyedString();
        return keyedString.compareTo(ks2);
    }

    // toString method
    public String toString()
    {
        String print = "";

        for(int i = 0; i < list.length; i++)
        {
            if (i == list.length - 1)
            {
                print += list[i];
            }
            else
            {
                print += list[i] + ", ";
            }
        }
        return print;
    }
}