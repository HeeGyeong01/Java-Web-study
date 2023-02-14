package grade;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeUpdate implements Grade{
    public void execute(ArrayList<GradeDTO> arrayList){
        Scanner scan = new Scanner(System.in);
        System.out.print("번호 입력: ");
        int no = scan.nextInt();

        boolean check = false;
        for(GradeDTO arr: arrayList){
            if(arr.getNo() == no) {
                check = true;
                //번호에 해당하는 데이터 출력 후 수정함.
                System.out.println("번호   이름   국어   영어   수학    총점   평균");
                System.out.println(arr);

                System.out.print("수정할 이름 입력: ");
                String name = scan.nextLine();
                System.out.print("수정할 국어 입력: ");
                int kor = scan.nextInt();
                System.out.print("수정할 영어 입력: ");
                int eng = scan.nextInt();
                System.out.print("수정할 수학 입력: ");
                int math = scan.nextInt();

                arr.setName(name);
                arr.setKor(kor);
                arr.setEng(eng);
                arr.setMath(math);

                System.out.println("수정하였습니다");


            }
        }

        if(check == false){ //입력한 번호가 없을 때
            System.out.println("잘못된 번호입니다");
        }





    }
}
