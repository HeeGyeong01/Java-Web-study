package operator;

import java.util.Scanner;

public class Operator02 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("정수를 입력하시오: ");
        int num = scan.nextInt();

        String result = (num%2 == 0) ? "짝수" : "홀수";
        System.out.println(result);

        String result2 = (num%2 == 0 && num%3==0) ? "공배수이다" : "공배수가 아니다";
        System.out.println(result2);

    }
}
