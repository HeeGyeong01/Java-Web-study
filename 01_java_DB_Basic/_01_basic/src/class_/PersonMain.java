package class_;

class Person {
    String name; //필드, 초기값
    int age;

    public void setName(String n) { //메소드 구현
        name = n;
    }

    public void setAge(int n) {
        age = n;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

//Person(클래스형 변수, 객체)

public class PersonMain {
    public static void main(String[] args) {
        Person a; //객체 선언
        a = new Person(); //생성

        System.out.println(a); //class_.Person@6a5fc7f7
        //패키지명.클래스명@해쉬값

        //a.name = "이희경";
        a.setName("이희경");
        //a.age = 25;
        a.setAge(25);

    }
}
