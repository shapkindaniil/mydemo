
import java.util.ArrayList;
import java.util.Scanner;

;


public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение [\"a\" + \"b\", \"a\" - \"b\", \"a\" * x, \"a\" / x] где a и b - строки а x - число  от 1 до 10 включительно  + Enter ");
        char[] uchar  = new char[40];
        ArrayList<String> strBlock00 = new ArrayList<>(10);
        Scanner scanner = new Scanner(System.in);
        String string = scanner.nextLine();
        char oper;
        int num1 = 0;
        int num2 = 0;
        if (num1 > 10 || num2 > 10) {
           throw new Exception("должен принимать на вход числа от 1 до 10 включительно, не более");
        }
        String[] data = new String[40];
        if (string.contains(" + ")) {
            data = string.split(" \\+ ");
            oper = '+';
        } else if (string.contains(" - ")) {
            data = string.split(" - ");
            oper = '-';
        } else if (string.contains(" * ")) {
            data = string.split(" \\* ");
            oper = '*';
        } else if (string.contains(" / ")) {
            data = string.split(" / ");
            oper = '/';
        }   else
            throw new Exception("Некорректный знак действия");


        if (oper == '*' || oper == '/') {
            if (data[1].contains("\"")) throw new Exception("Строчку можно делить или умножать только на число");
        }
        for (int i = 0; i < data.length; i++) {
            data[i] = data[i].replace("\"", "");
        }

        if (oper == '+') {
            printIn(data[0] + data[1]);
        } else if (oper == '*') {
            int multiplier = Integer.parseInt(data[1]);
            String result = "";
            for (int i = 0; i < multiplier; i++) {
                result+=data[0];
            }
            printIn(result);
        } else if (oper == '-') {
            int index = data[0].indexOf(data[1]);
            if(index == -1){
                printIn(data[0]);
            }else{
                String result = data[0].substring(0, index);
                result+=data[0].substring(index+data[1].length());
                printIn(result);
            }
        }else{
            int newLen = data[0].length()/Integer.parseInt(data[1]);
            String result = data[0].substring(0,newLen);
            printIn(result);
        }


    }
    static void printIn(String text){
        System.out.println("\""+text+"\"");
    }
}















