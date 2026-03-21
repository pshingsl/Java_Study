## 요소 걸러내기 (필터링)

필터링은 스트림의 요소를 조건에 따라 걸러내는 **중간 처리(Intermediate Operation)** 기능이다.

대표적인 필터링 메소드는 `distinct()` 와 `filter()` 이다.

---

## 필터링 관련 메소드

| 리턴 타입 | 메소드(매개변수) | 설명 |
|----------|------------------|------|
| Stream<T> | distinct() | 중복 제거 |
| Stream<T> | filter(Predicate<T>) | 조건 필터링 |
| IntStream | filter(IntPredicate) | int 조건 필터링 |
| LongStream | filter(LongPredicate) | long 조건 필터링 |
| DoubleStream | filter(DoublePredicate) | double 조건 필터링 |

---

## distinct()

- 요소의 **중복을 제거**
- 객체 스트림의 경우 `equals()` 기준으로 동일 여부 판단
- 기본 타입 스트림은 값이 같으면 중복 제거

```java
list.stream()
    .distinct()
    .forEach(System.out::println);
```

---

## filter()

- 조건에 맞는 요소만 필터링
- 매개값으로 전달된 **Predicate**가 `true`를 반환하는 요소만 통과

```java
list.stream()
    .filter(item -> item.length() > 3)
    .forEach(System.out::println);
```

---

## Predicate 함수형 인터페이스

모든 Predicate 계열 인터페이스는 **조건을 검사하여 boolean 값을 반환**한다.

| 인터페이스 | 추상 메소드 | 설명 |
|------------|------------|------|
| Predicate<T> | boolean test(T t) | 객체 검사 |
| IntPredicate | boolean test(int value) | int 검사 |
| LongPredicate | boolean test(long value) | long 검사 |
| DoublePredicate | boolean test(double value) | double 검사 |

---

## 람다식 형태

```java
T -> { 
    return true;
}
```

또는 (return만 있을 경우 축약 가능)

```java
T -> true
```

---

# 예제 코드

## 1. distinct() 예제 (중복 제거)

```java
import java.util.Arrays;
import java.util.List;

public class StreamDistinctExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Java", "Java", "Spring", "JPA", "Spring");

        list.stream()
            .distinct()
            .forEach(item -> System.out.println(item));
    }
}
```

### 실행 결과

```
Java
Spring
JPA
```

---

## 2. filter() 예제 (조건 필터링)

```java
import java.util.Arrays;
import java.util.List;

public class StreamFilterExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Java", "Spring", "JPA", "DB");

        list.stream()
            .filter(item -> item.length() >= 4)
            .forEach(item -> System.out.println(item));
    }
}
```

### 실행 결과

```
Java
Spring
```

---

## 3. distinct() + filter() 함께 사용

```java
import java.util.Arrays;
import java.util.List;

public class StreamFilterExample2 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Java", "Java", "Spring", "JPA", "DB");

        list.stream()
            .distinct()                              // 중복 제거
            .filter(item -> item.length() >= 4)      // 길이 조건
            .forEach(System.out::println);
    }
}
```

---

## 4. 기본 타입 스트림 필터링

```java
import java.util.Arrays;
import java.util.stream.IntStream;

public class IntStreamFilterExample {

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};

        IntStream stream = Arrays.stream(arr);

        stream.filter(value -> value % 2 == 0) // 짝수만 필터링
              .forEach(System.out::println);
    }
}
```

### 실행 결과

```
2
4
6
```

---

## 핵심 정리

- `distinct()` : 중복 제거 (equals 기준)
- `filter()` : 조건 기반 필터링
- Predicate 계열 인터페이스는 `boolean` 반환
- 필터링은 **중간 처리**이므로 반드시 **최종 처리와 함께 사용해야 실행됨**