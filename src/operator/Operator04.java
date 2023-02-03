package operator;

public class Operator04 {

    public static void main(String[] args) {
        boolean a = 25 > 36;
        System.out.println("a = " + a);
        System.out.println("a = " + !a);

        String b = "apple"; //literal 생성,
        // b는 "apple"이 아니라 "apple"이 저장되어 있는 메모리의 주소를 가지고 있다.
        String c = new String("apple"); //String은 원래 클래스이기에 이렇게 생성해도 실행된다.

        String result = b == c ? "같다" : "다르다";
        System.out.println("b == c : " + result);

        String result2 = b.equals(c) ? "같다" : "다르다"; //주소가 다르다
        System.out.println("b.equals(c) : " + result2); //저장하고 있는 값은 같다
    }
}
