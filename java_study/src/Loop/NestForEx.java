package Loop;

public class NestForEx {
    public static void main(String[] args) {
        /*
         * 중첩 반복문
         *
         * 정의
         * ㄴ 중청 반복문이란 for문 안에 for문을 사용하는 반복문이다.
         * ㄴ 바깥쪽 반복문이 한번 실행될 때마다 안쪽 반복문이 처음부터 끝까지 실행된다.
         *
         * 왜 사용하는가?
         * ㄴ 한 번의 반복만으로는 표현하기 여려운 2차원 형태의 데이터를 처리하기 위해서이다.
         * ㄴ 구구단, 좌표 순회, 2차원 배열 탐색, 모든 경우의 수 탐색
         *
         * 언제 사용하는가?
         * ㄴ 행과 열을 동시에 반복해야할 떄
         * ㄴ 표 형태의 데이터를 처리할 때
         * ㄴ 2차원 배열을 탐색할 때
         * ㄴ 모든 조합을 확인해야 할 떄
         * ㄴ 알고리즘 문제에서 이중 반복문이 필요할 때
         *
         * 문법
         * for(초기식1; 조건식1; 증감식1) {
         *   for(초기식2; 조건식2; 증감식2) {
         *       반복할 코드;
         *   }
         * }
         *
         * 실행 순서
         * ㄴ 바깥 for 시작 -> 안쪽 for 처음부터 끝까지 실행 -> 바깥 for 다음 반복 -> 안쪽 for 다시 처음부터 실행 -> 반복
         *
         * 주의사항
         * ㄴ 안쪽 반복문은 바깥 반복마다 처음부터 다시 시작
         * ㄴ 반복 횟수가 많을 수록 실행횟수가 크게 증가
         * */

        for (int i = 1; i <= 3; i++) {
            System.out.println("바깥 반복문: " + i);
            for (int j = 1; j <= 2; j++) {
                System.out.println("안쪽 반복문: " + j);
            }
        }
        System.out.println();

        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        System.out.println();

        for(int i =5; i>=1; i--) {
            for(int j = 1; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
