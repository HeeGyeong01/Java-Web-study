package inheritance;

enum Color{ //enum : 상수들의 집합체
    RED, GREEN, BLUE //앞에 public final static이 생략되어 있는 셈.
}

class Final{
    public final String FRUIT = "사과";
    public final String FRUIT2;

    public final static String ANIMAL = "기린";
    public final static String ANIMAL2 ;

    public Final(){
        FRUIT2 = "딸기"; //클래스에 우선 선언해 놓고 객체를 생성할 때 값 할당해줌.
    }

    static{
        System.out.println("static 초기화 영역");
        ANIMAL2 = "코끼리";
    }

}

public class FinalMain {
    public static void main(String[] args){
        final int A; //상수는 우선 선언하고 나중에 할당할 수 있다.
        A = 20;

        Final f = new Final();
        System.out.println(f.FRUIT);

        Final f2 = new Final();
        System.out.println(f2.FRUIT2);

        System.out.println(Final.ANIMAL);
        System.out.println(Final.ANIMAL2);

        System.out.println("빨강 = "+ Color.RED); //빨강 = RED
        System.out.println("빨강 = "+ Color.RED.ordinal()); //빨강 = 0
        System.out.println("초록 = "+ Color.GREEN.ordinal()); //초록 = 1

        for(Color data : Color.values()){
            System.out.println(data); //RED GREEN BLUE
        }

    }
}
