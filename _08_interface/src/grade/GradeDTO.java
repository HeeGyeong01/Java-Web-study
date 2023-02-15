package grade;

public class GradeDTO {
    private int no, kor, eng, math, total;
    private String name;
    private double avg;

    public GradeDTO(int no, String name, int kor, int eng, int math) {
        this.no = no;
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public void calc(){
        total = kor + eng + math;
        avg = (double)total / 3     ;
    }

    //getter, setter

    public int getNo() {
        return no;
    }

    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getTotal() {
        return total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getAvg() {
        return avg;
    }


    @Override
    public String toString(){
        return String.format("%d\t%4s\t%4d\t%4d\t%4d\t%4d\t%4.2f\n",
            no, name, kor,  eng,  math, total, avg);
    }

}
