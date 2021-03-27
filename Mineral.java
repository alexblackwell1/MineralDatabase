import java.util.ArrayList;
import java.util.List;

public class Mineral
{
    private String name;
    private String crystalSystem;
    private ArrayList<Double> hardness;  
    private String luster;
    private String color;
    private Integer cleavage;

    private ArrayList<Object> mineral;

    private int key;

    public Mineral()
    {
        name = "";
        crystalSystem = "";
        hardness = new ArrayList<Double>();
        luster = "";
        color = "";
        cleavage = 0;
        key = 1;

        loadArray();
    }

    public Mineral(String name, String crystalsystem, ArrayList<Double> hardness, String luster, String color, Integer cleavage)
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

    public Mineral(String name, String crystalsystem, ArrayList<Double> hardness, String luster, String color, Integer cleavage, int key)
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

    public ArrayList<Double> getHardness()
    {
        return hardness;
    }

    public void setHardness(ArrayList<Double> hardness)
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
                key = 1;
                break;
            case "CRYSTAL SYSTEM":
                key = 2;
                break;
            case "HARDNESS":
                key = 3;
                break;
            case "LUSTER":
                key = 4;
                break;
            case "COLOR":
                key = 5;
                break;
            case "CLEAVAGE":
                key = 6;
                break;
        }
    }

    public Object returnKey()
    {
        switch (key)
        {
            case 1:
                return name;
            case 2:
                return crystalSystem;
            case 3:
                return hardness;
            case 4:
                return luster;
            case 5:
                return color;
            case 6:
                return cleavage;
        }

        return -1;
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
        if (hardness.size() == 1)
            minOut += "Hardness: " + hardness.get(0) + "\n";
        else if (hardness.size() > 1)
            minOut += "Hardness: " + hardness.get(0) + "-" + hardness.get(1) + "\n";
        else
            minOut += "Hardness: " + "\n";
        minOut += "Luster: " + luster + "\n";
        minOut += "Color: " + color + "\n";
        minOut += "Cleavage: " + cleavage + "\n";

        return minOut;
    }
}
