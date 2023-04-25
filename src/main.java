import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int number;
    static char operation;
    static String result;

    public static void main(String[] args) {
        System.out.println("Введите выражение [\"a\" + \"b\", \"a\" - \"b\", \"a\" * x, \"a\" / x] где a и b - строки а x - число  от 1 до 10 включительно  + Enter ");
        String userInput = scanner.nextLine();
        char[] uchar = new char[40];
        ArrayList<String> strBlock00 = new ArrayList<>(10);
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


        String[] blocks = userInput.split("[+-/*\"]");


        if (blocks.length == 5) {
            String st00 = blocks[0];
            String st01 = blocks[1];
            String st02 = blocks[2];
            String st03 = blocks[3];
            String st04 = blocks[4];
            System.out.println("-" + st00 + "-");
            System.out.println("-" + st01 + "-");
            System.out.println("-" + st02 + "-");
            System.out.println("-" + st03 + "-");
            System.out.println("-" + st04 + "-");
            System.out.println(Arrays.toString(blocks));
            System.out.println(operation);
            result = calculated(st01, st04, operation);
            System.out.println(result);
        } else {
            String st01 = blocks[1];
            String st03 = blocks[3];
            System.out.println("-" + st01 + "-");
            System.out.println("-" + st03 + "-");
            System.out.println(Arrays.toString(blocks));
            System.out.println(operation);
            number = Integer.parseInt(st03);
            result = calculated(st01, number, operation);
            System.out.println(result);

        }


    }


    public static String calculated(String num1, String num2, char op) {

        switch (op) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                int resultA = num1.length() - num2.length();
                result = num1.substring(0, resultA);
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

    public static String calculated(String num1, int num, char op) {

        switch (op) {
            case '+':
                System.out.println("Неверный знак операции + (введите * или /)");

                break;
            case '-':
                System.out.println("Неверный знак операции - (введите * или /)");
                break;
            case '*':
// 159  При умножении строки на число выводит правильный ответ но впереди null ("a" * 5 = nullaaaaa)?
                for (int u = 0; u < num; u++) {
                    result = result + num1;
                }
                break;
            case '/':
                try {
                    int resultB = num1.length() / num;
                    result = num1.substring(0, resultB);
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    System.out.println("Only integer non-zero parameters allowed");
                    break;
                } finally {
                    if (num1.length() < num) {
                        System.out.println("Делимое меньше делителя");
                    }
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return result;
    }
}
