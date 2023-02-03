package if_switch;

import java.util.Scanner;

public class If02 {
    public static void main(String[] args) {
        System.out.print("a의 값 : ");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();

        System.out.print("b의 값 : ");
        Scanner scan1 = new Scanner(System.in);
        int b = scan1.nextInt();

        System.out.print("c의 값 : ");
        Scanner scan2 = new Scanner(System.in);
        int c = scan2.nextInt();

        float avg = (a + b + c) / 3;
        if (avg >= 60) {
            if (a < 40 || b < 40 || c < 40) {
                System.out.println("과락으로 불합격");
            } else {
                System.out.println("합격");
            }
        } else if (avg >= 40) {
            System.out.println("불합격");
        }
    }
}
