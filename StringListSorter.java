import java.util.ArrayList;
import java.util.List;

public class StringListSorter
{
    
    private ArrayList<StringListElement> elements;
    private ArrayList<StringListElement> colors;
    private ArrayList<StringListElement> luster;
    private int sorterKey;

    public StringListSorter()
    {
        elements = new ArrayList<StringListElement>();
        luster = new ArrayList<StringListElement>();
        colors = new ArrayList<StringListElement>();
        sorterKey = 3;                                  // defaults to Luster
    }

    public StringListSorter(ArrayList<Mineral> minerals)
    {
        luster = new ArrayList<StringListElement>();
        colors = new ArrayList<StringListElement>();
        sorterKey = 3;                                  // defaults to Luster


        // add to the LUSTER set
        for (int i = 0; i < minerals.size(); i++)
        {
            // get a MINERAL
            Mineral mineral = minerals.get(i);
            mineral.setMineralKey(3);

            // get the NUMBER of values in the (string)List
            int numElem = mineral.getKeyedLength();

            // duplicate the mineral NUMBER times
            for (int j = 0; j < numElem; j++)
            {
                String val;

                // key each element on a different value
                val = mineral.getLuster().getAt(j);
//System.out.println(mineral+"\n\ti: "+i+" val: "+val);
                // add that mineral to LUSTER at the 1st keyed value location
                StringListElement current = new StringListElement(val, mineral);
                int location = findHeadOfValue(val, 0, luster.size(), luster);
                luster.add(location, current);
            }
        }

        //add to the COLOR set
        for (int i = 0; i < minerals.size(); i++)
        {
            Mineral mineral = minerals.get(i);
            mineral.setMineralKey(4);
            int numElem = mineral.getKeyedLength();

            // duplicate the mineral value # of times
            for (int j = 0; j < numElem; j++)
            {
                String val;

                // key each element on a different value
                val = mineral.getColor().getAt(j);

                // add that mineral to COLORS at the 1st keyed value location
                StringListElement current = new StringListElement(val, mineral);
                int location = findHeadOfValue(val, 0, colors.size(), colors);
                colors.add(location, current);
            }
        }

        elements = luster;          //default to LUSTER
    }

    public int findHeadOfValue(String target, int low, int high, ArrayList<StringListElement> list)
    {
        if (high < low)
            return -1;

        if (high == low)
            return 0;
        
        int mid = (high + low) / 2;
//System.out.println("low: "+low+" mid: "+ mid+" high: "+high);
        String curVal = list.get(mid).getValue();

        if (curVal == target)
        {
            while (list.get(mid-1).getValue() == target)
                mid--;
            return mid;
        }

        if (curVal.compareTo(target) < 0)
            return findHeadOfValue(target, mid, high, list);

        return findHeadOfValue(target, low, mid, list);
    }

    public String toString()
    {
        String str = "";

        for (int i = 0; i < elements.size(); i++)
        {
            StringListElement elem = elements.get(i);
            str += elem.getValue();
            str += "\n---\n";
            str += elem.getMineral().toString();
        }

        return str;
    }

    public void printValues()
    {
        String last = "";
        String curVal = "";
        for (int i = 0; i < elements.size(); i++)
        {
            curVal = elements.get(i).getValue();
            if (last != curVal)
                System.out.println(curVal);
            last = curVal;
        }
    }

    public int getSorterKey() {return sorterKey;}
    public void setSorterKey(int sk)
    {
        sorterKey = sk;
        
        switch (sorterKey)
        {
            case 3:
                elements = luster;
                break;
            case 4:
                elements = colors;
                break;
        }
    }

    public boolean isEmpty()
    {
        return elements.isEmpty();
    }
}