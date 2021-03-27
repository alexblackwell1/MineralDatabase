import java.util.ArrayList;
import java.util.List;

public class MineralTree
{
    private MineralNode head;
    private ArrayList<MineralNode> list = new ArrayList<MineralNode>();
    private int key;

    public MineralTree()
    {
        head = null;
        key = -1;
    }

    public MineralTree(MineralNode head)
    {
        this.head = head;
        key = 0;
    }

    public MineralTree(ArrayList<MineralNode> list)
    {
        this.list = list;
        head = list.get(0);
        key = 1;

        formTree(1);
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
    
    //Setters and Getters
    public MineralNode getHead()
    {
        return head;
    }


    public int getKey()
    {
        return key;
    }

    public void setKey(int compKey)
    {
        if (compKey != key)
        {
            this.key = compKey;
            formTree(key);
        }
    }

    public boolean isEmpty()
    {
        return head == null;
    }

    public void formTree(int key)
    {
        this.key = key;
        MineralNode cur;
        for (int i = 1; i < list.size(); i++) 
        {
            cur = list.get(i);
            cur.getData().setCompKey(key);
            cur.setKey(key);

            // for lists (luster/color)
            // duplicate node n times
            // place each in tree on different element

            if (key == 3 || key == 4)
            {
                // find the number of elements
                StringList trait = (StringList) cur.getKeyedValue();
                // duplicate and set
                for (int j = 0; j < trait.getLength(); j++)
                {
                    Object kv = trait.getAt(j);             // String
                    head.addElement(new MineralNode(cur, kv));
                }
            }
            else
            {
                head.addElement(cur);
            }
        }
    }

    public String toString()
    {
        return head.toString();
    }
}