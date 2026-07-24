package Array;

public class ArrayInItEx {
    public static void main(String[] args) {
        /*
         * 배열의 초기화(Array Initital)
         *
         * 정의
         * ㄴ 배열의 생성은 객체를 메모리(Heap)에 만드는 것이다.
         * ㄴ 여기선 초기화를 배열의 값을 저장하는 것이다.
         * ㄴ 생성 -> 메모리 확보 -> 초기화 -> 데이터 저장
         *
         * 왜 사용하는가?
         * ㄴ 사용할 공간을 먼저 확보해야 데이터를 저장할 수 있다.
         *
         * 언제 사용하는가?
         * ㄴ 배열을 생성할 때 항상 생성 -> 초기화
         * ㄴ 학생 점수, 좌석번호, 상품가격
         *
         * 문법
         * 자료형 변수명[] = new 자료형[크기];
         *
         * 생성
         * 변수명[인덱스 번호] = 값;
         *
         * 생성 후 갑 저장
         * 자료형 변수명[] = {값1, 값2, 값3};
         *
         * 주의사항
         * ㄴ new를 사용하면 메모리에 배열이 생성된다.
         * ㄴ 생성만 하면 자료형에 맞게 기본값으로 초기화된다.
         * ㄴ 배열의 크기는 변경할 수 없다.
         * ㄴ 선언 후에는 중괄호만 사용할 수 없다.
         * ㄴ 배열의 크기는 음수가 될 수 없다.
         */

        int num[] = new int[5];
        System.out.println(num.length);
        System.out.println();

        int nums[] = new int[3];
        nums[0] = 100;
        nums[1] = 200;
        nums[2] = 300;

        for (int numb : nums) {
            System.out.print(numb+ " ");
        }
    }
}
