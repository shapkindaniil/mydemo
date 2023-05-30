import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;


public class Main {
    public static void main( String input) {
        int len = input.length();
        ArrayList list1 = new ArrayList();
        ArrayList list2 = new ArrayList();
        for (int i = 0; i < len; i++) {
            if ((input.charAt(i) != '+') && (input.charAt(i) != '-')) {
                // check if the number is double-digit
                if ((i + 1 <= len - 1)) {
                    if ((input.charAt(i + 1) != '+')&& (input.charAt(i + 1) != '-')) {
                        String temp = "";
                        temp = temp + input.charAt(i) + input.charAt(i + 1);
                        int tempToInt = Integer.parseInt(temp);
                        list1.add(tempToInt);
                    }
                    // add single digit number
                    list1.add(input.charAt(i) - '0');
                }
            } else {
                // adding the symbols
                list2.add(input.charAt(i));
            }
        }
        int result = 0;
        result = result + (int) list1.get(0);
        for (int t = 0; t < list2.size(); t++) {
            char oper = (char) list2.get(t);
            if (oper == '+') {
                result = result + (int) list1.get(t + 1);

            } else if (oper == '-') {
                result = result - (int) list1.get(t + 1);
            }
        }
        return result;
    }

    }



