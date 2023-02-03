package for_;

import java.util.Scanner;

public class For06 {
    public static void main(String[] args) {
        //팩토리얼 구하기
        //1~10 사이의 숫자 입력
        System.out.print("숫자 입력 : ");
        int x = new Scanner(System.in).nextInt();

        int result = 1;
        String exp = "";
        for (int i = 1; i <= x; i++) {
            result *= i;
            exp += Integer.toString(i) + "*";
        }

        exp = exp.substring(0, exp.length() - 1);
        System.out.printf("%d! = %d (%s)", x, result, exp);


    }
}
