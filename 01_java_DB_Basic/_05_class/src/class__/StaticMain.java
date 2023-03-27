package class__;

class StaticTest{
    private int a; //필드, 초기화, 인스턴스 변수
    private static int b; //필드, 클래스 변수

    public StaticTest() {
        System.out.println("기본 생성자");
        this.a = 5;
    }

    static{
        System.out.println("초기화 영역");
        //this.b = 7; //static 영역에서 this.에 접근할 수 없다.
        //static에서 this.을 써도 현재 속한 클래스에 접근할 수 없다.
        //static은 클래스 소속이 아니기 때문.

        StaticTest.b = 7; //this. 대신 이렇게 써줘야 함.
    }

    public void calc(){
        a++;
        b++;
    }

    public void print(){
        System.out.println(a +"/"+ b);
    }
    
    public static void output(){
        System.out.println("static method...");
    }
}

public class StaticMain {

    public static void main(String[] args){
        StaticTest st = new StaticTest();
        st.calc();
        st.print();
        //초기화 영역
        //기본 생성자
        //6/8
        
        StaticTest.output(); //
        st.output();

    }
}
