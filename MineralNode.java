import java.util.ArrayList;
import java.util.List;

public class MineralNode
{
    private MineralNode lNode;
    private MineralNode rNode; 
    private Mineral data;

    private int nodeKey;
    private Object keyedData;

    public MineralNode()
    {
        lNode = null;
        rNode = null;
        data = null;
        nodeKey = -1;
    }

    // Used in main
    public MineralNode(Mineral data)
    {
        lNode = null;
        rNode = null;
        this.data = data;
        nodeKey = data.getMineralKey();
        keyedData = null;
    }

    public MineralNode(MineralNode node, Object kv)
    {
        lNode = node.getLNode();
        rNode = node.getRNode();
        data = node.getData();
        nodeKey = node.getNodeKey();
        keyedData = kv;
    }

    public MineralNode(Mineral data, int key)
    {
        lNode = null;
        rNode = null;
        this.data = data;
        nodeKey = key;

        data.setMineralKey(nodeKey);

        keyedData = assignKey();
    }
    
    public MineralNode(Mineral data, MineralNode l, MineralNode r)
    {
        lNode = l;
        rNode = r;
        this.data = data;
        nodeKey = data.getMineralKey();
        
        keyedData = assignKey();
    }

    public void addElement(MineralNode child, int key)
    {
        nodeKey = key;
        data.setMineralKey(key);
        Mineral elem = child.getData();
//System.out.println("data: "+data.getMineralKey());
//System.out.println("node: "+nodeKey);
//System.out.println("child: "+child.getNodeKey());
        elem.setMineralKey(nodeKey);
//System.out.println("elem: "+elem.getMineralKey());
        switch (nodeKey)
        {
            case 0:
            case 1:
                String s1 = (String) data.returnMineralKeyedValue();
                String s2 = (String) elem.returnMineralKeyedValue();
                if (s1.compareTo(s2) <= 0)
                {
                    if (lNode == null)
                            lNode = child;
                    else
                        lNode.addElement(new MineralNode(elem), key);
                }
                else
                {
                    if (rNode == null)
                            rNode = child;
                    else
                        rNode.addElement(new MineralNode(elem), key);
                }
                break;
            case 2:
                Range r1 = (Range) data.returnMineralKeyedValue();
                Range r2 = (Range) elem.returnMineralKeyedValue();
                if (r1.compareTo(r2) <= 0)
                {
                    if (lNode == null)
                            lNode = child;
                    else
                        lNode.addElement(new MineralNode(elem), key);
                }
                else
                {
                    if (rNode == null)
                            rNode = child;
                    else
                        rNode.addElement(new MineralNode(elem), key);
                }
                break;
            case 3:
            case 4:
                StringList sl1 = (StringList) data.returnMineralKeyedValue();
                StringList sl2 = (StringList) elem.returnMineralKeyedValue();
                if (sl1.compareTo(sl2) <= 0)
                {
                    if (lNode == null)
                            lNode = child;
                    else
                        lNode.addElement(new MineralNode(elem), key);
                }
                else
                {
                    if (rNode == null)
                            rNode = child;
                    else
                        rNode.addElement(new MineralNode(elem), key);
                }
                break;
            case 5:
//System.out.println(data.toString()+"\n---\n"+elem.toString());
//System.out.println(data.getCleavage()+"\n---\n"+elem.getCleavage());
                Integer i1 = (Integer) data.returnMineralKeyedValue();    // data is a Mineral
//System.out.println("cleavage1: "+i1);
                Integer i2 = (Integer) elem.returnMineralKeyedValue();    // retComp is Object
//System.out.println("cleavage2: "+i2);
                if (i1.compareTo(i2) <= 0)
                {
                    if (lNode == null)
                            lNode = child;
                    else
                        lNode.addElement(new MineralNode(elem), key);
                }
                else
                {
                    if (rNode == null)
                            rNode = child;
                    else
                        rNode.addElement(new MineralNode(elem), key);
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

    public int getNodeKey()
    {
        return nodeKey;
    }

    public void setNodeKey(int k)
    {
        nodeKey = k;

        data.setMineralKey(nodeKey);
        
        keyedData = assignKey();        //of Type Object
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
            ret += lNode.toString() + "\n";
        }
        ret += data.toString() + "\n";
        if (rNode != null)
            ret += rNode.toString() + "\n";
        return ret;
    }

    public Object assignKey()
    {
        switch (nodeKey) {
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
        switch (nodeKey)
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







/*
    public void addElement(Mineral elem)
    {
        int key = data.getMineralKey();
        elem.setMineralKey(key);

        MineralNode child = new MineralNode(elem);

        switch (key)
        {
            case 0:
            case 1:
                String s1 = (String) data.returnMineralKey();
                String s2 = (String) elem.returnMineralKey();
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
                Range r1 = (Range) data.returnMineralKey();
                Range r2 = (Range) elem.returnMineralKey();
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
                StringList sl1 = (StringList) data.returnMineralKey();
                StringList sl2 = (StringList) elem.returnMineralKey();
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
                Integer i1 = (Integer) data.returnMineralKey();
                Integer i2 = (Integer) elem.returnMineralKey();
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
*/