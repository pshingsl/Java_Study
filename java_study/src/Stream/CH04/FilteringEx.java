package Stream.CH04;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class FilteringEx {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("Hyuk");
        list.add("Hoo");
        list.add("Haru");
        list.add("Han");
        list.add("Han");

        // 중복 제거
        Stream<String> distinctStream = list.stream();
        distinctStream.distinct()
                .forEach(item -> System.out.println(item));
        System.out.println();

        // 특정 글자 필터링
        Stream<String> charAtSteam = list.stream();
        charAtSteam.filter(item-> item.startsWith("Ha"))
                .forEach(item -> System.out.println(item));
        System.out.println();

        // 중복 요소 먼저 제거하고, a로 시작하는 요소만 필터링
        Stream<String> muitifilterStream = list.stream();
        muitifilterStream.distinct()
                .filter(item -> item.startsWith("a"))
                .forEach(item -> System.out.println(item));
    }
}
