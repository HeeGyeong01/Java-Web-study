package collection;

import java.util.Iterator;
import java.util.Vector;

public class VectorMain {
    public static void main(String[] args){
        Vector<String> v = new Vector<String>();

        System.out.println("벡터 크기 = " + v.size()); //0
        System.out.println("벡터 용량 = " + v.capacity()); //기본 용량은 10이다.

        System.out.println("\n항목 추가");
        for(int i = 0; i < v.capacity(); i++){;
            v.add(i + ""); //i를 String형으로 바꿈
            System.out.print(v.get(i));

        };

        System.out.println("마지막 항목 삭제");

        //--------------------------------------------------
        Iterator<String> it = v.iterator(); //인터페이스를 메소드 이용해서 사용하는 예
        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }


    }
}
