package Control;

public class SwitchExam {
    public static void main(String[] args) {
        /*
        * switch
        * 정의
        * ㄴ 하나의 변수 또는 식의 값에 따라 여러 경우 중 하나를 선택하여 실행하는 조건문
        * ㄴ if-else처럼 여러 조건을 비료할 수도 있지만, 비교 대상이 하나의 값일때 switch문이 더 읽기 쉽고 간결하다.
        *
        * 왜 사용하는가?
        * ㄴ 조건이 특정 값과 일치하지는지 여러 번 비교해야할 경우 if-else if보다 간결해진다.
        * ㄴ 요일, 월, 메뉴번호, 회원등급, Enum값
        *
        * 언제 사용하는가?
        * ㄴ 메뉴선택, 요일별 처리, 월별 처리, 회원등급, Enum값 분기
        * ㄴ 즉, 하나의 값을 여러 값과 비교해야 하는 경우 사용한다.
        *
        * 문법
        * switch(변수) {
        *   case 값1:
        *       실행문;
        *       break;
        *
        *   case 값2:
        *       실행문2;
        *       break;
        *
        *   case 값3:
        *       실행문3;
        *       break;
        *
        *   default:
        *       실행문;
        * }
        *
        * 실행순서
        * ㄴ switch 값 검사 -> 각 case당 일치하는지 검사 -> 일치하는 case가 있다면 수행 후 break을 만나 종료
        *                  ㄴ> 모든 case에 일치하는게 없다면 default문 실행
        *
        * 주의사항
        * ㄴ break을 사용하지 않는다면 다음 case까지 실해된다.
        * ㄴ default는 선택 사항이다.
        * ㄴ case 값은 중복될 수 없다.
        * ㄴswitch는 하나의 값만 비교한다.
        * ㄴ 여러 case를 묶어서 사용 가능
        * */

        int menuNum = 3;

        switch (menuNum) {
            case 1:
                System.out.println("김치찌개");
                break;

            case 2:
                System.out.println("된장찌개");
                break;

            case 3:
                System.out.println("닭볶음탕");
                break;

            default:
                System.out.println("해당 메뉴가 없습니다.");
        }
    }
}
