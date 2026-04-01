## 요소를 하나씩 처리 (루핑)

> **작성 일시:** 2026-04-01 오후 2:03

루핑(looping)은 스트림에서 요소를 하나씩 반복하여 처리하는 것을 의미한다.

스트림에서 요소를 순회하면서 특정 작업을 수행할 때 사용된다.

---

## 루핑 메소드 종류

| 리턴 타입 | 메소드(매개변수) | 설명 |
|----------|------------------|------|
| Stream<T> | peek(Consumer<? super T>) | 요소를 소비하면서 중간 처리 |
| IntStream | peek(IntConsumer) | int 요소 반복 |
| LongStream | peek(LongConsumer) | long 요소 반복 |
| DoubleStream | peek(DoubleConsumer) | double 요소 반복 |
| void | forEach(Consumer<? super T>) | 최종 처리 (객체) |
| void | forEach(IntConsumer) | 최종 처리 (int) |
| void | forEach(LongConsumer) | 최종 처리 (long) |
| void | forEach(DoubleConsumer) | 최종 처리 (double) |

---

## peek() vs forEach()

| 구분 | 설명 |
|------|------|
| peek() | 중간 처리 (디버깅용으로 많이 사용) |
| forEach() | 최종 처리 (반드시 스트림 종료 시 사용) |

---

# 예제 코드

## 1. forEach() 기본 예제 (최종 처리)

```java
import java.util.Arrays;
import java.util.List;

public class StreamForEachExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Java", "Spring", "JPA");

        list.stream()
            .forEach(item -> System.out.println(item));
    }
}
```

---

## 2. peek() 예제 (중간 처리)

```java
import java.util.Arrays;
import java.util.List;

public class StreamPeekExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Java", "Spring", "JPA");

        list.stream()
            .peek(item -> System.out.println("peek: " + item)) // 중간 처리
            .forEach(item -> System.out.println("forEach: " + item)); // 최종 처리
    }
}
```

---

## 3. peek() 활용 (디버깅)

```java
import java.util.Arrays;
import java.util.List;

public class StreamPeekDebugExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Java", "Spring", "JPA", "DB");

        list.stream()
            .filter(item -> item.length() >= 4)
            .peek(item -> System.out.println("필터링 후: " + item))
            .map(item -> item.toUpperCase())
            .peek(item -> System.out.println("매핑 후: " + item))
            .forEach(System.out::println);
    }
}
```

---

# Consumer 함수형 인터페이스

Consumer 계열 인터페이스는 **데이터를 받아서 소비(처리)** 하고,  
**리턴값이 없는(void)** 특징을 가진다.

---

## Consumer 인터페이스 종류

| 인터페이스 | 추상 메소드 | 설명 |
|------------|------------|------|
| Consumer<T> | void accept(T t) | 객체 소비 |
| IntConsumer | void accept(int value) | int 소비 |
| LongConsumer | void accept(long value) | long 소비 |
| DoubleConsumer | void accept(double value) | double 소비 |

---

## 람다식 형태

```java
T -> {
    실행문;
}
```

또는

```java
T -> 실행문
```

---

## Consumer 예제 코드

```java
import java.util.function.Consumer;

public class ConsumerExample {

    public static void main(String[] args) {

        Consumer<String> consumer = str -> System.out.println(str);

        consumer.accept("Hello Consumer");
    }
}
```

---

## IntConsumer 예제

```java
import java.util.function.IntConsumer;

public class IntConsumerExample {

    public static void main(String[] args) {

        IntConsumer consumer = value -> System.out.println(value * 2);

        consumer.accept(10);
    }
}
```

---

# 종합 예제

```java
import java.util.Arrays;
import java.util.List;

public class StreamLoopingExample {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        list.stream()
            .peek(n -> System.out.println("원본 값: " + n))
            .filter(n -> n % 2 == 0)
            .peek(n -> System.out.println("필터 후: " + n))
            .map(n -> n * 10)
            .forEach(n -> System.out.println("최종 값: " + n));
    }
}
```

---

## 실행 결과

```
원본 값: 1
원본 값: 2
필터 후: 2
최종 값: 20
원본 값: 3
원본 값: 4
필터 후: 4
최종 값: 40
원본 값: 5
```

---

## 핵심 정리

- `peek()` : 중간 처리 (디버깅 용도)
- `forEach()` : 최종 처리 (반복 실행)
- Consumer 계열은 **입력만 있고 반환값 없음**
- 스트림은 **최종 연산이 실행되어야 동작**