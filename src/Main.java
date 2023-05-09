import java.util.Scanner;

public class Main {
    static String result;
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char operation;
        String[] information ;
            if (string.contains(" + ")) {
                information = string.split(" \\+ ");
                operation = '+';
            } else if (string.contains(" - ")) {
                information = string.split(" - ");
                operation = '-';
            } else if (string.contains(" * ")) {
                information = string.split(" \\* ");
                operation = '*';
            } else if (string.contains(" / ")) {
                information = string.split(" / ");
                operation = '/';
            } else {
                throw new Exception("Некорректный знак действия");
            }
            if (information.length <= 39) {
                String inf = result.substring(0,39);
                System.out.println(inf);
            } else if (information.length > 39) {
                String rez = result.substring(0,39);
                System.out.println(rez + "...");

            }
        if (operation == '*' || operation == '/') {
                if (information[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
            }
            for (int i = 0; i < information.length; i++) {
                information[i] = information[i].replace("\"", "");
            }

            if (operation == '+') {
                printIn(information[0] + information[1]);
            } else if (operation == '*')
            {
                int coefficient = Integer.parseInt(information[1]);
                String result = "";
                for (int i = 0; i < coefficient; i++) {
                    result += information[0];
                }
                printIn(result);
            } else if (operation == '-') {
                int index = information[0].indexOf(information[1]);
                if (index == -1) {
                    printIn(information[0]);
                } else {
                    String result = information[0].substring(0, index);
                    result += information[0].substring(index + information[1].length());
                    printIn(result);
                }
            } else {
                int Len = information[0].length() / Integer.parseInt(information[1]);
                String result = information[0].substring(0, Len);
                printIn(result);
            }


        }






     static void printIn(String text) {
        System.out.println("\"" + text + "\"");
    }
}