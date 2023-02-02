package basic;

class Test {

    int a = 10;
}

public class Variable02 {

    int a; //필드
    static int c;

    public static void main(String[] args) {
        int a = 5; //지역변수

        Variable02 v = new Variable02(); //메모리 생성
        System.out.println("객체 = " + v); // 객체 =  basic.Variable02@3498ed ->패키지명.클래스명@16진수해시코드값
        System.out.println("필드 a = " + v.a); // 필드 a = 0

        System.out.println(c); //0 ->Variable02 클래스 영역 안이므로 Variable02를 안붙여도 실행 되는 것.
        System.out.println(Variable02.c); // 0

        Test t = new Test();
        System.out.println(t); //basic.Test@73f792cf

    }
}
