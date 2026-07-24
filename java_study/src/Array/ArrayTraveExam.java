package Array;

public class ArrayTraveExam {
    public static void main(String[] args) {
        /*
         * 배열 순회
         *
         * 정의
         * ㄴ 배열에 저장된 모든 요소를 처음부터 끝까지 하나씩 접근하는 것을 의미
         * ㄴ 배열의 각 요소를 읽거나 수정할 때 주로 사용
         *
         * 왜 사용하는가?
         * ㄴ 배열에는 여러 개의 값이 저장된다. -> 값이 많으면 직접 작성 비효율
         * ㄴ 따라서 배열 순회를 반복문으로 처리하면 모든 요소를 자동으로 처리할 수 있다.
         *
         * 언제 사용하는가?
         * ㄴ 모든 값 출력
         * ㄴ 합계, 평균 계산
         * ㄴ 최대값, 최솟값 찾기
         * ㄴ 값 수정
         * ㄴ 특정 값
         *
         * 문법
         * 일반 반복문, while문
         * 향상된 반복문 -> 읽기 전용으로 사용할 때 많이 사용
         *
         * 주의사항
         * ㄴ 반복 조건은 항상 < length로 사용하기 -> <=로 하면 마지막에 예외가 발생
         * ㄴ 향상된 반복문은 인덱스를 사용할 수 없다.
         * ㄴ 향상된 반복문으로는 배열 값을 변경할 수 없다.
         * */

        int arr[] = {10, 20, 30, 40, 50};

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        System.out.println();

        // 합계 구하기
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println("합계: " + sum);
        System.out.println();

        // 평균 구하기
        int sum2 = 0;
        double avg = 0;
        for (int i = 0; i < arr.length; i++) {
            sum2 += arr[i];
        }
        avg = sum2 / arr.length;
        System.out.println("평균: " + avg);
        System.out.println();

        // 향상된 반복문
        String fruits[] = {"A", "C", "B"};
        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
        System.out.println();

        // 값 변경
        int[] Arr = {10, 20, 30};

        for (int i = 0; i < Arr.length; i++) {
            Arr[i] *= 2;
        }

        for(int ARR: Arr){
            System.out.print(ARR+ " ");
        }
    }
}
