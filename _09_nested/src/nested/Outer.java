package nested;

public class Outer {
    private String name;

    public void output(){
        //System.out.println(age); //Error 뜸.
        Inner in = new Inner();
        System.out.println(in.age); //안쪽의 클래스로 객체를 생성하면 접근 가능하다.

    }

    class Inner{ //Outer$Inner.class 생성됨.
        private int age;

        public void disp(){
            System.out.println("이름: "+ name + " 나이: " + age);
            //Inner 클래스 밖의 변수(필드) 사용할 수 있다.
            //Inner 클래스는 Outer 클래스를 상속(is-a)하고 있는게 아니라 가지고(has-a) 있는 것이다.
            //여기서 name은 Outer.this.name과 같다.
        }

    }
    public static void main(String[] args){
        Outer ou = new Outer();
        ou.name = "홍길동";
        System.out.println(ou.name);

        Outer.Inner in2 = ou.new Inner(); //Inner 클래스는 반드시 ou안에 만들어져야 한다.
        in2.age = 25;
        in2.disp();

        Outer.Inner in3 = ou.new Inner();
        in3.age = 30;
        in3.disp();

        Outer.Inner in4 = new Outer().new Inner();
//        in4.name = "코난"; Error 뜸
        in4.age = 35;
        in4.disp();



    }
}
