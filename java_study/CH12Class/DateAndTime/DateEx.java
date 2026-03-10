package Class.DateAndTime;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateEx {
    public static void main(String[] args) {
        // 영문으로 날짜 출력하는 방법
        Date now = new Date();
        String strNow1 = now.toString();
        System.out.println(strNow1);

        // 원하는 문자열로 날짜 출력하는 방법
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String strNow2 = sdf.format(now);
        System.out.println(strNow2);
    }
}
