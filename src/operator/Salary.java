package operator;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Salary {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat();

        System.out.print("이름 입력 : ");
        String name = scan.nextLine();
        System.out.print("직급 입력 : ");
        String rank = scan.nextLine();
        System.out.print("기본급 입력 : ");
        double basePay = scan.nextDouble();
        System.out.print("수당 입력 : ");
        double extraPay = scan.nextDouble();

        double total = basePay + extraPay;
        double taxrate = 0;

        if (total >= 5000000) {
            taxrate = 0.03;
        } else if (total >= 3000000) {
            taxrate = 0.02;
        } else {
            taxrate = 0.01;
        }// taxrate = total>=5000000 ? 0.03 : total>=3000000 ? 0.02 : 0.01;

        double tax = total * taxrate;
        double Salary = total - tax;

        System.out.println("*** " + name + rank + " 월급 ***");
        System.out.println("기본급 : " + df.format(basePay) + "원");
        System.out.println("수당 : " + df.format(extraPay) + "원");
        System.out.println("합계 : " + df.format(total) + "원");
        System.out.println("세금 : " + df.format(tax) + "원");
        System.out.println("월급 : " + df.format(Salary) + "원");

    }

}
