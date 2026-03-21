## 요소 기본 집계

집계(Aggregation)는 스트림의 **최종 처리(Terminal Operation)** 로,  
요소들을 처리하여 **카운팅, 합계, 평균, 최댓값, 최솟값 등 하나의 값으로 축소**하는 것을 의미한다.

이 과정은 **리덕션(Reduction)** 이라고도 한다.

---

## 요소 기본 집계 메소드 종류

| 리턴 타입 | 메소드 | 설명 |
|----------|--------|------|
| long | count() | 요소 개수 |
| Optional<T> | findFirst() | 첫 번째 요소 |
| Optional<T> | max(Comparator<T>) | 최대 요소 |
| Optional<T> | min(Comparator<T>) | 최소 요소 |
| OptionalInt | max() | int 최대값 |
| OptionalInt | min() | int 최소값 |
| OptionalDouble | average() | 평균 |
| int / long / double | sum() | 총합 |

---

# 예제 코드

## 1. 기본 집계 예제

```java
import java.util.Arrays;
import java.util.List;

public class StreamAggregationExample {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10, 20, 30, 40);

        long count = list.stream().count();
        int sum = list.stream().mapToInt(Integer::intValue).sum();
        double avg = list.stream().mapToInt(Integer::intValue).average().getAsDouble();

        int max = list.stream().mapToInt(Integer::intValue).max().getAsInt();
        int min = list.stream().mapToInt(Integer::intValue).min().getAsInt();

        System.out.println("개수: " + count);
        System.out.println("합계: " + sum);
        System.out.println("평균: " + avg);
        System.out.println("최대값: " + max);
        System.out.println("최소값: " + min);
    }
}
```

---

## 2. findFirst() 예제

```java
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamFindFirstExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Java", "Spring", "JPA");

        Optional<String> result = list.stream().findFirst();

        result.ifPresent(System.out::println);
    }
}
```

---

# Optional 클래스

Optional은 집계 결과가 없을 경우를 대비하여  
**안전하게 값을 처리할 수 있도록 도와주는 클래스**이다.

---

## Optional 주요 메소드

| 리턴 타입 | 메소드 | 설명 |
|----------|--------|------|
| boolean | isPresent() | 값 존재 여부 |
| T | orElse(T) | 값이 없을 경우 기본값 반환 |
| void | ifPresent(Consumer) | 값이 있을 경우 실행 |

---

## 1. isPresent() 사용 예제

```java
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;

public class OptionalIsPresentExample {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList();

        OptionalDouble avg = list.stream()
                .mapToInt(Integer::intValue)
                .average();

        if (avg.isPresent()) {
            System.out.println("평균: " + avg.getAsDouble());
        } else {
            System.out.println("값이 존재하지 않음");
        }
    }
}
```

---

## 2. orElse() 사용 예제

```java
import java.util.Arrays;
import java.util.List;

public class OptionalOrElseExample {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList();

        double avg = list.stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println("평균: " + avg);
    }
}
```

---

## 3. ifPresent() 사용 예제

```java
import java.util.Arrays;
import java.util.List;

public class OptionalIfPresentExample {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10, 20, 30);

        list.stream()
            .mapToInt(Integer::intValue)
            .average()
            .ifPresent(avg -> System.out.println("평균: " + avg));
    }
}
```

---

# 종합 예제

```java
import java.util.Arrays;
import java.util.List;

public class StreamAggregationTotalExample {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10, 20, 30, 40);

        list.stream()
            .filter(n -> n >= 20)
            .mapToInt(Integer::intValue)
            .average()
            .ifPresent(avg -> System.out.println("20 이상 평균: " + avg));
    }
}
```

---

## 핵심 정리

- 집계는 **최종 처리 (Terminal Operation)**
- 데이터를 하나의 값으로 축소 (Reduction)
- Optional을 통해 안전하게 결과 처리
- `orElse()`로 기본값 설정 가능
- `ifPresent()`로 값이 있을 때만 처리 가능
- 컬렉션이 비어있을 경우 예외 방지 필수