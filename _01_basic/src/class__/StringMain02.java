package class__;

import java.util.Scanner;

public class StringMain02 {
    public static void main(String[] args) {
        while(true) {
            System.out.println("빈칸 없이 문자열을 입력하세요/ 대소문자 구분 없이 바꿉니다.");
            System.out.print("문자열 입력: ");
            String str = new Scanner(System.in).nextLine();
            System.out.print("현재 문자열 입력: ");
            String which = new Scanner(System.in).nextLine();
            System.out.print("바꿀 문자열 입력: ");
            String change = new Scanner(System.in).nextLine();

            str = str.toLowerCase();
            String changedStr = str.replace(which, change);

            int count = 0;
            int temp = -1;
            int detectedIdx =  -1;

            for(int i = 0; i < str.length(); i++) {
                detectedIdx = str.indexOf(which, i);
                if(detectedIdx != temp && detectedIdx != -1) {
                    count++;
                    temp = detectedIdx;
                    i = temp + (which.length() - 1);
                }
            }

            //while((index = str.indexOf(which, index)) != -1) {
            //           count++;
            //           index = index + which.length();
            //        }//while

            if(count > 0) {
                System.out.println(changedStr);
                System.out.println(count + "개를 치환했습니다.\n");
            } else {
                System.out.println("입력한 문자열의 크기가 작습니다.\n치환할 수 없습니다.");
                break;
            }


        }
    }
}
