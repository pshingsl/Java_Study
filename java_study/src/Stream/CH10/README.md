## 요소 커스텀 집계 (reduce)

스트림은 기본 집계 메소드인 `sum()`, `average()`, `count()`, `max()`, `min()`을 제공하지만,  
더 다양한 집계 결과를 만들기 위해 **reduce() 메소드**를 제공한다.

reduce는 스트림 요소들을 결합하여 **하나의 결과값으로 축소(Reduction)** 하는 연산이다.

---

## reduce() 메소드 종류

| 인터페이스 | 리턴 타입 | 메소드 |
|------------|----------|--------|
| Stream<T> | Optional<T> | reduce(BinaryOperator<T> accumulator) |
| Stream<T> | T | reduce(T identity, BinaryOperator<T> accumulator) |
| IntStream | OptionalInt | reduce(IntBinaryOperator op) |
| IntStream | int | reduce(int identity, IntBinaryOperator op) |
| LongStream | OptionalLong | reduce(LongBinaryOperator op) |
| LongStream | long | reduce(long identity, LongBinaryOperator op) |
| DoubleStream | OptionalDouble | reduce(DoubleBinaryOperator op) |
| DoubleStream | double | reduce(double identity, DoubleBinaryOperator op) |

---

## BinaryOperator 함수형 인터페이스

BinaryOperator는 **두 개의 값을 받아 하나의 값으로 결합**하는 함수형 인터페이스이다.

```java
(a, b) -> 결과값
```

---

## 기본 사용 예시

```java
int sum = stream
    .reduce((a, b) -> a + b)
    .getAsInt();
```

```java
int sum = stream
    .reduce(0, (a, b) -> a + b);
```

---

# 예제 코드

## 1. reduce() 기본 예제 (Optional 반환)

```java
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample1 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        Optional<Integer> result = list.stream()
                .reduce((a, b) -> a + b);

        result.ifPresent(sum -> System.out.println("합계: " + sum));
    }
}
```

---

## 2. 초기값(identity) 있는 reduce()

```java
import java.util.Arrays;
import java.util.List;

public class StreamReduceExample2 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        int sum = list.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("합계: " + sum);
    }
}
```

---

## 3. 최대값 구하기

```java
import java.util.Arrays;
import java.util.List;

public class StreamReduceExample3 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10, 20, 5, 30);

        int max = list.stream()
                .reduce((a, b) -> a > b ? a : b)
                .get();

        System.out.println("최대값: " + max);
    }
}
```

---

## 4. 문자열 연결

```java
import java.util.Arrays;
import java.util.List;

public class StreamReduceExample4 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Java", "Spring", "JPA");

        String result = list.stream()
                .reduce("", (a, b) -> a + " " + b);

        System.out.println(result);
    }
}
```

---

## 5. 조건 포함 커스텀 집계

```java
import java.util.Arrays;
import java.util.List;

public class StreamReduceExample5 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        int sum = list.stream()
                .filter(n -> n % 2 == 0) // 짝수만
                .reduce(0, (a, b) -> a + b);

        System.out.println("짝수 합계: " + sum);
    }
}
```

---

## 6. IntStream reduce()

```java
import java.util.stream.IntStream;

public class IntStreamReduceExample {

    public static void main(String[] args) {

        int sum = IntStream.rangeClosed(1, 5)
                .reduce(0, (a, b) -> a + b);

        System.out.println("합계: " + sum);
    }
}
```

---

## 핵심 정리

- `reduce()`는 스트림 요소를 하나의 값으로 축소하는 연산
- `BinaryOperator`를 사용하여 값들을 결합
- 초기값(identity)을 사용하면 Optional 없이 바로 값 반환
- 다양한 커스텀 집계 로직 구현 가능
- `sum()` 등 기본 집계는 reduce의 특수한 형태****