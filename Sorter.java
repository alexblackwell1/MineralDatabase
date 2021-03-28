import java.util.ArrayList;
import java.util.List;

public class Sorter
{
    private StringListSorter stringLists;
    private Tree[] sortedTrees = new Tree[4];

    private int sortKey;

    public Sorter()
    {
        stringLists = new StringListSorter();
        sortedTrees[0] = new Tree();     // Name = 0
        sortedTrees[1] = new Tree();     // Structure = 1
        sortedTrees[2] = new Tree();     // Hardness = 2
        sortedTrees[3] = new Tree();     // Cleavage = 3
        sortKey = -1;
    }

    public Sorter(ArrayList<Mineral> mineralList)
    {
        ArrayList<MineralNode> nodeList = new ArrayList<MineralNode>();
        for (int i = 0; i < mineralList.size(); i++)
        {
            MineralNode temp = new MineralNode(mineralList.get(i));
            nodeList.add(temp);
        }

        stringLists = new StringListSorter(mineralList);
        sortedTrees[0] = new Tree(nodeList);     // Name = 0
        sortedTrees[1] = new Tree(nodeList);     // Structure = 1
        sortedTrees[2] = new Tree(nodeList);     // Hardness = 2
        sortedTrees[3] = new Tree(nodeList);     // Cleavage = 3

        sortedTrees[0].setTreeKey(0);
        sortedTrees[1].setTreeKey(1);
        sortedTrees[2].setTreeKey(2);
        sortedTrees[3].setTreeKey(5);

        sortKey = 0;
    }

    //Setters and Getters

    public int getSortKey() {return sortKey;}
    public void setSortKey(int key) {sortKey = key;}
    public boolean isEmpty()
    {
        switch (sortKey)
        {
            case 0:
            case 1:
            case 2:
            case 5:
                if (sortKey != 5)
                    return sortedTrees[sortKey].isEmpty();
                else
                    return sortedTrees[3].isEmpty();
            case 3:
            case 4:
                return stringLists.isEmpty();
        }
        return false;
    }

    public String toString()
    {
        String ret = "";
        switch (sortKey)
        {
            case 0:
            case 1:
            case 2:
            case 5:
                if (sortKey != 5)
                    ret = sortedTrees[sortKey].toString();
                else
                    ret = sortedTrees[3].toString();
                break;
            case 3:
            case 4:
                ret = stringLists.toString();
                break;
        }

        return ret;
    }
}

