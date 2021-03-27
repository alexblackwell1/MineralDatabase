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

    public void addElement(Mineral elem)
    {
        int key = data.getKey();
        elem.setKey(key);

        MineralNode child = new MineralNode(elem);

        switch (key)
        {
            case 0:
            case 1:
            case 3:
            case 4:
                String s1 = (String) data.returnKey();
                String s2 = (String) elem.returnKey();
                if (s1.compareTo(s2) <= 0)
                {
                    if (lNode == null)
                            lNode = child;
                    else
                        lNode.addElement(elem);
                }
                else
                {
                    if (rNode == null)
                            rNode = child;
                    else
                        rNode.addElement(elem);
                }
                break;
            case 2:
                Range r1 = (Range) data.returnKey();
                Range r2 = (Range) elem.returnKey();
                if (r1.compareTo(r2) <= 0)
                {
                    if (lNode == null)
                            lNode = child;
                    else
                        lNode.addElement(elem);
                }
                else
                {
                    if (rNode == null)
                            rNode = child;
                    else
                        rNode.addElement(elem);
                }
                break;
            default:
                Integer i1 = (Integer) data.returnKey();
                Integer i2 = (Integer) elem.returnKey();
                if (i1.compareTo(i2) <= 0)
                {
                    if (lNode == null)
                            lNode = child;
                    else
                        lNode.addElement(elem);
                }
                else
                {
                    if (rNode == null)
                            rNode = child;
                    else
                        rNode.addElement(elem);
                }
                break;
        }
    }

    public void addElement(MineralNode child)
    {
        int key = data.getKey();

        Mineral elem = child.getData();

        elem.setKey(key);

        switch (key)
        {
            case 0:
            case 1:
            case 3:
            case 4:
                String s1 = (String) data.returnKey();
                String s2 = (String) elem.returnKey();
                if (s1.compareTo(s2) <= 0)
                {
                    if (lNode == null)
                            lNode = child;
                    else
                        lNode.addElement(elem);
                }
                else
                {
                    if (rNode == null)
                            rNode = child;
                    else
                        rNode.addElement(elem);
                }
                break;
            case 2:
                Range r1 = (Range) data.returnKey();
                Range r2 = (Range) elem.returnKey();
                if (r1.compareTo(r2) <= 0)
                {
                    if (lNode == null)
                            lNode = child;
                    else
                        lNode.addElement(elem);
                }
                else
                {
                    if (rNode == null)
                            rNode = child;
                    else
                        rNode.addElement(elem);
                }
                break;
            default:
                Integer i1 = (Integer) data.returnKey();
                Integer i2 = (Integer) elem.returnKey();
                if (i1.compareTo(i2) <= 0)
                {
                    if (lNode == null)
                            lNode = child;
                    else
                        lNode.addElement(elem);
                }
                else
                {
                    if (rNode == null)
                            rNode = child;
                    else
                        rNode.addElement(elem);
                }
                break;
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
