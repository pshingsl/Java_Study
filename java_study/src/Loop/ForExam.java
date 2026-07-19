package Loop;

public class ForExam {
    public static void main(String[] args) {
        /*
         * for문(for Loop)
         * 정의
         *ㄴ 정해진 횟수만큼 반복해서 코드를 실행하는 반복문
         *ㄴ 반복 횟수를 알고 있을 때 가장 많이 사용하는 반복문
         *
         * 왜 사용하는가?
         * ㄴ 같은 코드를 여러 번 작성하는 것은 비효율적이다.
         *
         * 언제 사용하는가?
         * ㄴ 정해진 횟수만큼 반복
         * ㄴ 배열 순회
         * ㄴ 합계 계산
         *
         * 문법
         * for(초기식; 조건식; 증감식) {
         *  반복할 코드;
         * }
         *
         * 실행 순서
         * ㄴ 초기식 -> 조건식 검사 -> true -> 실행문 -> 증감식 -> 조건식 검사 ->
         *
         * 주의사항
         * */

        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }

        int sum = 0;
        for (int i = 1; i <= 10; i++) {
            sum +=i;
        }
        System.out.println("총합: " + sum);

    }
}
