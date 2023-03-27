package exception_;

import java.util.Scanner;

public class ExceptionMain2 {
    public static void main(String[] args){

        Scanner scan = new Scanner(System.in);
        int x = 0;
        int y = 0;

        try {
            System.out.print("x 입력: ");
            x = scan.nextInt();
            System.out.print("y 입력: ");
            y = scan.nextInt();
        }catch (NumberFormatException e){
            System.out.println("숫자 형식으로 입력해주세요");
        }

        System.out.printf("%d의 %d승은 %d", x, y, (int)Math.pow(x, y));


    }
}
