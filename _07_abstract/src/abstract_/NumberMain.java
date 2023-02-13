package abstract_;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;

public class NumberMain {
    public static void main(String[] args){
        NumberFormat nf1 = new DecimalFormat(); //sub 클래스 이용하여 생성.
        NumberFormat nf2 = NumberFormat.getInstance();

        System.out.println(nf1.format(12345678.123));
        System.out.println(nf2.format(12345678.123)); //두 출력문의 결과 같음.


        NumberFormat nf3 = new DecimalFormat("#,###.00원");
        NumberFormat nf4 = NumberFormat.getInstance();
        nf4.setMaximumFractionDigits(2); //소수 이하 2째 자리

        //NumberFormat nf5 = DecimalFormat.getInstance(Locale.KOREA);
        NumberFormat nf5 = DecimalFormat.getCurrencyInstance(Locale.KOREA);

    }
}
