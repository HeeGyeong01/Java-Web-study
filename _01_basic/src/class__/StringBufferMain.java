package class__;

import java.util.Scanner;

public class StringBufferMain {
    public static void input() {
        System.out.print("원하는 단을 입력 : ");
        int dan = new Scanner(System.in).nextInt();
        output(dan);
    }

    public static void output(int dan) {
        StringBuffer buffer = new StringBuffer();

        for(int i = 1; i <= 9; i++) {
            //System.out.printf("%d*%d=%d\n", dan, i, dan * i);
            buffer.append(dan);
            buffer.append("*");
            buffer.append(i);
            buffer.append("=");
            buffer.append(dan * i);
            System.out.println(buffer.toString()); // StringBuffer -> String 변환.
            buffer.delete(0, buffer.length()); //지금까지의 문자열 다 지움.
        }
    }

    public static void main(String[] args) {
        input();

    }
}
