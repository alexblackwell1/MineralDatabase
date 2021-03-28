import java.util.ArrayList;
import java.util.List;

public class Sorter
{
    private StringListSorter stringLists;
    
    private Tree name;
    private Tree structure;
    private Tree hardness;
    private Tree cleavage;

    private int sortKey;

    public Sorter()
    {
        stringLists = new StringListSorter();
        name = new Tree(0);         // Name = 0
        structure = new Tree(1);    // Structure = 1
        hardness = new Tree(2);     // Hardness = 2
        cleavage = new Tree(5);    // Cleavage = 3
        sortKey = -1;
    }

    public Sorter(ArrayList<Mineral> mineralList)
    {
        sortKey = 0;
        ArrayList<MineralNode> nodeList = new ArrayList<MineralNode>();

        stringLists = new StringListSorter(mineralList);
        name = new Tree(mineralList, 0);        // Name = 0
        structure = new Tree(mineralList, 1);   // Structure = 1
        hardness = new Tree(mineralList, 2);   // Hardness = 2
        cleavage = new Tree(mineralList, 5);    // Cleavage = 3

        
    }

    //Setters and Getters

    public int getSortKey() {return sortKey;}
    public void setSortKey(int key)
    {
        sortKey = key;
        stringLists.setSorterKey(sortKey);
    }
    public boolean isEmpty()
    {
        switch (sortKey)
        {
            case 0:
                return name.isEmpty();
            case 1:
                return structure.isEmpty();
            case 2:
                return hardness.isEmpty();
            case 5:
                return cleavage.isEmpty();
            case 3:
            case 4:
                return stringLists.isEmpty();
        }
        return false;
    }

    public String toString()
    {
        switch (sortKey)
        {
            case 0:
                return name.toString();
            case 1:
                return structure.toString();
            case 2:
                return hardness.toString();
            case 5:
                return cleavage.toString();
            case 3:
            case 4:
                return stringLists.toString();
        }
        return "";
    }
}

