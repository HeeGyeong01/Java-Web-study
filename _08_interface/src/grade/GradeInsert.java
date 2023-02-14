package grade;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeInsert implements Grade{
    public void execute(ArrayList<GradeDTO> arrayList){
        Scanner scan = new Scanner(System.in);

        System.out.print("번호 입력: ");
        int no = scan.nextInt();
        System.out.print("이름 입력: ");
        String name = scan.next();
        System.out.print("국어 입력: ");
        int kor = scan.nextInt();
        System.out.print("영어 입력: ");
        int eng = scan.nextInt();
        System.out.print("수학 입력: ");
        int math = scan.nextInt();

        GradeDTO gradeDTO = new GradeDTO(no, name, kor, eng, math);
        gradeDTO.calc();
        arrayList.add(gradeDTO);

        System.out.println("입력을 완료했습니다.");

    }
}
