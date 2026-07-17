package Control;

public class NestedIf {
    public static void main(String[] args) {

        /*
         * 중첩 조건문(Nested IF)
         *
         * 정의
         * ㄴ 중첩 조건문이란 if문 내부에 또 다른 if문을 작성하는 조건문
         * ㄴ 1번째 조건이 만족한 후, 추가적인 조건을 다시 검사해야할 때 사용한다.
         *
         * 왜 사용하는가?
         * ㄴ 하나의 조건만으로는 판단이 부족한 경우가 있다.
         * ㄴ 로그인 성공 후 관리자 여부 확인, 성인인지 확인 후 운전면허 보유 여부 확인
         *
         * 언제 사용하는가?
         * ㄴ 시험 합격 후 장학생 지급 여부 확인
         *
         * 문법
         * ㄴ if(조건식1) {
         *   if(조건식2) {
         *       실행문;
         *   }
         * }
         *
         * if(조건식1) {
         *   if(조건식2) {
         *      실행문;
         * } else{
         *       실행문2;
         *  } else {
         *  실행문3
         *  }
         * }
         *
         * 실행 순서
         * ㄴ 조건식 1검사 -> 성공 -> 조건식 2검사 -> 성공 ->  실횅
         *                                     ㄴ> 실패 -> else문 존재시 실행
         * ㄴ 조건식1 실패 -> 종료 또는 else문 실행
         *
         * 주의사항
         * ㄴ 조건문의 중첩이 깊어질수록 가독성이 떨어진다.
         * ㄴ 중괄호 생략 하면 안된다.
         * ㄴ 모든 중첩 if가 필요한것은 아니다.
         * ㄴ else는 항상 가까운 if와 연결된다.
         * */

        boolean login = true;
        boolean amdin = true;

        if (login && amdin) {
            System.out.println("관리자");
        }

        int age = 20;
        boolean license = false;

        if (age >= 20) {
            if (license) {
                System.out.println("운전 가능");
            } else {
                System.out.println("운전 불가능");
            }
        } else {
            System.out.println("미성년자입니다.");
        }
    }
}
