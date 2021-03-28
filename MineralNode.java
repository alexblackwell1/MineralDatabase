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

    // adds an element to the left or right side depending if it is <= or > head
    public void addElement(MineralNode child, int key)
    {
        //set key of node/mineral and child's mineral
        nodeKey = key;
        data.setMineralKey(key);
        Mineral elem = child.getData();
        elem.setMineralKey(nodeKey);

        child.setLNode(null);
        child.setRNode(null);

        switch (nodeKey)
        {
            // case 0/1 is a single STTRING
            // (Name or Crystle Structure)
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

            // case 2 is a RANGE value
            // (Hardness)
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
            
            // case 3/4 is a list of STRINGS
            // (Luster or Color)
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

            // case 5 is an INTEGER
            // (Cleavage)
            case 5:
                Integer i1 = (Integer) data.returnMineralKeyedValue();    // data is a Mineral
                Integer i2 = (Integer) elem.returnMineralKeyedValue();    // retComp is Object
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
    public MineralNode getLNode() {return lNode;}

    public MineralNode getRNode() {return rNode;}
    
    public Mineral getData() {return data;}

    public Object getKeyedValue() {return keyedData;}

    public int getNodeKey() {return nodeKey;}

    public void setLNode(MineralNode lNode) {this.lNode = lNode;}

    public void setRNode(MineralNode rNode) {this.rNode = rNode;}
    
    public void setData(Mineral data) {this.data = data;}

    public void setKeyedValue(Object kv) {keyedData = kv;}

    public void setNodeKey(int k)
    {
        nodeKey = k;                    // Sets this key
        data.setMineralKey(nodeKey);    // Only sets the key of the mineral
                                        //      and of the StringLists
        keyedData = assignKey();        // returns OBJECT based off Key
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
        }
        ret += data.toString() + "\n\n";
        if (rNode != null)
            ret += rNode.toString();
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
                String s1 = (String) data.returnMineralKeyedValue();
                String s2 = (String) other.getData().returnMineralKeyedValue();
                return s1.compareTo(s2);
            case 2:
                Range r1 = (Range) data.returnMineralKeyedValue();
                Range r2 = (Range) other.getData().returnMineralKeyedValue();
                return r1.compareTo(r2);
            case 5:
                Integer i1 = (Integer) data.returnMineralKeyedValue();
                Integer i2 = (Integer) other.getData().returnMineralKeyedValue();
                return i1.compareTo(i2);
        }

        return -999;
    }
