package basic;

public class MethodTest01 {

    public static void main(String[] args) {
        //max() -> 명령문을 이렇게 적으면 MethodTest 클래스 안에서 찾으므로 실행되지 않는다.
        int big = Math.max(25, 36); //java.lang 패키지 안에 있는 Math 클래스.
        System.out.println(big);

        int small = Math.min(25, 36);
        System.out.println(small);

        String binaryString = Integer.toBinaryString(250); //2진수로 변환함
        System.out.println(binaryString);
    }

}

