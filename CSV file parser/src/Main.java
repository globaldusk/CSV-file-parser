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
                if(isCorrectNotation(cell)){
                    System.out.print(cell+" -> ");
                    System.out.println(evaluatePostfix(cell));
                    list.set(list.indexOf(cell), evaluatePostfix(cell));
                }
                else{
                    String[] items = cell.split(" ");
                    StringBuilder setter = new StringBuilder();
                    for(int i = 0; i < items.length; i++)
                    {
                        if(isLetterNumber(items[i])){
                            items[i] = findCellVal(items[i]);

                        }
                        if(i == items.length-1){
                            setter.append(items[i]);
                        }
                        else{
                            setter.append(items[i]).append(" ");
                        }

                    }
                    System.out.print(cell+" -> ");
                    System.out.println(setter);
                    list.set(list.indexOf(cell), setter.toString());
                }


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

    public static boolean isLetterNumber(String item){

        char[] itemParts = item.toCharArray();
        for(char chars : itemParts){
            if(!Character.isLetterOrDigit(chars)){
                return false;
            }
        }
        return true;
    }

    public static boolean isCorrectNotation(String exp){
        String[] items = exp.split(" ");

        for(String item : items)
        {
            if (!isNumeric(item) && !Objects.equals(item, "+") && !Objects.equals(item, "-") && !Objects.equals(item, "*") && !Objects.equals(item, "/")){
                return false;
            }
        }
        return true;
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
            if(isNumeric(item)){
                stack.push(item);
            }
                //  If the scanned character is an operator, pop two
                // elements from stack apply the operator
            else {
                int val1 = Integer.parseInt(stack.pop());
                int val2 = Integer.parseInt(stack.pop());
                try {switch (item) {
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
                catch(NumberFormatException e){
                    System.out.print(e);
                    return "#ERR";
                };
            }
        }
        return stack.pop();
    }
}