package Stream.CH07;

import java.util.Arrays;

public class LoopingEx {
    public static void main(String[] args) {
        int[] intArr = {1, 2, 3, 4, 5};

        // 잘못된 케이스
        Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)
                // 출력을 하기 위해서 반드시 최종처리 연산을 해야함
                // 따라서 지금 peek 메소드는 최종처리 연산이 아니므로 동작을 하지 않는다.
                .peek(n -> System.out.println(n));

        // 중간 처리 메소드 peek()을 이용해서 반복 처리
        int total = Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)
                .peek(n -> System.out.println(n))
                .sum();
        System.out.println("총합: " + total);

        // 최종 처리 메소드 forEach()를 이용해서 반복처리
        Arrays.stream(intArr)
                .filter(a -> a % 2 == 0)
                .forEach(n -> System.out.println(n));
    }
}
