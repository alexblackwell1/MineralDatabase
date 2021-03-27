public class Mineral
{
    private String name;
    private String crystalSystem;
    private double[] hardness;  
    private String luster;
    private String color;
    private int cleavage;

    public Mineral()
    {
        name = "";
        crystalSystem = "";
        hardness = new double[0];
        luster = "";
        color = "";
        cleavage = 0;
        
    }

    public Mineral(String name, String crystalsystem, double[] hardness, String luster, String color, int cleavage)
    {
        this.name = name;
        crystalSystem = crystalsystem;
        this.hardness = hardness;
        this.luster = luster;
        this.color = color;
        this.cleavage = cleavage;
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

    public double[] getHardness()
    {
        return hardness;
    }

    public void setHardness(double[] hardness)
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
    
    public int getCleavage()
    {
        return cleavage;
    }

    public void setCleavage(int cleavage)
    {
        this.cleavage = cleavage;
    }

    public String toString()
    {
        String minOut = "";
        minOut += "Name: " + name + "\n";
        minOut += "Crystal System: " + crystalSystem + "\n";
        if (hardness.length == 1)
            minOut += "Hardness: " + hardness[0] + "\n";
        else if (hardness.length > 1)
            minOut += "Hardness: " + hardness[0] + " " + hardness[1] + "\n";
        else
            minOut += "Hardness: " + "\n";
        minOut += "Luster: " + luster + "\n";
        minOut += "Color: " + color + "\n";
        minOut += "Cleavage: " + cleavage + "\n";

        return minOut;
    }
}
