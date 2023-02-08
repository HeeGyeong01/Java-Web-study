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
            for (String idx : db_idx[i]) {
                System.out.print(idx + "\t\t");
            }
            System.out.print("총점\t  평균\n");

            for (String value : db_value[i]) {
                System.out.print(value + "\t\t");
            }

            float sum = 0;
            for (int j = 1; j < db_value[i].length; j++) {
                sum += Float.parseFloat(db_value[i][j]);
            }
            float avg = sum / (db_value[i].length - 1);
            System.out.printf((int) sum + "\t  " + String.format("%.2f", avg) + "\n");

        }
    }
}
