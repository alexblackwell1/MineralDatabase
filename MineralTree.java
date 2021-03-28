import java.util.ArrayList;
import java.util.List;

public class MineralTree
{
    private MineralNode head;
    private ArrayList<MineralNode> list = new ArrayList<MineralNode>();
    private int treeKey;

    public MineralTree()
    {
        head = null;
        treeKey = -1;
    }

    public MineralTree(MineralNode head)
    {
        this.head = head;
        treeKey = 0;
    }

    public MineralTree(ArrayList<MineralNode> list)
    {
        this.list = list;
        head = null;
        treeKey = 0;

        formTree(0);
    }

    //Setters and Getters
    public MineralNode getHead()
    {
        return head;
    }


    public int getTreeKey()
    {
        return treeKey;
    }

    public void setTreeKey(int mineralKey)
    {
        if (mineralKey != treeKey)
        {
            treeKey = mineralKey;
            formTree(treeKey);
        }
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public void formTree(int key)
    {
        treeKey = key;

        head = list.get(0);
        head.setNodeKey(key);
        head.setLNode(null);
        head.setRNode(null);
        
        MineralNode cur;

        for (int i = 1; i < list.size(); i++) 
        {
            cur = list.get(i);          // MineralNode
            cur.setNodeKey(treeKey);    // Sets node/mineral KEY and mineral key VALUE

            // for lists (luster/color)
            // duplicate node n times
            // place each in tree on different element
            if (treeKey == 3 || treeKey == 4)
            {
                // find the number of elements
                StringList trait = (StringList) cur.getKeyedValue();
                // duplicate and set
                for (int j = 0; j < trait.getLength(); j++)
                {
                    Object kv = trait.getAt(j);             // String
                    StringList traitsList = (StringList) cur.getKeyedValue();
                    switch (treeKey)
                    {
                        case 3:
                            cur.getData().getLuster().setStringListKey(j);
                            break;
                        case 4:
                            cur.getData().getColor().setStringListKey(j);
                            break;
                    }
                    head.addElement(new MineralNode(cur, kv), treeKey);
                }
            }

            else
            {
                head.addElement(cur, treeKey);
            }
        }
    }

    public String toString()
    {
        return head.toString();
    }
}

