package class__;

public class StringMain01 {
    public static void main(String[] args) {
        String a = "apple"; //literal 생성
        String b = "apple";

        String c = new String("apple");
        String d = new String("apple");

        System.out.println(a == b);      //true 참조값이 같다
        System.out.println(a.equals(b)); //true 문자열이 같다

        System.out.println(c == d);      //false 참조값은 다르다
        System.out.println(c.equals(d)); //true 문자열이 같다

    }
}
