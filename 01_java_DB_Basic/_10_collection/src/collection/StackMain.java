package collection;

import java.util.Stack;
import static java.lang.System.out; 
//static인 out을 import 해줘서 out.println()으로 쓸 수 있게 해줌

public class StackMain {
    public static void main(String[] args){
        String[] groupA = {"멕시코", "쿠웨이트", "사우디", "한국"};

        Stack<String> stack = new Stack<String>();

        for(int i = 0; i < groupA.length; i++) stack.push(groupA[i]);

        while(!stack.isEmpty()){
            out.println(stack.pop());
        }

    }
}
