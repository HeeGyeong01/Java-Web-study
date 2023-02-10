package inheritance;

public class SubMain extends Super {
    private String name;
    private int age;

    SubMain(){
        //기본 생성자
    }

    SubMain(String name, int age, double weight, double height){
        this.name = name;
        this.age = age;
        super.weight = weight; //부모 클래스의 필드에 저장함.
        this.height = height; //부모 클래스의 필드에 저장함.
    }

    public void output(){
        System.out.println("이름 = " + name);
        System.out.println("나이 = " + age);
        this.disp(); //부모 클래스의 메소드에 this.로 접근한다.

    }

    public static void main(String[] args){
        //main은 static이기 때문에 this. 못 쓴다.
        SubMain aa = new SubMain("이희경", 25, 55, 166);
        aa.disp(); //부모클래스의 메소드 호출

        Super bb = new SubMain("코난", 13, 53.5, 156.6);
        //bb.output(); ->error 뜸.
        bb.disp();

    }
}
//자식 클래스 (메모리) 생성할 때
//부모클래스와 자식클래스 둘 다 생성한다.
//->부모의 기본생성자 무조건 불러들임.
//부모클래스에 매개변수 하나 필요로하는 생성자 하나만 있으면
//부모클래스의 기본 생성자가 없다고 에러 뜬다.
