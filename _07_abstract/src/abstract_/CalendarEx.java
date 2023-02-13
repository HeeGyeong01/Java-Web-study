package abstract_;

import java.util.Calendar;

public class CalendarEx {
    int year;
    int month;
    int firstdayOfWeek;
    int lastdayOfMonth;


    public CalendarEx(int year, int month){
        this.year = year;
        this.month = month;
    }

    public void calc(){
        Calendar cal = Calendar.getInstance();
        cal.set(year, month-1, 1); //사용자가 입력한 month에서 1을 빼서 넘겨줘야 함.

        this.firstdayOfWeek = cal.get(Calendar.DAY_OF_WEEK); //ex) 수요일 = 4
        this.lastdayOfMonth = cal.getActualMaximum(Calendar.DATE); //ex) 30
    }

    public void display(){
        System.out.printf("----------%d년 %d월-----------\n", year, month);
        System.out.println("\t일\t월\t화\t수\t목\t금\t토");
        System.out.println("------------------------------");

        for(int i = 1; i < firstdayOfWeek; i++) {
            System.out.print("    "); //1일이 시작하기 전,비어있는 요일에 공백4칸을 출력한다
        }

        for(int i = 1; i <= lastdayOfMonth; i++) {
            System.out.printf("%4d", i); // __12(빈칸3+숫자1 OR 빈칸 2+숫자2)으로 4칸씩 차지하게 날짜를 출력

            firstdayOfWeek++;
            if(firstdayOfWeek % 7 == 1) // 토요일 다음으로 넘어갈때(한 주가 끝날 때) 줄바꿈함.
                System.out.println();
        }
        System.out.println("\n------------------------------");


    }
}
