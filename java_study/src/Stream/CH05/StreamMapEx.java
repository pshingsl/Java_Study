package Stream.CH05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamMapEx {
    public static void main(String[] args) {

        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Han", 100));
        studentList.add(new Student("Hoo", 90));
        studentList.add(new Student("Hon", 80));

        Stream<Student> studentStream = studentList.stream();
        studentStream
                .mapToInt(s -> s.getScore())
                .forEach(studnet -> System.out.println(studnet));
        System.out.println();

        int[] numArr = {1, 2, 3, 4, 5};
        IntStream intStream = Arrays.stream(numArr);

        intStream
                .mapToDouble(w -> w)
                .forEach(w-> System.out.println(w));
    }
}
