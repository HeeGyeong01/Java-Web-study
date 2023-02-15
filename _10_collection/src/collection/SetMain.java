package collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SetMain {
    public static void main(String[] args){
        Set<String> set = new HashSet<String>();
        //Set은 ArrayList와 달리 요소의 중복 허용하지 않고 순서 없이 저장한다.

        //Map<Key, Vlaue>
        //Map은 value의 중복 허용
        Map<String, String> map = new HashMap<String, String>();
        map.put("book001", "겨울왕국");
        map.put("book002", "엘칸토");

    }
}
