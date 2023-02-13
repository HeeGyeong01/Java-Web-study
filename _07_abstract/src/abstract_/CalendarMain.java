package abstract_;

import java.util.Scanner;

public class CalendarMain {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        System.out.print("년도 입력: ");
        int year = scan.nextInt();
        System.out.print("월 입력: ");
        int month = scan.nextInt();

        CalendarEx cal = new CalendarEx(year, month);
        cal.calc();
        cal.display();

    }
}

/*
[문제] 만년달력
- 년도, 월을 입력하여 달력을 작성하시오

클래스명 : CalendarEx
필드 :
메소드 - 기본 생성자 : 년, 월을 입력
       calc()    : 매달 1일의 요일이 무엇인지? (Calendar의 메소드 사용)
                   매달 마지막이 28, 29, 30, 31 무엇인지? (Calendar의 메소드 사용)
       display() : 출력

클래스명 : CalendarMain

[실행결과]
년도 입력 : 2002
월 입력 : 10

일   월   화   수   목   금   토
      1   2   3   4   5
6   7   8   9   10   11   12
13   14   15   16   17   18   19
20   21   22   23   24   25   26
27   28   29   30   31
 */