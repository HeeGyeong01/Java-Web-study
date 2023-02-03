package if_switch;

import java.util.Scanner;

public class If01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("숫자 입력: ");
        int a = scan.nextInt();

        if (a >= 50) {
            System.out.println(a + "는 50보다 크거나 같다");
        }
        System.out.println("50보다 작다");

        if (false) {
            if (true) {
                System.out.println("a");
            } else {
                System.out.println("B");
            }
        }
        System.out.println("c");
    }
}
