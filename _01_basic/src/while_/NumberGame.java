package while_;

import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        int answer = (int) (Math.random() * 100 + 1);
        System.out.printf("1~100 사이의 숫자를 맞추세요! (%d)\n\n", answer);
//        Scanner scan = new Scanner(System.in);

        int count = 0;

        while (true) {
            System.out.print("숫자 입력: ");
            int inputNum = new Scanner(System.in).nextInt();
            count++;

            if (inputNum == answer) {
                System.out.printf("딩동댕! %d번만에 맞추셨습니다.", count);
                break;
            } else if (inputNum < answer) {
                System.out.println(inputNum + "보다 큰 숫자입니다.\n");
            } else if (inputNum > answer) {
                System.out.println(inputNum + "보다 작은 숫자입니다.\n");
            }
        }

    }
}
