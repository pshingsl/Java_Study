package Stream.CH01;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class parallerStreamEx {
    public static void main(String[] args) {
        // 병렬 처리 할거면 Vector가 좋은데 읽기만 할거면 ArrayList가 괜찮음
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

        // 스레드는 cpu의 코어의 논리 코어개수를 의미한다.
        // ForkJoinPool.commonPool-worker-4 코어수는 여기서 숫자를 의미함
        // 메인까지 합치면 현재 코어는 5개까지 사용하고 있다.
        Stream<String> stream = list.parallelStream();
        stream.forEach(item -> System.out.println(item + ": " + Thread.currentThread().getName()));
    }
}
