package Enum;

import java.util.Calendar;

public class WeekEX {
    public static void main(String[] args) {
        //열거 타입 변수를 선언
        Week today = null;

        // Calendar 얻기
        Calendar cal = Calendar.getInstance(); // 컴퓨터 날짜 및 시간 정보를 가진 객체를 얻고 번지 cal변수에 대입

        // 오늘의 요일 엉ㄷ기(1~7)
        int week = cal.get(Calendar.DAY_OF_WEEK);

        // 숫자를 열거 상수로 변환해서 변수에 대입
        switch (week){
            case 1: today = Week.SUNDAY;
            case 2: today = Week.MONDAY;
            case 3: today = Week.TUESDAY;
            case 4: today = Week.WEDENDAY;
            case 5: today = Week.THURSDAY;
            case 6: today = Week.FRIDAY;
            case 7: today = Week.SATURDAY;
        }

        if(today == Week.SUNDAY){
            System.out.println("휴식");
        } else{
            System.out.println("일 시작");
        }

        // 열거값 대입
        today = Week.SATURDAY;

        // 열거값 비교
        if(today == Week.FRIDAY){
            System.out.println("오늘은 금요일 합니다.");
        } else {
            System.out.println("오늘은 금요일 아닙니다");
        }
    }
}
