package basic;

public class SungJuk {

    public static void main(String[] args) {
        String name = "L";
        int kor = 85;
        int eng = 78;
        int math = 100;

        int tot = kor + eng + math;
        double avg = tot / 3.0;

        System.out.println("   *** " + name + " 성적표 ***");
        System.out.println("국어   영어   수학   총점   평균");
        System.out.println(
            kor + "    " + eng + "    " + math + "    " + tot + "    " + String.format("%.2f",
                avg));

    }

}
