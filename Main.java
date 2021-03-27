import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        System.out.println("Hello There, Welcome to the Mineral Database.");
        System.out.println("Enter any characteristic of a mineral based on the following:\n\tName\n\tCrystal Symetry\n\tHardness\n\tColor\n\tCleavage");
        System.out.println("Any mineral that fits into the characteristic given will show up as a possible option.\n");
        System.out.println("Enter in file you want to use.");

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        System.out.println(fileName);
    }
}