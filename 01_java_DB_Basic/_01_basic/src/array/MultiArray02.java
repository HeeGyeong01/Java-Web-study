package array;

import java.util.Scanner;

public class MultiArray02 {
    public static void main(String[] args) {
        System.out.print("인원수 : ");
        int count = new Scanner(System.in).nextInt();

        String[][] db_idx = new String[count][];
        String[][] db_value = new String[count][];

        for (int i = 0; i < count; i++) {
            System.out.print("\n이름입력 : ");
            String name = new Scanner(System.in).nextLine();
            System.out.print("과목수 입력 : ");
            int subjectCnt = new Scanner(System.in).nextInt();

            db_idx[i] = new String[subjectCnt + 1];
            db_value[i] = new String[subjectCnt + 1];

            db_idx[i][0] = "이름";
            db_value[i][0] = name;

            for (int j = 1; j < subjectCnt + 1; j++) {
                System.out.print("과목명 입력 : ");
                String subject = new Scanner(System.in).nextLine();
                db_idx[i][j] = subject;
            }
            for (int j = 1; j < subjectCnt + 1; j++) {
                System.out.print(db_idx[i][j] + " 점수 입력 : ");
                String score = new Scanner(System.in).nextLine();
                db_value[i][j] = score;
            }
            System.out.println("---------------------------------");
        }

        for (int i = 0; i < count; i++) {
            System.out.println();
            for (String idx : db_idx[i]) { //과목명 출력
                System.out.print(idx + "\t\t");
            }
            System.out.print("총점\t  평균\n");

            for (String value : db_value[i]) { // 과목별 점수 출력
                System.out.print(value + "\t\t");
            }

            float sum = 0;
            for (int j = 1; j < db_value[i].length; j++) { //총점 계산
                sum += Float.parseFloat(db_value[i][j]);
            }
            float avg = sum / (db_value[i].length - 1); //평균 계산
            System.out.printf((int) sum + "\t  " + String.format("%.2f", avg) + "\n");

        }
    }
}

/*
인원수를 입력하여 인원수만큼 데이터를 입력받고 총점과 평균을 구하시오
평균은 소수이하 2째자리까지 출력

[실행결과]
인원수 : 2 

이름입력 : 홍길동
과목수 입력 : 2

과목명 입력 : 국어
과목명 입력 : 영어
국어 점수 입력 : 95
영어 점수 입력 : 100
---------------------
이름입력 : 이기자
과목수 입력 : 3

과목명 입력 : 국어
과목명 입력 : 영어
과목명 입력 : 과학
국어 점수 입력 : 95
영어 점수 입력 : 100
과학 점수 입력 : 90
---------------------

이름     국어     영어   총점     평균
홍길동    95     100   xxx     xx.xx

이름      국어  영어   과학    총점      평균
이기자   95   100   90    xxx      xx.xx
*/
