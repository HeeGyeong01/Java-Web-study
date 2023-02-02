package operator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Money {

    public static void main(String[] args) {
        int money = 5378;
        Scanner scan = new Scanner(System.in);
        System.out.println("돈 입력하기 : ");
        money = scan.nextInt();

        DecimalFormat df = new DecimalFormat();

        System.out.println("[실행결과]");
        System.out.println("현금 : " + df.format(money)); //천의 자리마다 Comma 붙여줌.
        System.out.println("천원 : " + money / 1000);
        System.out.println("백원 : " + (money % 1000) / 100);
        System.out.println("십원 : " + (money % 1000) % 100 / 10);
        System.out.println("일원 : " + money % 10);

    }
}
