
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int number;
    static char operation;
    static String result = "";

    public static void main(String[] args) throws Exception {
        System.out.println("Введите выражение [\"a\" + \"b\", \"a\" - \"b\", \"a\" * x, \"a\" / x] где a и b - строки а x - число  от 1 до 10 включительно  + Enter ");
        String userInput = scanner.nextLine();
        operation = metodOperation(userInput);
        globalWork(userInput);
    }

    private static String globalWork(String userInput) throws Exception {
        String[] blocks = userInput.split("[+-/*\"]");
        if (blocks.length == 5) {
            String st01 = blocks[1];
            String st04 = blocks[4];
            result = calculated(st01, st04, operation);
            if (result.length() > 40) {
                String rez = result.substring(0, 40);
                System.out.println(rez + "...");
            } else {
                System.out.println(result);
            }
        } else {
            String st01 = blocks[1];
            String st03 = blocks[3];
            number = Integer.parseInt(st03);
            result = calculated(st01, number, operation);
            if (result.length() > 40) {
                String rez = result.substring(0, 40);
                System.out.println(rez + "...");
            } else {
                System.out.println(result);
            }

        }


        return userInput;
    }


    private static char metodOperation(String userInput) {
        char[] uchar = new char[40];
        for (int i = 0; i < userInput.length(); i++) {
            uchar[i] = userInput.charAt(i);
            if (uchar[i] == '+') {
                operation = '+';
            }
            if (uchar[i] == '-') {
                operation = '-';
            }
            if (uchar[i] == '*') {
                operation = '*';
            }
            if (uchar[i] == '/') {
                operation = '/';
            }
        }
        return operation;
    }


    public static String calculated(String num1, String num2, char op ) throws Exception {
        if (num1.length() > 10 || num1.length() > 10)
            throw new Exception("Калькулятор принимает на вход строки длинной не больше 10");
        if (num2.length() > 10 || num2.length() > 10)
            throw new Exception("Калькулятор принимает на вход строки длиной не больше10");
        if (Integer.parseInt(num1) < 1 || Integer.parseInt(num1) > 10)
            throw new Exception("Калькулятор принимает на вход числа от 1 до 10");
        if (Integer.parseInt(num2) < 1 || Integer.parseInt(num2) > 10)
            throw new Exception("Калькулятор принимает на вход числа от 1 до 10");
        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                int resA = num1.length() - num2.length();
                if (num1.length() == num2.length()) {
                    result = "";
                } else {
                    result = num1.substring(0, resA);
                }
                break;
            case '*':
                System.out.println("Неверный знак операции * (введите + или -)");
                break;
            case '/':
                System.out.println("Неверный знак операции / (введите + или -)");
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }


    public static String calculated(String num1, int num, char op) throws Exception {
        if (num1.length() > 10 || num1.length() > 10)
        throw new Exception("Калькулятор принимает на вход строки длинной не больше 10");
        switch (op) {
            case '+':
                System.out.println("Неверный знак операции + (введите * или /)");

                break;
            case '-':
                System.out.println("Неверный знак операции - (введите * или /)");
                break;
            case '*':
                for (int u = 0; u > num; u++) {
                    result = result + num;
                }
                break;
            case '/':
                try {
                    int resB = num1.length() / num;
                    if (num1.length() == num) {
                        result = "1";
                    } else {
                        result = num1.substring(0, resB);
                    }
                    System.out.println("Только целые числа");
                    break;
                } finally {
                    if (num1.length() < num) {
                        System.out.println("Делимое меньше делителя");
                    }
                }
            default:
                throw new Exception ("Не верный знак операции");
        }
        return result;
    }
}