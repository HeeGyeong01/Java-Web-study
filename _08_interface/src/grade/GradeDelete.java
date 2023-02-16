package grade;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class GradeDelete implements Grade{
    //arrayList의 데이터가 아니라 주소를 전달 받는 것.
    public void execute(ArrayList<GradeDTO> arrayList){

        Scanner scan = new Scanner(System.in);
        System.out.print("삭제할 이름 입력: ");
        String name = scan.nextLine();

        boolean flag = false;
        /** remove하면 지워진 앞으로 밀리며 빈칸이 채워지면서 인덱스가 바뀐다.
         *  그러나 가리키는 칸은 같으므로 -> 이 명령문은 에러가 난다.
        for (GradeDTO arr : arrayList) {
            if (arr.getName().equals(name)) {
                flag = true;
                arrayList.remove(arr);
            }
        }**/

        //Iterator를 사용하면 항목을 꺼내고 다음으로 이동한다.
        //앞으로 밀리며 빈칸이 채워지지 않는다.
        Iterator<GradeDTO> it = arrayList.iterator();
        while(it.hasNext()){
            GradeDTO gradeDTO = it.next(); //항목을 꺼내 버퍼에 저장함.
            if(gradeDTO.getName().equals(name)){
                it.remove(); //it.next()가 반환하는 항목을 지운다.
                flag = true;
            }

        }

        if(flag == false) System.out.println("회원의 정보가 없습니다");
        else{
            System.out.println("삭제하였습니다");
        }
    }
}
