package grade;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class GradeSort implements Grade{

    public void menu(ArrayList<GradeDTO> arrayList){
        Scanner scan = new Scanner(System.in);
        int num;

        while(true) {
            System.out.println("************************");
            System.out.println("1. 총점으로 내림차순");
            System.out.println("2. 이름으로 오름차순");
            System.out.println("3. 이전 메뉴");
            System.out.println("************************");
            System.out.print("번호: ");
            num = scan.nextInt();

            if(num == 3) break;

            Comparator<GradeDTO> com = null;

            //총점으로 내림차순
            if(num == 1) {
                com = new Comparator<GradeDTO>() {
                    @Override
                    public int compare(GradeDTO dto1, GradeDTO dto2) {
                        if(dto1.getTotal() < dto2.getTotal()) return 1;
                        else if(dto1.getTotal() > dto2.getTotal()) return -1;
                        else return 0;
                    }
                };



                //이름으로 오름차순
            } else if(num == 2) {
                //GradeDTO 클래스에 Comparable 인터페이스를 implements해서
                //compareTo()를 오버라이딩 하는 대신
                //Comparator 인터페이스를 implements한 클래스를 생성(=익명 객체)
                // 메서드가 하나뿐인 함수형 인터페이스
                com = new Comparator<GradeDTO>() {
                    @Override
                    public int compare(GradeDTO dto1, GradeDTO dto2) {
                        return dto1.getName()
                            .compareTo(dto2.getName()); //이름 오름차순

                    }
                };



                //범위 밖의 숫자를 입력한 경우
            }else{
                System.out.println("1~3번 까지만 입력하세요");
            }

            Collections.sort(arrayList, com);

            //단발성으로 객체 한번 만들고 버림.
            new GradeList().execute(arrayList);
        }

    }

    @Override
    public void execute(ArrayList<GradeDTO> arrayList){
        this.menu(arrayList);
    }
}