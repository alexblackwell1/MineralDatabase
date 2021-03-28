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
        System.out.println("Enter any characteristic file of a mineral based on the following:\n\tName\n\tCrystal Symetry\n\tHardness\n\tColor\n\tCleavage");
        System.out.println("Any mineral that fits into the characteristic given will show up as a possible option.\n");
        System.out.println("Enter in file you want to use.");

        Scanner scanner = new Scanner(System.in);
        String fileName = "";
        File f1;

        // Make sure a valid filename was entered
        do {
//            fileName = scanner.nextLine();
fileName = "Minerals.txt";
            f1 = new File(fileName);
            if (!f1.exists())
                System.out.println("Could not find file, try another");
        } while (!f1.exists());

        ArrayList<Mineral> mineralList = readFile(fileName);
        MineralTree workingSet = new MineralTree();

        String answer;
        boolean b;

        workingSet = options(workingSet, mineralList);      // creates a tree coded on Names

        workingSet.setTreeKey(4);

        toFile(workingSet);

//        System.out.println(workingSet.toString());
/*
        do
        {
            

            System.out.println("Do you want to search for a mineral? (y/n)");
            answer = scanner.nextLine().toLowerCase();

            b = false;
            b |= (answer.compareTo("y") == 0);
            b |= (answer.compareTo("n") == 0);

            if(!b)
            {
                System.out.println("Please enter y or n");
            }
        
        } while (!b);

        if (answer.compareTo("n") == 0)
            System.out.println("Have a gneiss day!");
        else 
        {
            
        }
*/
    }

    public static MineralTree options(MineralTree workingSet, ArrayList<Mineral> mineralList)
    {
        Scanner scanner = new Scanner(System.in);
        String answer;
        boolean b;

        do {
            // give the user the options they can do with the data set

            System.out.println("Here are the following options or enter 'back' to return:");
            b = false;

            // If there is no set yet
            if (workingSet.isEmpty())
            {
                // option 1
                System.out.println("\t1. Start new data set");
                answer = scanner.nextLine().toLowerCase();

                b |= (answer.compareTo("1") == 0);
                b |= (answer.toLowerCase().compareTo("back") == 0);

                if (answer.toLowerCase().compareTo("back") == 0)
                    return null;
                if (!b)
                    System.out.println("Please enter 1 or 'back' to continue");
                else
                {
                    ArrayList<MineralNode> nodeList = new ArrayList<MineralNode>();

                    for (int i = 0; i < mineralList.size(); i++)
                    nodeList.add(i, new MineralNode(mineralList.get(i)));      // Minerals to Nodes

                    return new MineralTree(nodeList);
                }
            }

            // If a set is present ...
            else if (!workingSet.isEmpty())
            {
                // option 2-4
                System.out.println("\t1. Start new data set");
                System.out.println("\t2. Print set");
                System.out.println("\t3. Add to set");
                System.out.println("\t4. Remove from set");
                answer = scanner.nextLine().toLowerCase();

                b |= (answer.toLowerCase().compareTo("back") == 0);
                b |= (answer.compareTo("1") == 0);
                b |= (answer.compareTo("2") == 0);
                b |= (answer.compareTo("3") == 0);
                b |= (answer.compareTo("4") == 0);

                if (answer.toLowerCase().compareTo("back") == 0)
                    return null;
                else if (!b)
                {
                    //S.o.pl(enter 1);
                    System.out.println("Please enter 1-4 or 'back' to continue");
                }
                else
                {
                    System.out.println("Cool... you entered 1-4");
                }
            }



            // ask for input (which option)


        } while (!b);
        return null;
    }

    public static void addToSet()
    {
        String answer;
        boolean b;
        Scanner scanner = new Scanner(System.in);
        
        do {
            System.out.println("Choose one of the following catagories to add to the data set :");
            System.out.println("\t1. Name\n\t2. Crystal System\n\t3. Hardness\n\t4. Luster\n\t5. Color\n\t6. Cleavage\n");

            answer = scanner.nextLine().toLowerCase().replaceAll("\\s","");
            
            b = false;
            b |= (answer.compareTo("1") == 0);
            b |= (answer.compareTo("name") == 0);
            b |= (answer.compareTo("2") == 0);
            b |= (answer.compareTo("crystalsystem") == 0);
            b |= (answer.compareTo("3") == 0);
            b |= (answer.compareTo("hardness") == 0);
            b |= (answer.compareTo("4") == 0);
            b |= (answer.compareTo("luster") == 0);
            b |= (answer.compareTo("5") == 0);
            b |= (answer.compareTo("color") == 0);
            b |= (answer.compareTo("6") == 0);
            b |= (answer.compareTo("cleavage") == 0);

            if (!b)
            {
                System.out.println("Please enter 1-6 or the catagory's name");
            }
        } while (!b);
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

    public static void toFile(MineralTree tree)
    {
        File myObj = new File("dump.txt");
        
        try {
            FileWriter myWriter = new FileWriter("dump.txt");
            myWriter.write(tree.toString());
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}
