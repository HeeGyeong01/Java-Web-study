package for_;

import java.util.Scanner;

public class For04 {
    public static void main(String[] args) {
        //제곱 계산
        System.out.print("x값 입력 : ");
        int x = new Scanner(System.in).nextInt();

        System.out.print("y값 입력 : ");
        int y = new Scanner(System.in).nextInt();

        int result = 1;
        for (int i = 1; i <= y; i++) {
            result *= x;
        }

        System.out.printf("%d의 %d승은 %d", x, y, result);
    }
}
