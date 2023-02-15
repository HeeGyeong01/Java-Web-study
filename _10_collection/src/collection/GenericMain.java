package collection;

class GenericTest<T>{
    private T a;

    public T getA() {
        return a;
    }

    public void setA(T a) {
        this.a = a;
    }
}

public class GenericMain {
    public static void main(String[] args){
        GenericTest<String> aa = new GenericTest<String>();
        aa.setA("이희경");
        System.out.println("이름 = "+ aa.getA());

        GenericTest<Integer> bb = new GenericTest<Integer>();
        //GenericTest<int> bb = new GenericTest<int>(); Error! int 대신 Integer 써야 함
    }
}
