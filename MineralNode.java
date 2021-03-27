import java.util.ArrayList;
import java.util.List;

public class MineralNode
{
    private MineralNode lNode;
    private MineralNode rNode; 
    private Mineral data;

    public MineralNode()
    {
        lNode = null;
        rNode = null;
        data = null;
    }

    public MineralNode(Mineral data)
    {
        lNode = null;
        rNode = null;
        this.data = data;
    }
    
    public MineralNode(Mineral data, MineralNode l, MineralNode r)
    {
        lNode = l;
        rNode = r;
        this.data = data;
    }

    public void addElement(MineralNode child)
    {
        if (data.returnKey() instanceof String)
        {
            String s1 = (String) data.returnKey();
            String s2 = (String) child.getData().returnKey();
            if (s1.compareTo(s2) <= 0)
            {
                if (lNode == null)
                    lNode = child;
                else
                    lNode.addElement(child);
            }
            else
            {
                if (rNode == null)
                    rNode = child;
                else
                    rNode.addElement(child);
            }
        }

        else if (data.returnKey() instanceof Integer)
        {
            Integer s1 = (Integer) data.returnKey();
            Integer s2 = (Integer) child.getData().returnKey();
            if (s1 <= s2)
            {
                if (lNode == null)
                    lNode = child;
                else
                    lNode.addElement(child);
            }
            else
            {
                if (rNode == null)
                    rNode = child;
                else
                    rNode.addElement(child);
            }
        }

        else
        {
            ArrayList<Double> hardnessRange1 = (ArrayList) data.returnKey();
            ArrayList<Double> hardnessRange2 = (ArrayList) child.getData().returnKey();
            Double k1 = (Double) hardnessRange1.get(0);
            Double k2 = (Double) hardnessRange2.get(0);
            if (k1 <= k2)
            {
                if (lNode == null)
                    lNode = child;
                else
                    lNode.addElement(child);
            }
            else
            {
                if (rNode == null)
                    rNode = child;
                else
                    rNode.addElement(child);
            }
        }
    }

    //Getters and Setters
    public MineralNode getLNode()
    {
        return lNode;
    }

    public void setLNode(MineralNode lNode)
    {
        this.lNode = lNode;
    }

    public MineralNode getRNode()
    {
        return rNode;
    }

    public void setRNode(MineralNode rNode)
    {
        this.rNode = rNode;
    }
    
    public Mineral getData()
    {
        return data;
    }
    
    public void setData(Mineral data)
    {
        this.data = data;
    }

    public int getSize()
    {
        int size = 1;
        if (rNode != null)
        {
            size += rNode.getSize();
        }
        if (lNode != null)
        {
            size += lNode.getSize();
        }
        return size;
    }

    public String toString()
    {
        return data.toString();
    }
}
