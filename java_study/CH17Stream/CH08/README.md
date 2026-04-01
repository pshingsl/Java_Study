## 요소 조건 만족 여부 (매칭)

> **작성 일시:** 2026-04-01 오후 2:13

매칭(Matching)은 스트림의 요소들이 **특정 조건을 만족하는지 여부를 검사하는 최종 처리(Terminal Operation)** 기능이다.

---

## 매칭 메소드 종류

| 리턴 타입 | 메소드(매개변수) | 설명 |
|----------|------------------|------|
| boolean | allMatch(Predicate<T>) | 모든 요소가 조건을 만족하는지 |
| boolean | anyMatch(Predicate<T>) | 하나라도 조건을 만족하는지 |
| boolean | noneMatch(Predicate<T>) | 모든 요소가 조건을 만족하지 않는지 |
| boolean | allMatch(IntPredicate) | 모든 int 요소 만족 여부 |
| boolean | anyMatch(IntPredicate) | 하나라도 int 요소 만족 여부 |
| boolean | noneMatch(IntPredicate) | 모든 int 요소 불만족 여부 |
| boolean | allMatch(LongPredicate) | 모든 long 요소 만족 여부 |
| boolean | anyMatch(LongPredicate) | 하나라도 long 요소 만족 여부 |
| boolean | noneMatch(LongPredicate) | 모든 long 요소 불만족 여부 |
| boolean | allMatch(DoublePredicate) | 모든 double 요소 만족 여부 |
| boolean | anyMatch(DoublePredicate) | 하나라도 double 요소 만족 여부 |
| boolean | noneMatch(DoublePredicate) | 모든 double 요소 불만족 여부 |

---

## 매칭 메소드 설명

- **allMatch()** : 모든 요소가 조건을 만족하면 `true`
- **anyMatch()** : 하나라도 조건을 만족하면 `true`
- **noneMatch()** : 모든 요소가 조건을 만족하지 않으면 `true`

---

## Predicate 복습

매칭 메소드는 내부적으로 Predicate를 사용한다.

```java
T -> {
    return boolean;
}
```

또는

```java
T -> boolean
```

---

# 예제 코드

## 1. allMatch() 예제

```java
import java.util.Arrays;
import java.util.List;

public class StreamAllMatchExample {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10, 20, 30, 40);

        boolean result = list.stream()
                .allMatch(n -> n >= 10);

        System.out.println("모두 10 이상인가? " + result);
    }
}
```

### 실행 결과

```
모두 10 이상인가? true
```

---

## 2. anyMatch() 예제

```java
import java.util.Arrays;
import java.util.List;

public class StreamAnyMatchExample {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10, 20, 30, 40);

        boolean result = list.stream()
                .anyMatch(n -> n == 20);

        System.out.println("20이 존재하는가? " + result);
    }
}
```

### 실행 결과

```
20이 존재하는가? true
```

---

## 3. noneMatch() 예제

```java
import java.util.Arrays;
import java.util.List;

public class StreamNoneMatchExample {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(10, 20, 30, 40);

        boolean result = list.stream()
                .noneMatch(n -> n < 0);

        System.out.println("음수가 없는가? " + result);
    }
}
```

### 실행 결과

```
음수가 없는가? true
```

---

## 4. 문자열 조건 검사 예제

```java
import java.util.Arrays;
import java.util.List;

public class StreamMatchExample2 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Java", "Spring", "JPA");

        boolean allLengthCheck = list.stream()
                .allMatch(str -> str.length() >= 3);

        boolean anyStartsWithJ = list.stream()
                .anyMatch(str -> str.startsWith("J"));

        boolean noneNull = list.stream()
                .noneMatch(str -> str == null);

        System.out.println("모두 길이 3 이상: " + allLengthCheck);
        System.out.println("J로 시작하는 값 존재: " + anyStartsWithJ);
        System.out.println("null 없음: " + noneNull);
    }
}
```

---

## 5. 기본 타입 스트림 매칭

```java
import java.util.stream.IntStream;

public class IntStreamMatchExample {

    public static void main(String[] args) {

        boolean result = IntStream.rangeClosed(1, 5)
                .allMatch(n -> n > 0);

        System.out.println("모두 양수인가? " + result);
    }
}
```

---

## 핵심 정리

- 매칭은 **최종 처리 (Terminal Operation)** 이다.
- `allMatch()` : 모두 만족
- `anyMatch()` : 하나라도 만족
- `noneMatch()` : 모두 불만족
- Predicate를 기반으로 조건 검사 수행
- 결과는 항상 `boolean`