package Stream.CH02;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPipeEx {
    public static void main(String[] args) {
        List<Student> list = Arrays.asList(
                new Student("Hyuk", 10),
                new Student("Hoo", 20),
                new Student("Han", 30)
        );

        Stream<Student> studentStream = list.stream();

        IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());

        double avg = list.stream()
                .mapToInt(student -> student.getScore())
                .average()
                .getAsDouble();

        System.out.println("avg: " + avg);
    }
}
