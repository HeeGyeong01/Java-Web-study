package class_;

public class Grade {
    String name;
    int kor, eng, math, total;
    char grade;
    float avg;

    public void setData(String name, int kor, int eng, int math) { //메소드 구현
        this.name = name;
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public void calc() {
        this.total = kor + eng + math;
        this.avg = (float) total / 3;

        if(avg >= 90) grade = 'A';
        else if(avg >= 80) grade = 'B';
        else if(avg >= 70)
            grade = 'C';
        else if(avg >= 60)
            grade = 'D';
        else
            grade = 'F';

    }

    public String getName() {
        return name;
    }

    public int getKor() {
        return kor;
    }

    public int getEng() {
        return eng;
    }

    public int getMath() {
        return math;
    }

    public int getTotal() {
        return total;
    }

    public String getAvg() {
        return String.format("%.2f", avg);
    }

    public char getGrade() {
        return grade;
    }

}
