package nested;

public class AbstractMain {

    public static void main(String[] args){
        AbstractTest at = new AbstractTest() { //익명 inner 클래스(한 번 쓰고 버림)
            @Override
            public void setName(String name) { //메소드의 구현부
                //this.name = name;
            }
        };
        //함수의 구현부{}를 가지는 건 클래스뿐이다.(추상메소드, 인터페이스는 못가짐)
        //위의 setName()은 구현부{}를 가지므로 새로운 클래스가 만들어진 것 임을 알 수 있다

        InterA in = new InterA(){
            public void aa(){}
            public void bb(){}
        };

        AbstractExam ae = new AbstractExam() {
            //원하는 메소드를 override 한다.
        };
    }
}
