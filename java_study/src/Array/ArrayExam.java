package Array;

public class ArrayExam {
    public static void main(String[] args) {
        /*
         * 배열(Array)
         *
         * 정의
         * ㄴ 같은 자료형의 여러개의 데이터를 하나의 변수에 연속적으로 저장하는 자료구조
         * ㄴ 하나의 변수에 여러 개의 값을 저장할 수 있도록 만든 자료형
         *
         * 왜 사용하는가?
         * ㄴ 여러 개의 같은 타입의 데이터를 효율적으로 관리하기 위해서 사용한다.
         * ㄴ 여러 개의 데이터를 하나의 변수로 관리할 수 있다.
         * ㄴ 반복문과 함께 사용하기 쉽다.
         * ㄴ 코드가 간결해진다.
         * ㄴ 메모리에 연속적으로 저장된다.
         *
         * 언제 사용하는가?
         * ㄴ 학생 점수 저장
         * ㄴ 게임 캐릭터 위치 저장
         *
         * 문법
         *
         * 선언
         * 자료형 변수명[];
         *
         * 생성
         * 자료형 변수명[] = new 자료형[크기];
         *
         * 주의사항
         * ㄴ 배열의 요소는 1이 아니라 0부터 시작
         * ㄴ 배열은 크기는 생성 후 변경 할 수 없다.
         * ㄴ 같은 자료형만 저장이 가능하다.
         * ㄴ 범위가 벗어나면 ArrayIndexOutOfBoundsException 발생
         * ㄴ 배열은 참조형이다.
         * */

        int scores[] = {1, 2, 3, 4, 5};
        // 배열의 길이
        System.out.println("배열 scores 길이: "+scores.length);
        System.out.println();

        // 갑 출력
        System.out.println(scores[3]);
        System.out.println();

        // 반복문 활용
        for(int i = 0; i<scores.length; i++) {
            System.out.print(scores[i] + " ");
        }
    }
}
