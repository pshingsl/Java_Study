package Stream.CH06;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortingEx {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Han", 40));
        studentList.add(new Student("Hin", 50));
        studentList.add(new Student("Hon", 60));

        studentList.stream()
                .sorted()
                .forEach(score -> System.out.println(score.getName() + ": " + score.getScore()));
        System.out.println();

        studentList.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(score -> System.out.println(score.getName() + ": " + score.getScore()));
    }
}
