package compute;

public class ComputeMain {
    public static void main(String[] args){
        ComputerService com = new ComputerService();
        com.menu();
        System.out.println("프로그램을 종료합니다.");
    }
}
