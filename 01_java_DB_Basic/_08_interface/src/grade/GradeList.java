package grade;

import java.util.ArrayList;

public class GradeList implements Grade{
    public void execute(ArrayList<GradeDTO> arrayList){
        System.out.println("번호   이름   국어   영어   수학    총점   평균");

        for(GradeDTO gradeDTO: arrayList){
            //arrayList.get(0)은 첫번째에 저장되어있는 GradeDTO 객체의 주소임.
            System.out.printf("%d\t%4s\t%4d\t%4d\t%4d\t%4d\t%4.2f\n",
                gradeDTO.getNo(),
                gradeDTO.getName(),
                gradeDTO.getKor(),
                gradeDTO.getEng(),
                gradeDTO.getMath(),
                gradeDTO.getTotal(),
                gradeDTO.getAvg()
                );
        }

        //gradeDTO에 toString()을 오버라이딩 해놓아서 아래와 같이 간단하게도 가능하다.
//        for(GradeDTO gradeDTO: arrayList){
//            System.out.println(gradeDTO);
//        }

    }
}
