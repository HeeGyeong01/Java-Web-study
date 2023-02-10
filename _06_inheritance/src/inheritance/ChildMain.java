package inheritance;

public class ChildMain extends Super {

    private String name;
    private int age;

    ChildMain(){
        //기본 생성자
    }

    ChildMain(String name, int age, double weight, double height){
        this.name = name;
        this.age = age;
        super.weight = weight; //부모 클래스의 필드에 저장함.
        this.height = height; //부모 클래스의 필드에 저장함.
    }

    public void disp(){
        System.out.println("이름 = " + name);
        System.out.println("나이 = " + age);
        super.disp(); //부모의 메소드가 아닌 현재 메소드를 호출함.
    }

    public static void main(String[] args){
        ChildMain aa = new ChildMain("홍길동", 25, 73, 182.6);
        aa.disp();
    }

}
