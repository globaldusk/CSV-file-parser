import java.io.*;
import java.util.*;

import static java.lang.Character.getNumericValue;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Character a = 'z';
        System.out.println(getNumericValue(a)-9);
        System.out.println("Hello world!");//how to find cell id with letters

        List<List<String>> cellMatrix = new ArrayList<>();
        List<String> rows = new ArrayList<>();

        Scanner sc = new Scanner(new File("example csv.csv"));
        sc.useDelimiter(",");
        while (sc.hasNextLine())  //returns a boolean value
        {
            rows.add(sc.nextLine());
        }
        sc.close();  //closes the scanner

        for (String row : rows) {
            List<String> list = new ArrayList<String>(Arrays.asList(row.split(",")));
            cellMatrix.add(list);
        }
        for (List<String> list : cellMatrix) {

            for (String cell : list) {
                System.out.print(cell+" -> ");
                System.out.println(evaluatePostfix(cell));
            }
        }
        System.out.println(cellMatrix);
    }

    public static boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Double.parseDouble(str);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    static int evaluatePostfix(String exp)
    {
        //create a stack
        Stack<Integer> stack=new Stack<>();
        String[] items = exp.split(" ");

        // Scan all characters one by one
        for(String item : items)
        {

            if(isNumeric(item)){
                stack.push(Integer.parseInt(item));
            }


                //  If the scanned character is an operator, pop two
                // elements from stack apply the operator
            else
            {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (item) {
                    case "+" -> stack.push(val2 + val1);
                    case "-" -> stack.push(val2 - val1);
                    case "/" -> stack.push(val2 / val1);
                    case "*" -> stack.push(val2 * val1);
                }
            }
        }
        //System.out.print(stack.pop());
        return stack.pop();
    }
}