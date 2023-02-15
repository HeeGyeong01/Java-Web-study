package grade;

import java.util.ArrayList;
import java.util.Scanner;

public class GradeDelete implements Grade{
    public void execute(ArrayList<GradeDTO> arrayList){

        Scanner scan = new Scanner(System.in);
        System.out.print("삭제할 이름 입력: ");
        String name = scan.nextLine();

        boolean flag = false;
        for (GradeDTO arr : arrayList) {
            if (arr.getName().equals(name)) {
                flag = true;
                arrayList.remove(arr);
            }
        }
        if(flag == false) System.out.println("회원의 정보가 없습니다");
        else{
            System.out.println("삭제하였습니다");
        }
    }
}
