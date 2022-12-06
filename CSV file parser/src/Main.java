import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Character.getNumericValue;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Character a = 'z';
        System.out.println(getNumericValue(a)-9);
        System.out.println("Hello world!");//how to find cell id with letters

        List<String> rows = new ArrayList<>();
        List<String> data = new ArrayList<>();

        Scanner sc = new Scanner(new File("example csv.csv"));
        while (sc.hasNextLine())  //returns a boolean value
        {
            //System.out.print(sc.next());  //find and returns the next complete token from this scanner
            rows.add(sc.nextLine());
        }
        sc.close();  //closes the scanner

        Scanner scanner = new Scanner(new File("example csv.csv"));
        scanner.useDelimiter(",");   //sets the delimiter pattern
        while (scanner.hasNext())  //returns a boolean value
        {
            //System.out.print(sc.next());  //find and returns the next complete token from this scanner
            data.add(scanner.next());
        }
        scanner.close();  //closes the scanner

        for(int i = 0; i < data.size(); i++){
            System.out.println(data.get(i));
        }
    }

}