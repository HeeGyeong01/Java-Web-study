package class_;

class This {
    private int b;
    private static int c;

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
        //this를 이용하여 클래스의 변수인지, setB()함수의 변수인지 구분할 수 있다
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        This.c = c;
    }
}

public class ThisMain {

    private int a; //필드

    public static void main(String[] args) {
        ThisMain tm = new ThisMain();
        tm.a = 10;
        System.out.println("a = " + tm.a);

        This th = new This();
        th.setB(20);
        System.out.println("b = " + th.getB());

        th.setC(30);
        System.out.println("b = " + th.getC());

    }
}
