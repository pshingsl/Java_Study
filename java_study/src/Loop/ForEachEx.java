package Loop;

import java.util.ArrayList;
import java.util.List;

public class ForEachEx {
    public static void main(String[] args) {
        /*
         * for-each
         *
         * 정의
         * ㄴ 배열이나 컬렉션의 모든 요소를 처음부터 끝까지 순서대로 순회하기 위해 사용하는 반복문
         *
         * 왜 사용하는가?
         * ㄴ 기존 for문은 배열이나 리스트를 반복할 때 인덱스를 직접 관리해야 한다.
         * ㄴ 향상된 for문은 인덱스를 사용할 필요 없이 요소를 하나씩 자동으로 꺼내준다.
         * ㄴ 코드 단축, 가독성 향상
         *
         * 언제 사용하는가?
         * ㄴ 배열 전체 조회할 때
         * ㄴ List 전체를 조회할 때
         * ㄴ Set 전체를 조회할 때
         * ㄴ 모든 데이터를 읽기만 할 떄(조회) -> 회원 목록, 상품 목록 등등
         *
         * 문법
         * for(자료형 변수명:배열) {
         *   실행문
         * }
         *
         * for(자료형 변수명:리스트) {
         *   실행문
         * }
         *
         * for(자료형 변수명:집합(셋)) {
         *   실행문
         * }
         *
         * 주의사항
         * ㄴ 인덱스를 사용할 수 없다.
         * ㄴ 값을 변경해도 원본은 변경되지 않는다.(수정, 삭제, 추가)
         * ㄴ 원소를 변경하려면 일반 반복문 사용
         * ㄴ 순회만 할 때 사용하는 것이 좋다.
         * ㄴ 인덱스 사용, 값 수정, 특정 위치 접근 등등 섬세한것은 일반 반복문
         * ㄴ 컬렉션에서도 많이 사용함
         * */

        int num[] = {1, 2, 3, 4, 5};

        for (int numArr : num) {
            System.out.print(numArr + " ");
        }
        System.out.println();

        String[] names = {
                "김철수",
                "이영희",
                "박민수"
        };

        for (String name : names) {
            System.out.print(name + " ");
        }
        System.out.println();

        List<String> fruits = new ArrayList<>();
        fruits.add("apple");
        fruits.add("grape");
        fruits.add("banana");

        for (String fruit : fruits) {
            System.out.print(fruit + " ");
        }
    }
}
