package Stream.CH11;

import java.util.*;
import java.util.stream.Collectors;

public class CollectEx {
    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Han", "남", 92));
        studentList.add(new Student("Hon", "남", 97));
        studentList.add(new Student("Lee", "여", 92));
        studentList.add(new Student("Lam", "여", 42));
        studentList.add(new Student("Max", "남", 100));

        // 남학생인 경우
        List<Student> maleList = studentList.stream().
                filter(s -> s.getSex().equals("남"))
                .toList();

        maleList.stream()
                .forEach(s -> System.out.println(s.getName()));
        System.out.println();

        Set<Student> set = studentList.stream()
                .filter(s -> s.getSex().startsWith("남"))
                .collect(Collectors.toSet());
        System.out.println(set);
        System.out.println();

        // 학생 이름을 키, Student 객체를 값으로 갖는 Map 생성
        Map<String, Integer> map = studentList.stream()
                .collect(
                        Collectors.toMap(
                                s -> s.getName(),
                                s -> s.getScore()
                        )
                );

        System.out.println(map);
        System.out.println();

        // Collector<T.?..Map(K.List<T>>>와 groupingBy(Function<T, K> classifier)
        Map<String, List<Student>> map2 = studentList.stream()
                .collect(
                        Collectors.groupingBy(s -> s.getSex())
                );

        List<Student> femaleList = map2.get("여");
        femaleList.stream().forEach(s -> System.out.println(s.getName()));
        System.out.println();

        Map<String, Double> map3 = studentList.stream()
                .collect(
                        Collectors.groupingBy(
                                s -> s.getSex(),
                                Collectors.averagingDouble(s -> s.getScore())
                        )
                );

        System.out.println(map3);
    }
}
