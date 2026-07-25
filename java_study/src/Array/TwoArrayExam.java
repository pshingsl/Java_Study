package Array;

public class TwoArrayExam {
    public static void main(String[] args) {
        /*
         * 다차원 배열
         *
         * 정의
         * ㄴ 배열안에 또 다른 배열을 저장하는 배열
         * ㄴ 가장 많이 사용하는 형태는 2차원 배열의 행과 열 구조로 데이터를 저장
         *
         * 왠 사용하는가?
         * ㄴ 1치원 배열은 목록만 저장 가능하다.
         * ㄴ 학생별 과목별 점수는 행과 열로 이루어져 있으므로 2차원 배열이 적합하다
         *
         * 언제 사용하는가?
         * ㄴ 게임 맵
         * ㄴ 체스판
         * ㄴ 학생 성적 표
         * ㄴ 엑셀 표
         *
         * 문법
         * 자료형 배열명[][];
         *
         * 주의사항
         * ㄴ 행과 열 헷갈리지 말기 arr[행][열]
         * ㄴ 2차원 배열에서 반복문은 반드시 2개 사용해야 전체 순회 가능
         * */

        int[][] arr = {
                {10, 20, 30},
                {40, 50, 60}
        };

        System.out.println(arr[1][1]);
        System.out.println();

        // arr.length는 행의 개수    : 2
        // arr[i]/length는 열의 개수 : 3

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
        }
        System.out.printlnazazaza();

        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println(sum);
    }
}
