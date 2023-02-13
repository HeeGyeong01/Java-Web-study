package inheritance;

class Test{

}

class Sample{

    @Override
    public String toString(){
        return getClass()+ "/This is Sample Class"; //getclass()는 상위클래스(Object)에 정의된 메소드.
    }

}

public class ObjectMain {
    public static void main(String[] args){
        Test t = new Test();
        System.out.println("객체 t = "+ t); //패키지명.클래스명@해시코드
        System.out.println("객체 t = "+ t.toString()); //부모 클래스인 Object에 있는 toString()메소드가 호출됨.
        System.out.println("객체 t = "+ t.hashCode()); //부모 클래스인 Object에 있는 hashCode()메소드가 호출됨.

        System.out.println(new Sample().toString()); //자식 클래스에서 오버라이딩 된 메소드 호출됨.



    }
}
