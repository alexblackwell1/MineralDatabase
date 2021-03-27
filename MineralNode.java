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
        
        if (data.getName().compareTo(child.getData().getName()) <= 0)
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
    
    public Mineral getdata()
    {
        return data;
    }
    
    public void setdata(Mineral data)
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
