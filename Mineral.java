import java.util.ArrayList;
import java.util.List;

public class Mineral
{
    private String name;            // 0
    private String crystalSystem;   // 1
    private Range hardness;         // 2
    private StringList luster;      // 3
    private StringList color;       // 4
    private Integer cleavage;       // 5

    private String keyedColor;

    private ArrayList<Object> mineral = new ArrayList<Object>();

    private int compKey;
    private int colorKey;

    public Mineral()
    {
        name = "";
        crystalSystem = "";
        hardness = new Range();
        luster = new StringList();
        color = new StringList();
        cleavage = 0;
        
        compKey = 0;

        loadArray();
    }

    public Mineral(String name, String crystalsystem, Range hardness, String[] luster, String[] color, Integer cleavage)
    {
        this.name = name;
        crystalSystem = crystalsystem;
        this.hardness = hardness;
        this.luster = new StringList(luster);
        this.color = new StringList(color);
        this.cleavage = cleavage;

        compKey = 0;
        keyedColor = this.color.getKeyedString();

        loadArray();
    }

    public Mineral(String name, String crystalsystem, Range hardness, String[] luster, String[] color, Integer cleavage, int compKey)
    {
        this.name = name;
        crystalSystem = crystalsystem;
        this.hardness = hardness;
        this.luster = new StringList(luster);
        this.color = new StringList(color);
        this.cleavage = cleavage;
        this.compKey = compKey;

        loadArray();
    }


    //Setters and Getters
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
        loadArray();
    }

    public String getCrystalSystem()
    {
        return crystalSystem;
    }

    public void setCrystalSystem(String crystalSystem)
    {
        this.crystalSystem = crystalSystem;
        loadArray();
    }

    public Range getHardness()
    {
        return hardness;
    }

    public void setHardness(Range hardness)
    {
        this.hardness = hardness;
        loadArray();
    }

    public StringList getLuster()
    {
        return luster;
    }
    
    public void setLuster(StringList luster)
    {
        this.luster = luster;
        loadArray();
    }

    public StringList getColor()
    {
        return color;
    }

    public void setColor(StringList color)
    {
        this.color = color;
        loadArray();
    }
    
    public Integer getCleavage()
    {
        return cleavage;
    }

    public void setCleavage(Integer cleavage)
    {
        this.cleavage = cleavage;
        loadArray();
    }

    public int getCompKey()
    {
        return compKey;
    }

    public void setCompKey(int compKey)
    {
        this.compKey = compKey;
        luster.setKey(compKey);
        color.setKey(compKey);
    }
    
    public void setCompKey(String k)
    {
        k = k.toUpperCase();

        switch (k)
        {
            case "NAME":
                compKey = 0;
                break;
            case "CRYSTAL SYSTEM":
                compKey = 1;
                break;
            case "HARDNESS":
                compKey = 2;
                break;
            case "LUSTER":
                compKey = 3;
                break;
            case "COLOR":
                compKey = 4;
                break;
            case "CLEAVAGE":
                compKey = 5;
                break;
        }
    }
    
    public Object returnCompKey()
    {
        Object ret = mineral.get(compKey);
        
    /*
        // if it is a StringList, return the keyed String
        if (ret instanceof StringList)
        {
            StringList sRet = (StringList) ret;
            return sRet.getKeyedString();
        }
*/
        return ret;
    }

    public int getColorKey()
    {
        return colorKey;
    }

    public void setColorKey(int colorKey)
    {
        this.colorKey = colorKey;
    }

    public int advanceColorKey()
    {
        return ++colorKey;
    }

    

    public void loadArray()
    {
        mineral.add(0, name);
        mineral.add(1, crystalSystem);
        mineral.add(2, hardness);
        mineral.add(3, luster);
        mineral.add(4, color);
        mineral.add(5, cleavage);
    }



    public String toString()
    {
        String minOut = "";
        minOut += "Name: " + name + "\n";
        minOut += "Crystal System: " + crystalSystem + "\n";
        minOut += "Hardness: " + hardness.toString() + "\n";
        minOut += "Luster: " + luster.toString() + "\n";
        minOut += "Color: " + color.toString() + "\n";
        minOut += "Cleavage: " + cleavage + "\n";

        return minOut;
    }
}

