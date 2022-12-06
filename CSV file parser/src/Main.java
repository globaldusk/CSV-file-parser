import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        System.out.println("Hello world!");

        List<List<String>> dataMatrix = new ArrayList<List<String>>();

        //parsing a CSV file into Scanner class constructor
        Scanner sc = new Scanner(new File("example csv.csv"));
        sc.useDelimiter(",");   //sets the delimiter pattern
        while (sc.hasNext())  //returns a boolean value
        {
            System.out.print(sc.next());  //find and returns the next complete token from this scanner
            if(sc.hasNext()){            dataMatrix.add(Arrays.asList(sc.next()));System.out.print(",");}

        }
        sc.close();  //closes the scanner

       // System.out.println(dataMatrix);

    }
}