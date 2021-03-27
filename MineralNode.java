import java.util.ArrayList;
import java.util.List;

public class MineralNode
{
    private MineralNode lNode;
    private MineralNode rNode; 
    private Mineral data;

    private int key;
    private Object keyedData;

    public MineralNode()
    {
        lNode = null;
        rNode = null;
        data = null;
        key = -1;
    }

    public MineralNode(Mineral data)
    {
        lNode = null;
        rNode = null;
        this.data = data;
        key = 0;
        keyedData = null;
    }

    public MineralNode(MineralNode node, Object kv)
    {
        lNode = node.getLNode();
        rNode = node.getRNode();
        data = node.getData();
        key = node.getKey();
        keyedData = kv;
    }

    public MineralNode(Mineral data, int key)
    {
        lNode = null;
        rNode = null;
        this.data = data;
        this.key = key;

        keyedData = assignKey();
    }
    
    public MineralNode(Mineral data, MineralNode l, MineralNode r)
    {
        lNode = l;
        rNode = r;
        this.data = data;
        
        keyedData = assignKey();
    }
    
    public MineralNode(Mineral data, MineralNode l, MineralNode r, int key)
    {
        lNode = l;
        rNode = r;
        this.data = data;
        this.key = key;

        keyedData = assignKey();
    }

    public void addElement(Mineral elem)
    {
        int key = data.getCompKey();
        elem.setCompKey(key);

        MineralNode child = new MineralNode(elem);

        switch (key)
        {
            case 0:
            case 1:
                String s1 = (String) data.returnCompKey();
                String s2 = (String) elem.returnCompKey();
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
                Range r1 = (Range) data.returnCompKey();
                Range r2 = (Range) elem.returnCompKey();
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
            case 3:
            case 4:
                StringList sl1 = (StringList) data.returnCompKey();
                StringList sl2 = (StringList) elem.returnCompKey();
                if (sl1.compareTo(sl2) <= 0)
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
                Integer i1 = (Integer) data.returnCompKey();
                Integer i2 = (Integer) elem.returnCompKey();
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
        int key = data.getCompKey();

        Mineral elem = child.getData();

        elem.setCompKey(key);

        switch (key)
        {
            case 0:
            case 1:
                String s1 = (String) data.returnCompKey();
                String s2 = (String) elem.returnCompKey();
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
                Range r1 = (Range) data.returnCompKey();
                Range r2 = (Range) elem.returnCompKey();
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
            case 3:
            case 4:
                StringList sl1 = (StringList) data.returnCompKey();
                StringList sl2 = (StringList) elem.returnCompKey();
                if (sl1.compareTo(sl2) <= 0)
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
                Integer i1 = (Integer) data.returnCompKey();
                Integer i2 = (Integer) elem.returnCompKey();
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

    public int getKey()
    {
        return key;
    }

    public void setKey(int key)
    {
        this.key = key;

        data.setCompKey(key);
        
        keyedData = assignKey();
    }

    public Object getKeyedValue()
    {
        return keyedData;
    }

    public void setKeyedValue(Object kv)
    {
        keyedData = kv;
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
        String ret = "";
        if (lNode != null)
        {
            ret += lNode.toString();
            ret += "\n-------------\n\n";
        }
        ret += data.toString();
        ret += "\n-------------\n\n";
        if (rNode != null)
            ret += rNode.toString();
        return ret;
    }

    public Object assignKey()
    {
        switch (key) {
            case 0:
                return data.getName();
            case 1:
                return data.getCrystalSystem();
            case 2: 
                return data.getHardness();
            case 3:
                return data.getLuster();
            case 4:
                return data.getColor();
            case 5:
                return data.getCleavage();
        }
        return null;
    }

    public int compareTo(MineralNode other)
    {
        switch (key)
        {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
        }

        return -999;
    }
}
