package exception_;

import java.util.Scanner;

public class ExceptionMain {
    public static void main(String[] args) { //apple과 bird 넣어줌;
        System.out.println(args[0]);
        System.out.println(args[1]);

        try {
            int num1 = Integer.parseInt(args[0]);

            Scanner scan = new Scanner(System.in);
            System.out.print("숫자 입력: ");
            int num2 = scan.nextInt();

            System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));

        }catch(NumberFormatException e){
            System.out.println("반드시 숫자 형식으로 입력하세요");
            e.printStackTrace();
        }catch(ArithmeticException e){
            System.out.println("0으로 나눌 수 없습니다");
        }finally{
            System.out.println("무조건 실행함");
        }
    }
}
