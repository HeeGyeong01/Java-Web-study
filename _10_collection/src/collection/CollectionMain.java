package collection;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class CollectionMain {
    public static void main(String[] args){
        //interface를 implements 하면 그 인터페이스의 추상메소드를 모두 오버라이딩 해야 함.
        //-> 인터페이스를 implements 하지 않고 아래처럼 오버라이딩 된 클래스(ArrayList)를 생성한다.
        Collection coll = new ArrayList();
        //coll은 collection을 가리킨다.->get()을 호출할 수 없다 =>Iterator 사용함.
        //get() 메소드는 ArrayList 클래스 안에 있기 때문.

        coll.add("호랑이");
        coll.add(25);
        coll.add(43.8);

        //Collection과 Iterator는 인터페이스이다.
        Iterator iter = coll.iterator();
        //iter.hasNext() ->꺼낼 항목이 있으면 true 리턴함
        //iter.next() ->항목 꺼내고 다음 항목을 가리킴
        while(iter.hasNext()){
            System.out.println(iter.next());
        }

    }
}
