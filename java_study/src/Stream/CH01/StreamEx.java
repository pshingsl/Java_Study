package Stream.CH01;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.stream.Stream;

public class StreamEx {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("Hyuk");
        set.add("Hoo");
        set.add("Han");

        // 외부 반복자를 이용
        for(String name : set){
            System.out.println(name);
        }
        System.out.println();

        // iterator 방식
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            String name = iterator.next();
            System.out.println(name);
        }
        System.out.println();

        // 내부 반복자 이용
        // forEach(Consumer<? super T> action) T는 해당 타입이거나 해당 타입의 부모가 와야함
        // Consumer는 함수형 인터페이스 Consumer의 메서드로 accept(T t), andThen*Consumer<? super T> after)이 올 수 있다.
        Stream<String> stream = set.stream();
        stream.forEach(item -> System.out.println(item));
    }
}
