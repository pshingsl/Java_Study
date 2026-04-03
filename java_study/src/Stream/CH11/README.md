## 요소 수집 (collect)

> 작성일시: 2026-04-03 오후 5:34

스트림은 요소들을 필터링 또는 매핑한 후,**최종 처리 메소드인 `collect()`를 통해 
원하는 형태로 수집**할 수 있다.

- 컬렉션(List, Set, Map)으로 변환 가능
- 그룹핑 및 집계 처리 가능

---

## collect() 기본 구조

```java
R collect(Collector<T, A, R> collector)
```

### 타입 파라미터 의미

- **T** : 스트림 요소 타입
- **A** : 누적기 (중간 처리 객체)
- **R** : 최종 결과 (컬렉션 등)

👉 의미: **T 요소들을 A를 통해 누적하여 R 결과로 만든다**

---

# 1. 기본 수집

## Collectors 메소드 종류

| 리턴 타입 | 메소드 | 설명 |
|----------|--------|------|
| Collector<T, ?, List<T>> | toList() | List로 수집 |
| Collector<T, ?, Set<T>> | toSet() | Set으로 수집 |
| Collector<T, ?, Map<K, U>> | toMap(keyMapper, valueMapper) | Map으로 수집 |

---

## 예제 코드 - List / Set / Map 수집

```java
import java.util.*;
import java.util.stream.Collectors;

public class StreamCollectExample1 {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Java", "Spring", "JPA", "Java");

        // List 수집
        List<String> toList = list.stream()
                .collect(Collectors.toList());

        // Set 수집 (중복 제거)
        Set<String> toSet = list.stream()
                .collect(Collectors.toSet());

        // Map 수집
        Map<String, Integer> toMap = list.stream()
                .collect(Collectors.toMap(
                        str -> str,
                        str -> str.length(),
                        (v1, v2) -> v1 // 중복 키 처리
                ));

        System.out.println("List: " + toList);
        System.out.println("Set: " + toSet);
        System.out.println("Map: " + toMap);
    }
}
```

---

# 2. 필터링 후 수집

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamCollectExample2 {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        List<Integer> evenList = list.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());

        System.out.println("짝수 리스트: " + evenList);
    }
}
```

---

# 3. 그룹핑 (groupingBy)

`groupingBy()`는 요소들을 특정 기준으로 묶어 **Map 형태로 반환**한다.

## 메소드

| 리턴 타입 |
|----------|
| Collector<T, ?, Map<K, List<T>>> |

---

## 예제 코드 - 기본 그룹핑

```java
import java.util.*;
import java.util.stream.Collectors;

public class StreamGroupingExample {

    static class Person {
        String name;
        int age;

        Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public String toString() {
            return name + "(" + age + ")";
        }
    }

    public static void main(String[] args) {

        List<Person> list = Arrays.asList(
                new Person("A", 10),
                new Person("B", 20),
                new Person("C", 10)
        );

        Map<Integer, List<Person>> grouped = list.stream()
                .collect(Collectors.groupingBy(Person::getAge));

        System.out.println(grouped);
    }
}
```

---

# 4. 그룹핑 + 집계

`groupingBy()`는 두 번째 매개값으로 **추가 집계 Collector**를 받을 수 있다.

---

## Collectors 주요 집계 메소드

| 메소드 | 설명 |
|--------|------|
| mapping() | 매핑 |
| averagingDouble() | 평균 |
| counting() | 개수 |
| maxBy() | 최대값 |
| minBy() | 최소값 |
| reducing() | 커스텀 집계 |

---

## 예제 코드 - 그룹별 개수

```java
import java.util.*;
import java.util.stream.Collectors;

public class StreamGroupingCountExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("A", "B", "A", "C", "B");

        Map<String, Long> result = list.stream()
                .collect(Collectors.groupingBy(
                        s -> s,
                        Collectors.counting()
                ));

        System.out.println(result);
    }
}
```

---

## 예제 코드 - 그룹별 평균

```java
import java.util.*;
import java.util.stream.Collectors;

public class StreamGroupingAvgExample {

    static class Student {
        String name;
        int score;

        Student(String name, int score) {
            this.name = name;
            this.score = score;
        }

        public int getScore() {
            return score;
        }
    }

    public static void main(String[] args) {

        List<Student> list = Arrays.asList(
                new Student("A", 80),
                new Student("B", 90),
                new Student("A", 70)
        );

        Map<String, Double> result = list.stream()
                .collect(Collectors.groupingBy(
                        s -> s.name,
                        Collectors.averagingDouble(Student::getScore)
                ));

        System.out.println(result);
    }
}
```

---

## 예제 코드 - 그룹핑 + 매핑

```java
import java.util.*;
import java.util.stream.Collectors;

public class StreamGroupingMappingExample {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("apple", "banana", "car");

        Map<Integer, List<String>> result = list.stream()
                .collect(Collectors.groupingBy(
                        String::length,
                        Collectors.mapping(s -> s.toUpperCase(), Collectors.toList())
                ));

        System.out.println(result);
    }
}
```

---

# 5. reducing()을 이용한 커스텀 집계

```java
import java.util.*;
import java.util.stream.Collectors;

public class StreamReducingExample {

    public static void main(String[] args) {

        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        int sum = list.stream()
                .collect(Collectors.reducing(0, (a, b) -> a + b));

        System.out.println("합계: " + sum);
    }
}
```

---

# 핵심 정리

- `collect()`는 스트림의 최종 결과를 생성
- `toList()`, `toSet()`, `toMap()`으로 컬렉션 변환
- `groupingBy()`로 데이터 그룹화
- `Collectors`로 다양한 집계 처리 가능
- `reducing()`으로 커스텀 집계 가능