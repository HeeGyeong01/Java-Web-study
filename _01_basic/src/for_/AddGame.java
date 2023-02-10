package for_;

import java.util.Scanner;

public class AddGame {
    public static void main(String[] args) {

        int count = 0;
        for (int i = 1; i <= 5; i++) {
            int a, b, answer_input;

            a = (int) (Math.random() * 90 + 10);
            b = (int) (Math.random() * 90 + 10);

            System.out.printf("[%d] %d+%d=", i, a, b);
            answer_input = new Scanner(System.in).nextInt();

            if (answer_input == a + b) {
                System.out.println("정답입니다! 참 잘했어요");
                count += 1;
            } else {
                System.out.println("오답입니다! 다시 생각해 보세요");
                System.out.printf("[%d] %d+%d=", i, a, b);
                answer_input = new Scanner(System.in).nextInt();

                if (answer_input == a + b) {
                    System.out.println("정답입니다! 참 잘했어요");
                    count += 1;
                } else {
                    System.out.println("이번에도 오답이군요..");
                }


            }
        }
        System.out.printf("당신은 총 %d문제를 맞추어서 %d점 입니다.", count, count * 20);

    }
}
