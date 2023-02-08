package class_;


public class GradeMain {
    public static void main(String[] args) {
        System.out.println("-----------------------------------------");
        System.out.println("이름\t   국어\t 영어\t 수학\t 총점\t 평균\t 학점");
        System.out.println("-----------------------------------------");

        Grade hong = new Grade();
        hong.setData("홍길동", 90, 95, 100);
        hong.calc();
        System.out.printf("%s   %d\t  %d\t  %d\t  %d\t  %s\t  %s\t \n",
            hong.getName(), hong.getKor(), hong.getEng(), hong.getMath(),
            hong.getTotal(), hong.getAvg(), hong.getGrade());

        System.out.println("-----------------------------------------");
        
    }

}
