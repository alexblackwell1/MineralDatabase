import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.io.IOException;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello There, Welcome to the Mineral Database.");
        System.out.println("Here you can search the Database by any category.");
        System.out.println("If you sort by luster or color,\n\tdata will be duplicated to for each component it has listed");
        System.out.println("\n-----------------------------------\n");

        String fileName = "Minerals.txt";

        ArrayList<Mineral> mineralList = readFile(fileName);
        Sorter workingSet = options(mineralList);

        toFile(workingSet);

        System.out.println("The data set is sorted based off your input.\n---");
        System.out.println("Have a gneiss day!\n");
    }

    public static Sorter options(ArrayList<Mineral> mineralList)
    {
        Scanner scanner = new Scanner(System.in);
        String answer = "";
        int ans = -1;
        boolean b;
        
        System.out.println("Please select a trait to sort by:");
        System.out.println("1. Sort by Name");
        System.out.println("2. Sort by Crystal Structure");
        System.out.println("3. Sort by Hardness");
        System.out.println("4. Sort by Luster");
        System.out.println("5. Sort by Color");
        System.out.println("6. Sort by Cleavage");


        do
        {
            ans = scanner.nextInt();
            if (ans < 1 || ans > 6)
                System.out.println("Please enter a number 1-6");
        } while (ans < 1 || ans > 6);

        //sort by ans
        Sorter temp = new Sorter(mineralList);
        temp.setSortKey(--ans);

        return temp;
    }

    public static ArrayList<Mineral> readFile(String fileName)
    {
        try
        {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            ArrayList<Mineral> mineralList = new ArrayList<Mineral>();
            int cur = 0;

            // Read each line
            while (scanner.hasNextLine())
            {
                String data = scanner.nextLine();

                // Create an emptyMaterial object
                Mineral currentMineral = new Mineral();
                if (data.length() > 0)
                {
                    String[] elements = data.split(";");


                    // Add each component to the current Material
                    for (int i = 0; i < elements.length; i++)
                    {
                        elements[i] = elements[i].replaceAll("\\s","");
                        
                        switch (i)
                        {
                            case 0:
                            currentMineral.setName(elements[i]);
                                break;
                            case 1:
                                currentMineral.setCrystalSystem(elements[i]);
                                break;
                            case 2:
                                Range range;
                                if (elements[2].contains("-"))
                                {
                                    String[] rangeStr = elements[2].split("-");
                                    double min = Double.parseDouble(rangeStr[0]);
                                    double max = Double.parseDouble(rangeStr[1]);
                                    
                                    range = new Range(min, max);
                                }
                                else
                                {
                                    double num = Double.parseDouble(elements[i]);
                                    range = new Range(num);
                                }

                                currentMineral.setHardness(range);
                                
                                break;
                            case 3:
                                String[] lusterList = elements[i].split(",");
                                
                                currentMineral.setLuster(new StringList(lusterList));

                                break;
                            case 4:
                                String[] colorList = elements[i].split(",");
                            
                                currentMineral.setColor(new StringList(colorList));

                                break;
                            case 5:
                            
                                if (elements[5].compareTo("None") != 0)
                                {
                                    int cleavage = Integer.parseInt(elements[i]);
                                    currentMineral.setCleavage(new Integer(cleavage));
                                }
                                else 
                                    currentMineral.setCleavage(new Integer(0));

                                break; 
                        }
                    }
                }

                // Add the material to an ArrayList
                mineralList.add(cur++, currentMineral);
            }
            scanner.close();

            return mineralList;
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot read file");
            e.printStackTrace();
        }
        
        return null;
    }


    public static void toFile(Sorter sorted)
    {
        File myObj = new File("dump.txt");
        
        try {
            FileWriter myWriter = new FileWriter("dump.txt");
            myWriter.write(sorted.toString());
            myWriter.close();
            System.out.println("\nSuccessfully wrote to data.dump.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
