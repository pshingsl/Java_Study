package Stream.CH10;

import java.util.Arrays;
import java.util.List;

public class ReductionEx {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("Han", 100),
                new Student("Hon", 90),
                new Student("Hoo", 70)
        );

        // 방법1
        int sum1 = list.stream()
                .mapToInt(Student::getScore)
                .sum();

        // 방법2
        int sum2 = list.stream()
                .map(Student::getScore)
                .reduce(0, (a, b) -> a + b);

        System.out.println("sum1: " + sum1);
        System.out.println("sum2: " + sum2);
    }
}
