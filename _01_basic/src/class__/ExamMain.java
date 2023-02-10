package class__;

import java.util.Scanner;

public class ExamMain {
    public static void main(String[] args){
        System.out.print("인원수 입력: ");
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        scan.nextLine();

        Exam[] arr = new Exam[num];

        for(int i= 0; i< num; i++) {
            System.out.print("\n이름 입력: ");
            String name = scan.nextLine();
            System.out.print("답 입력: ");
            String answer = scan.nextLine();
            arr[i] = new Exam(name, answer);
        }

        //print
        System.out.println("\n이름\t\t1 2 3 4 5\t점수");
        for(int i= 0; i< num; i++) {
            System.out.printf("%s\t%s\t%d\n", arr[i].getName(), arr[i].getOx(), arr[i].getScore());
        }

    }
}
