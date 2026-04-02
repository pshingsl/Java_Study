package Stream.CH09;

import java.util.Arrays;

public class AggregateEx {
    public static void main(String[] args) {
        int[] intArr = {1, 2, 3, 4, 5};

        // 카운트
        long count = Arrays.stream(intArr)
                .filter(n -> n % 2 == 0)
                .count();
        System.out.println("2의 배수 개수: " + count);

        // 총합
        long sum = Arrays.stream(intArr)
                .filter(n -> n % 2 == 0)
                .sum();
        System.out.println("2의 배수 합: " + sum);

        // 평균
        double avg = Arrays.stream(intArr)
                .filter(n -> n % 2 == 0)
                .average()
                .getAsDouble();
        System.out.println("2의 배수 평균: " + avg);

        // 최대값
        int max = Arrays.stream(intArr)
                .max()
                .getAsInt();
        System.out.println("최대값: " + max);

        // 최소값
        int min = Arrays.stream(intArr)
                .min()
                .getAsInt();
        System.out.println("최소값: " + min);

        int first = Arrays.stream(intArr)
                .filter(n -> n%3==0)
                .findFirst()
                .getAsInt();
        System.out.println("첫 번째 3의 배수: " + first);
    }
}
