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
        
//System.out.println("treeKey: "+treeKey);
        MineralNode cur;

        for (int i = 1; i < list.size(); i++) 
        {
            cur = list.get(i);      // MineralNode
            cur.setNodeKey(treeKey);        
//System.out.println("nodeKey: "+cur.getNodeKey());
//System.out.println("mineralKey: "+cur.getData().getMineralKey());
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








/*
    public void addElement(MineralNode m)
    {
        
        if  (head == null)
            head = m;
        //go Left
        else if (head.getKeyedValue().compareTo(m.getKeyedValue()) <= 0)
        {
            if (head.getLNode() == null)
                head.setLNode() = m;
            else
                head.getLNode().addElement(m);
        }
        //go Right
        else if (head.getKeyedValue().compareTo(m.getKeyedValue()) > 0)
        {
            if (head.getRNode() == null)
                head.setRNode() = m;
            else
                head.getRNode().addElement(m);
        }
    }

    public MineralNode removeElement(MineralNode node)
    {
        if (head == node)
        {
            
        }
        return null;
    }
*/
    