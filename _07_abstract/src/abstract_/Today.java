package abstract_;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class Today {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("y년 M월 d일 E요일 HH:mm:ss");
        System.out.println("오늘 날짜: "+ sdf.format(date));
        System.out.println();

        //입력-내 생일
        SimpleDateFormat input = new SimpleDateFormat("yyyyMMddHHmmss");
        Date birth = input.parse("19910716091415"); //String -> Date형 변환

        System.out.println("내 생일 = " + birth);
        System.out.println("내 생일 = " + sdf.format(birth));

        Calendar cal = new GregorianCalendar();
        Calendar cal2 = Calendar.getInstance(Locale.KOREA);

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        int week = cal.get(Calendar.DAY_OF_WEEK); //상수임. cal.get(7)과 같음.

        String dayOfWeek = null;
        switch(week){
            case 1: dayOfWeek = "일"; break;
            case 2: dayOfWeek = "월"; break;
            case 3: dayOfWeek = "화"; break;
            case 4: dayOfWeek = "수"; break;
            case 5: dayOfWeek = "목"; break;
            case 6: dayOfWeek = "금"; break;
            case 7: dayOfWeek = "토";
        }

        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minute = cal.get(Calendar.MINUTE);
        int second = cal.get(Calendar.SECOND);


        System.out.printf("%d년 %d월 %d일 %s요일 %d시 %d분 %d초",
            year, month, day, dayOfWeek, hour, minute, second);
    }
}
