import java.io.*;
import java.util.*;

import static java.lang.Character.*;

public class Main {
    public static List<List<String>> cellMatrix = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException {


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
                list.set(list.indexOf(cell), evaluatePostfix(cell));
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

    public static String findCellVal(String coord){
        int row = 0;
        int col = 0;

        for(int i=0;i<coord.length();i++) {
            char c = coord.charAt(i);

            if (Character.isLetter(c)) {
                col= getNumericValue(c)-10;
            }

            else if (Character.isDigit(c)) {
                row = (c - '0')-1;
            }

            else {
                return "#ERR";
            }
        }
        return (cellMatrix.get(row)).get(col);
    }

    static String evaluatePostfix(String exp)
    {
        Boolean leave = false;
        //create a stack
        Stack<String> stack=new Stack<>();
        String[] items = exp.split(" ");

        // Scan all characters one by one
        for(String item : items)
        {
            boolean letterNumber = true;
            char[] itemParts = item.toCharArray();
            for(char chars : itemParts){
                if(!Character.isLetterOrDigit(chars)){
                    letterNumber = false;
                }
            }

            if(isNumeric(item)){
                stack.push(item);
            }

            else if(letterNumber){//if is letter number
                //System.out.println("HERE-"+findCellVal(item));
                stack.push(findCellVal(item));
                leave = true;
            }
                //  If the scanned character is an operator, pop two
                // elements from stack apply the operator
            else if(!leave){
                int val1 = Integer.parseInt(stack.pop());
                int val2 = Integer.parseInt(stack.pop());
                switch (item) {
                    case "+" -> stack.push(Integer.toString(val2 + val1));
                    case "-" -> stack.push(Integer.toString(val2 - val1));
                    case "/" -> stack.push(Integer.toString(val2 / val1));
                    case "*" -> stack.push(Integer.toString(val2 * val1));
                    default -> {
                        System.out.print(" HERE ");
                        return "#ERR";
                    }
                }
            }
            else{
                return stack.pop()+" "+stack.pop()+" "+item;
            }

        }
        //System.out.print(stack.pop());
        return stack.pop();
    }
}