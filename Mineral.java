import java.util.ArrayList;
import java.util.List;

public class Mineral
{
    private String name;
    private String crystalSystem;
    private Range hardness;  
    private String luster;
    private String color;
    private Integer cleavage;

    private ArrayList<Object> mineral;

    private int key;

    public Mineral()
    {
        name = "";
        crystalSystem = "";
        hardness = new Range();
        luster = "";
        color = "";
        cleavage = 0;
        key = 1;

        loadArray();
    }

    public Mineral(String name, String crystalsystem, Range hardness, String luster, String color, Integer cleavage)
    {
        this.name = name;
        crystalSystem = crystalsystem;
        this.hardness = hardness;
        this.luster = luster;
        this.color = color;
        this.cleavage = cleavage;
        key = 1;

        loadArray();
    }

    public Mineral(String name, String crystalsystem, Range hardness, String luster, String color, Integer cleavage, int key)
    {
        this.name = name;
        crystalSystem = crystalsystem;
        this.hardness = hardness;
        this.luster = luster;
        this.color = color;
        this.cleavage = cleavage;
        this.key = key;

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
    }

    public String getCrystalSystem()
    {
        return crystalSystem;
    }

    public void setCrystalSystem(String crystalSystem)
    {
        this.crystalSystem = crystalSystem;
    }

    public Range getHardness()
    {
        return hardness;
    }

    public void setHardness(Range hardness)
    {
        this.hardness = hardness;
    }

    public String getLuster()
    {
        return luster;
    }
    
    public void setLuster(String luster)
    {
        this.luster = luster;
    }

    public String getColor()
    {
        return color;
    }

    public void setColor(String color)
    {
        this.color = color;
    }
    
    public Integer getCleavage()
    {
        return cleavage;
    }

    public void setCleavage(Integer cleavage)
    {
        this.cleavage = cleavage;
    }

    public int getKey()
    {
        return key;
    }

    public void setKey(int key)
    {
        this.key = key;
    }
    
    public void setKey(String k)
    {
        k = k.toUpperCase();

        switch (k)
        {
            case "NAME":
                key = 0;
                break;
            case "CRYSTAL SYSTEM":
                key = 1;
                break;
            case "HARDNESS":
                key = 2;
                break;
            case "LUSTER":
                key = 3;
                break;
            case "COLOR":
                key = 4;
                break;
            case "CLEAVAGE":
                key = 5;
                break;
        }
    }

    public Object returnKey()
    {
        return mineral.get(0);
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
        if (hardness.getRange() == 0)
            minOut += "Hardness: " + hardness.getMin() + "\n";
        else if (hardness.getRange() > 0)
            minOut += "Hardness: " + hardness.getMin() + "-" + hardness.getMax() + "\n";
        else
            minOut += "Hardness: " + "\n";
        minOut += "Luster: " + luster + "\n";
        minOut += "Color: " + color + "\n";
        minOut += "Cleavage: " + cleavage + "\n";

        return minOut;
    }
}

