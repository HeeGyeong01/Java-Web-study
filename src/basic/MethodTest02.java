package basic;

import java.util.*;

public class MethodTest02 {

    public static void main(String[] args) {
        // 0 <= 난수 <= 1
        double a = Math.random();
        System.out.println(a);

        Random r = new Random();
        double b = r.nextDouble();
        System.out.println(b);

        int[] arr = new int[5]; //배열 생성
        int[] arr01 = {25, 13, 45, 30, 15}; //배열 생성&초기화

        Arrays.sort(arr01);  // 반환값 없음.
        System.out.println(Arrays.toString(arr01));

    }
}
