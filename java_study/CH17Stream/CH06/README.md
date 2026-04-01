## 요소 정렬

> **작성 일시:** 2026-04-01 오후 1:45

정렬은 스트림의 요소를 **오름차순 또는 내림차순으로 정렬하는 중간 처리(Intermediate Operation)** 기능이다.

---

## 요소 정렬 메소드 종류

| 리턴 타입 | 메소드(매개변수) | 설명                              |
|----------|------------------|---------------------------------|
| Stream<T> | sorted() | Comparable 요소를 정렬한 새로운 스트림 생성   |
| Stream<T> | sorted(Comparator) | 요소를 Comparator에 따라 정렬한 새 스트림 생성 |
| IntStream | sorted() | int 오름차순 정렬                     |
| LongStream | sorted() | long 오름차순 정렬                    |
| DoubleStream | sorted() | double 오름차순 정렬                  |

---

# 예제 코드

## 1. 기본 정렬 (오름차순)

```java
import java.util.Arrays;
import java.util.List;

public class StreamSortExample1 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 3, 1, 4, 2);

        list.stream()
            .sorted()
            .forEach(System.out::println);
    }
}
```

### 실행 결과

```
1
2
3
4
5
```

---

## 2. 내림차순 정렬

```java
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class StreamSortExample2 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(5, 3, 1, 4, 2);

        list.stream()
            .sorted(Comparator.reverseOrder())
            .forEach(System.out::println);
    }
}
```

### 실행 결과

```
5
4
3
2
1
```

---

# Comparable 구현 객체의 정렬

스트림의 요소가 객체일 경우, 해당 객체는 **Comparable 인터페이스를 구현해야**  
`sorted()` 메소드를 사용할 수 있다.

그렇지 않으면 `ClassCastException`이 발생한다.

---

## Comparable 구현 예제

```java
import java.util.Arrays;
import java.util.List;

class Student implements Comparable<Student> {

    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override
    public int compareTo(Student o) {
        return Integer.compare(this.score, o.score); // 점수 기준 오름차순
    }
}

public class StreamSortExample3 {

    public static void main(String[] args) {

        List<Student> list = Arrays.asList(
                new Student("홍길동", 90),
                new Student("김자바", 80),
                new Student("이스트림", 70)
        );

        list.stream()
            .sorted()
            .forEach(s -> System.out.println(s.name + " : " + s.score));
    }
}
```

---

## Comparable + 내림차순

```java
import java.util.Comparator;

list.stream()
    .sorted(Comparator.reverseOrder())
    .forEach(s -> System.out.println(s.name + " : " + s.score));
```

---

# Comparator를 이용한 정렬

객체가 Comparable을 구현하지 않은 경우,  
**Comparator를 직접 제공하여 정렬 가능**

---

## Comparator 기본 형태

```java
sorted((o1, o2) -> {
    return 비교결과;
})
```

- 같으면 : 0
- o1 < o2 : 음수
- o1 > o2 : 양수

---

## 예제 코드 (람다식 Comparator)

```java
import java.util.Arrays;
import java.util.List;

class Student {

    String name;
    int score;

    Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class StreamSortExample4 {

    public static void main(String[] args) {

        List<Student> list = Arrays.asList(
                new Student("홍길동", 90),
                new Student("김자바", 80),
                new Student("이스트림", 70)
        );

        list.stream()
            .sorted((s1, s2) -> Integer.compare(s1.score, s2.score))
            .forEach(s -> System.out.println(s.name + " : " + s.score));
    }
}
```

---

## Comparator 내림차순

```java
list.stream()
    .sorted((s1, s2) -> Integer.compare(s2.score, s1.score))
    .forEach(s -> System.out.println(s.name + " : " + s.score));
```

---

## Comparator 메서드 참조 방식 (실무에서 많이 사용)

```java
import java.util.Comparator;

list.stream()
    .sorted(Comparator.comparingInt(s -> s.score))
    .forEach(System.out::println);
```

내림차순

```java
list.stream()
    .sorted(Comparator.comparingInt((Student s) -> s.score).reversed())
    .forEach(System.out::println);
```

---

## 기본 타입 스트림 정렬

```java
import java.util.Arrays;

public class StreamSortExample5 {

    public static void main(String[] args) {

        int[] arr = {5, 3, 1, 4, 2};

        Arrays.stream(arr)
              .sorted()
              .forEach(System.out::println);
    }
}
```

---

## 핵심 정리

- `sorted()` : 기본 오름차순 정렬
- `sorted(Comparator)` : 사용자 정의 정렬
- 객체 정렬 시 `Comparable` 또는 `Comparator` 필요
- `Comparator.reverseOrder()` : 내림차순
- 실무에서는 `Comparator.comparing()` 계열을 가장 많이 사용