package class__;

import java.util.StringTokenizer;

public class Token {
    public static void main(String[] args) {
        String str = "학원,,집,게임방";

        StringTokenizer st = new StringTokenizer(str, ",");
        System.out.println("토큰 개수 = " + st.countTokens()); // =>3 비어있는 것 계산 안함.

        while(st.hasMoreTokens()) { //남아있는 토큰이 있는지.
            System.out.println(st.nextToken()); //현재 토큰을 꺼내고 다음 토큰으로 이동함.
        }
        //학원
        //집
        //게임방

        String[] arr = str.split(",");
        for(String data : arr) {
            System.out.println(data);
        }
        //학원
        //
        //집
        //게임방

        //=> split(",")은 StringTokenizer와 달리 빈 데이터를 제외하지 않는다.

    }
}
