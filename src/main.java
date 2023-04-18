
import java.util.Scanner;

public class Main {
    

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char step;
        String[] value;
        if (string.contains(" + ")) {
            value = string.split(" \\+ ");
            step = '+';
        } else if (string.contains(" - ")) {
            value = string.split(" - ");
            step = '-';
        } else if (string.contains(" * ")) {
            value = string.split(" \\* ");
            step = '*';
        } else if (string.contains(" / ")) {

            value = string.split(" / ");
            step = '/';
        } else {
            throw new Exception("Некорректный знак действия");
        }
        if (step == '*' || step == '/') {
            if (value[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        }
        for (int i = 0; i < value.length; i++) {
            value[i] = value[i].replace("\"", "");
        }
                 if(step =='+') {
                printIn(value[0] + value[1]);
            } else if(step =='*')

            {
                int a = Integer.parseInt(value[1]);
                String result = "";
                for (int i = 0; i < a; i++) {
                    result += value[0];
                }
                printIn(result);
            } else if(step =='-')

            {
                int b = value[0].indexOf(value[1]);
                if (b == -1) {
                    printIn(value[0]);
                } else {
                    String result = value[0].substring(0, b);
                    result += value[0].substring(b + value[1].length());
                    printIn(result);
                }
            }else

            {
                int c = value[0].length() / Integer.parseInt(value[1]);
                String result = value[0].substring(0, c);
                printIn (result);
            }


        }



    static void printIn(String text){
        System.out.println("\""+text+"\"");
        }
    }












