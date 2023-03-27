package constructor;

public class VarArgs {
    public VarArgs() { //기본 생성자
    }

    public int sum(int... arr) { //전달된 매개변수가 arr배열의 요소로 저장됨.
        int sum = 0;
        for(int element : arr) {
            sum += element;
        }
        return sum;
    }

    public static void main(String[] args) {
        VarArgs va = new VarArgs();

        System.out.println("합 = " + va.sum(10, 20));
        System.out.println("합 = " + va.sum(10, 20, 30));
        System.out.println("합 = " + va.sum(10, 20, 40));
    }
}
