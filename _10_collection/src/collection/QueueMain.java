package collection;

import static java.lang.System.out;

import java.util.LinkedList;

public class QueueMain {
    public static void main(String[] args){
        String[] item = {"멕시코", "쿠웨이트", "사우디", "한국"};

        LinkedList<String> que = new LinkedList<String>();

        for(String str: item) que.offer(str);

        out.println("que의 크기: "+ que.size() + "\n");
        String data = "";

        while((data = que.poll()) != null){
            out.println(data + "삭제!");
            out.println("que의 크기: "+ que.size() + "\n");
        }

    }
}
