package constructor;

public class ConstructorMain {
    private int age;
    private String name;

    public ConstructorMain() { //default 생성자
        System.out.println("default 생성자");
        System.out.println(this); //constructor.ConstructorMain@5594a1b5
        //this는 자신이 속해있는 클래스의 참조값을 갖고 있다
    }

    public ConstructorMain(int age) {
        this.age = age;
    }

    public ConstructorMain(String name) {
        //오버로드된 다른 생성자를 호출(생성자 블록의 제일 처음에 와야 함)
        this(25);
        //생성자 오버로딩(매개변수의 타입/개수가 다름)
        System.out.println("매개변수 1개 생성자");
        this.name = name;
    }

    public static void main(String[] args) {
        ConstructorMain con = new ConstructorMain();
        System.out.println(con.name + "\t" + con.age);
    }
}
