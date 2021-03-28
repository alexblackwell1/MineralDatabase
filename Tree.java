import java.util.ArrayList;
import java.util.List;

public class Tree
{
    private int treeKey;
    private MineralNode head;
    private ArrayList<MineralNode> nodeList = new ArrayList<MineralNode>();

    public Tree()
    {
        treeKey = 0;
        head = null;
    }
    public Tree(int key)
    {
        treeKey = key;
        head = null;
    }

    public Tree(ArrayList<Mineral> mineralList, int key)
    {
        treeKey = key;

        for (int i = 0; i < mineralList.size(); i++)
        {
            MineralNode cur = new MineralNode(mineralList.get(i), treeKey);
            nodeList.add(cur);
        }

        head = null;

        formTree(treeKey);
    }

    public void formTree(int key)
    {
        treeKey = key;

        head = nodeList.get(0);
        head.setNodeKey(treeKey);
        head.setLNode(null);
        head.setRNode(null);
        
        MineralNode cur;

        for (int i = 1; i < nodeList.size(); i++) 
        {
            cur = nodeList.get(i);      // MineralNode
            cur.setNodeKey(treeKey);    // Sets node/mineral KEY and mineral key VALUE

            head.addElement(cur, treeKey);
        }
//System.out.println(toString());
    }

    // Getters and Setters
    public MineralNode getHead() {return head;}
    public void setHead(MineralNode h) {head = h;}
    public int getTreeKey() {return treeKey;}
    public void setTreeKey(int key)
    {
        if (key != treeKey)
        {
            treeKey = key;
            formTree(treeKey);
        }
    }
    public boolean isEmpty() {return head == null;}

    public String toString()
    {
        return head.toString();
    }
}
