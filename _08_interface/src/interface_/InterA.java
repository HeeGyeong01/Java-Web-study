package interface_;

public interface InterA {
    //변수 올 수 없다. 상수만 온다.
    public static final String NAME = "이희경";
    public int AGE = 25; //상수밖에 못 오므로 static final 키워드 생략할 수 있음.

    //추상 메소드만 가질 수 있다.
    public  abstract  void aa();
    public void bb(); //추상 메소드밖에 못 오므로 abstract 키워드 생략할 수 있음.
}
