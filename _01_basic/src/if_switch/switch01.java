package if_switch;

import java.util.Scanner;

public class switch01 {
    public static void main(String[] args) {
        System.out.print("a의 값 : ");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();

        System.out.print("b의 값 : ");
        Scanner scan1 = new Scanner(System.in);
        int b = scan1.nextInt();

        System.out.print("연산자(+-*/)를 입력 : ");
        Scanner scan2 = new Scanner(System.in);
        String operator = scan2.nextLine();

        double result = 0;
        switch (operator) {
            case ("+"):
                result = a + b;
                break;
            case ("-"):
                result = a - b;
                break;
            case ("*"):
                result = a * b;
                break;
            case ("/"):
                result = a / b;
                break;
            default:
                System.out.println("연산자 error");
        }
        System.out.println(a + operator + b + " = " + result);
    }
}
