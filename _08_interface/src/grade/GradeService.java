package grade;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeService {
    private ArrayList<GradeDTO> arrayList = new ArrayList<GradeDTO>();

    public void menu() {
        Scanner scan = new Scanner(System.in);
        Grade grade = null;
        int num;

        while(true) {
            System.out.println();
            System.out.println("**********************");
            System.out.println("       1. 입력");
            System.out.println("       2. 출력");
            System.out.println("       3. 수정");
            System.out.println("       4. 삭제");
            System.out.println("       5. 정렬");
            System.out.println("       6. 끝(나가기)");
            System.out.println("**********************");
            System.out.print("  원하는 메뉴 입력: ");

            num = scan.nextInt();

            if(num == 6) break;

            if(num == 1) {
                grade = new GradeInsert(); //부모 = new 자식();
            } else if(num == 2) {
                grade = new GradeList();
            } else if(num == 3) {
                grade = new GradeUpdate();
            } else if(num == 4) {
                grade = new GradeDelete();
            }else if(num == 5) {
                grade = new GradeSort();
            }else{
                System.out.println("1~6번 까지만 입력하세요");
                continue;
            }

            grade.execute(arrayList);

        }
    }
}
