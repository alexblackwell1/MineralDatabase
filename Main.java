import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello There, Welcome to the Mineral Database.");
        System.out.println("Enter any characteristic file of a mineral based on the following:\n\tName\n\tCrystal Symetry\n\tHardness\n\tColor\n\tCleavage");
        System.out.println("Any mineral that fits into the characteristic given will show up as a possible option.\n");
        System.out.println("Enter in file you want to use.");

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        ArrayList<Mineral> mineralList = readFile(fileName);
    }

    public static ArrayList<Mineral> readFile(String fileName)
    {
        try
        {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            ArrayList<Mineral> mineralList = new ArrayList<Mineral>();
            int cur = 0;

            while (scanner.hasNextLine())
            {
                String data = scanner.nextLine();
                String[] elements = data.split(";");
                for (int i = 0; i < elements.length; i++)
                {
                    elements[i] = elements[i].replaceAll("\\s","");
                    
                    switch (i)
                    {
                        case 0:
                        case 1:
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
                                double num = Double.parseDouble(elements[2]);
                                range = new Range(num);
                            }
                            break;
                        case 3:
                        case 5:
                            
                    }
                }
            }
            scanner.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("Cannot read file");
            e.printStackTrace();
        }
        
        return null;
    }
}