## 중간 처리와 최종 처리



스트림은 하나 이상 연결될 수 있다.  
컬렉션의 **오리지널 스트림** 뒤에 **필터링 중간 스트림**, 그 뒤에 **매핑 중간 스트림**이 연결될 수 있다.

이와 같이 스트림이 연결된 구조를 **스트림 파이프라인(Stream Pipeline)** 이라고 한다.

---

## 스트림 파이프라인 구조

- **오리지널 스트림** : 컬렉션 또는 배열로부터 생성
- **중간 처리 (Intermediate Operation)** : 필터링, 변환, 정렬 등
- **최종 처리 (Terminal Operation)** : 반복, 집계 수행

---

## 중간 처리 (Intermediate Operation)

중간 스트림은 최종 처리를 위해 요소를 가공하는 단계이다.

- **필터링 (Filtering)** : 조건에 맞는 요소만 선택
- **매핑 (Mapping)** : 요소를 다른 형태로 변환
- **정렬 (Sorting)** : 요소 정렬

```java
list.stream()
    .filter(item -> item.length() > 3)   // 필터링
    .map(item -> item.toUpperCase())     // 매핑
    .sorted();                           // 정렬
```

※ 중간 처리는 **여러 번 연결 가능**하며,  
※ 최종 처리가 실행되기 전까지는 실제 연산이 수행되지 않는다. (지연 연산)

---

## 최종 처리 (Terminal Operation)

최종 처리는 중간 처리에서 가공된 요소들을 이용해 결과를 생성한다.

- 반복 : `forEach()`
- 집계 : `count()`, `sum()`, `average()`
- 수집 : `collect()`

```java
list.stream()
    .filter(item -> item.length() > 3)
    .forEach(item -> System.out.println(item));
```

---

## 예시 코드 (문제에서 제시된 흐름)

```java
// Student 스트림
Stream<Student> studentStream = list.stream();

// Score 스트림
IntStream scoreStream = studentStream.mapToInt(student -> student.getScore());

// 평균 계산
double avg = scoreStream.average().getAsDouble();
```

---

# 전체 예제 코드

### 1. Student 클래스

```java
public class Student {

    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
```

---

### 2. 스트림 파이프라인 예제

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {

        List<Student> list = Arrays.asList(
                new Student("홍길동", 90),
                new Student("김자바", 80),
                new Student("이스트림", 70)
        );

        // 1. 오리지널 스트림 생성
        Stream<Student> studentStream = list.stream();

        // 2. 중간 처리 (매핑: Student -> score)
        IntStream scoreStream = studentStream
                .mapToInt(student -> student.getScore());

        // 3. 최종 처리 (평균 계산)
        double avg = scoreStream
                .average()
                .getAsDouble();

        System.out.println("평균 점수: " + avg);
    }
}
```

---

### 3. 필터링 + 매핑 + 집계 예제

```java
import java.util.Arrays;
import java.util.List;

public class StreamExample2 {

    public static void main(String[] args) {

        List<Student> list = Arrays.asList(
                new Student("홍길동", 90),
                new Student("김자바", 80),
                new Student("이스트림", 70),
                new Student("박개발", 60)
        );

        double avg = list.stream()
                .filter(student -> student.getScore() >= 80) // 80점 이상 필터링
                .mapToInt(Student::getScore)                // 점수 추출
                .average()                                  // 평균 계산
                .orElse(0.0);

        System.out.println("80점 이상 평균: " + avg);
    }
}
```

---

## 실행 결과

```
평균 점수: 80.0
80점 이상 평균: 85.0
```

---

## 핵심 정리

- 스트림은 **오리지널 → 중간 처리 → 최종 처리** 구조를 가진다.
- 중간 처리는 데이터를 가공하고, 최종 처리는 결과를 만든다.
- 중간 처리는 **지연 연산(Lazy Evaluation)** 이다.
- 최종 처리가 실행되어야 전체 파이프라인이 동작한다.