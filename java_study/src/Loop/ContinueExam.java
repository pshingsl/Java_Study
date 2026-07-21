package Loop;

public class ContinueExam {
    public static void main(String[] args) {
        /*
         * Continue
         *
         * 정의
         * ㄴ continue는 반복문의 현재 반복문을 건너뛰고 다음 반복문을 이동하는 제어문이다.
         *
         * 왜 사용하는가?
         * ㄴ 반복문을 종료시키지 않고 특정 조건의 데이터만 건너뛰기 위해 사용한다.
         *
         * 언제 사용하는가?
         * ㄴ 특정 조건이 실행하지 않는다.
         * ㄴ 나머지 반복은 진행한다.
         * ㄴ 필터링이 필요할때
         *
         * 문법
         * for(초기식; 조건식; 증감식) {
         *   if(조건) {
         *       continue;
         *   }
         *  실행문;
         * }
         *
         * 주의사항
         * ㄴ continue는 반복문을 종료시키지 않는다.
         * ㄴ break과 다름
         * ㄴ while문에서는 무한루프를 조심
         * */

        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 1) {
                continue;
            }
            System.out.println(i);
        }
        System.out.println();

        for (int i = 1; i <= 5; i++) {
            if (i == 3) {
                continue;
            }
            System.out.println(i);
        }
    }
}
