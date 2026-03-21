## 리소스로부터 스트림 얻기

`java.util.stream` 패키지에는 다양한 스트림 인터페이스가 존재한다.  
모든 스트림은 **BaseStream 인터페이스**를 부모로 가지며, 이를 기반으로 여러 하위 스트림이 제공된다.

- **Stream<T>** : 객체 요소 처리
- **IntStream** : int 타입 처리
- **LongStream** : long 타입 처리
- **DoubleStream** : double 타입 처리

BaseStream에는 모든 스트림에서 공통적으로 사용하는 메소드들이 정의되어 있다.

---

## 스트림 생성 방법 정리

| 리턴 타입 | 메소드 | 소스 |
|----------|--------|------|
| Stream<T> | Collection.stream() | List, Set |
| Stream<T> | Collection.parallelStream() | List, Set |
| Stream<T> | Arrays.stream(T[]) | 배열 |
| Stream<T> | Stream.of(T[]) | 배열 |
| IntStream | Arrays.stream(int[]) | 배열 |
| IntStream | IntStream.of(int[]) | 배열 |
| LongStream | LongStream.of(long[]) | 배열 |
| DoubleStream | DoubleStream.of(double[]) | 배열 |
| IntStream | IntStream.range() / rangeClosed() | 범위 |
| LongStream | LongStream.range() / rangeClosed() | 범위 |
| Stream<Path> | Files.list(Path) | 디렉토리 |
| Stream<String> | Files.lines(Path, Charset) | 파일 |
| IntStream | Random.ints() | 난수 |
| LongStream | Random.longs() | 난수 |
| DoubleStream | Random.doubles() | 난수 |

---

# 예제 코드

## 1. 컬렉션으로부터 스트림 얻기

`Collection` 인터페이스는 `stream()`과 `parallelStream()` 메소드를 제공한다.  
따라서 List, Set 등에서 쉽게 스트림을 생성할 수 있다.

```java
import java.util.Arrays;
import java.util.List;

public class StreamFromCollection {

    public static void main(String[] args) {

        List<String> list = Arrays.asList("Java", "Spring", "JPA");

        // 순차 스트림
        list.stream()
            .forEach(item -> System.out.println(item));

        // 병렬 스트림
        list.parallelStream()
            .forEach(item -> System.out.println(item));
    }
}
```

---

## 2. 배열로부터 스트림 얻기

```java
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamFromArray {

    public static void main(String[] args) {

        String[] arr = {"A", "B", "C"};

        // 객체 배열 → Stream
        Stream<String> stream = Arrays.stream(arr);
        stream.forEach(System.out::println);

        int[] numbers = {1, 2, 3, 4, 5};

        // 기본 타입 배열 → IntStream
        IntStream intStream = Arrays.stream(numbers);
        intStream.forEach(System.out::println);
    }
}
```

---

## 3. 숫자 범위로부터 스트림 얻기

`range()` : 끝 값 포함 X  
`rangeClosed()` : 끝 값 포함 O

```java
import java.util.stream.IntStream;

public class StreamFromRange {

    public static void main(String[] args) {

        // 1 ~ 4 (5 제외)
        IntStream.range(1, 5)
                 .forEach(System.out::println);

        System.out.println("----");

        // 1 ~ 5 (5 포함)
        IntStream.rangeClosed(1, 5)
                 .forEach(System.out::println);
    }
}
```

---

## 4. 파일로부터 스트림 얻기

`Files.lines()` 메소드를 사용하면 텍스트 파일을 **한 줄씩 스트림으로 처리**할 수 있다.

```java
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class StreamFromFile {

    public static void main(String[] args) {

        try (Stream<String> stream = Files.lines(
                Path.of("data.txt"), StandardCharsets.UTF_8)) {

            stream.forEach(line -> System.out.println(line));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

---

## 5. 난수 스트림

```java
import java.util.Random;
import java.util.stream.IntStream;

public class StreamFromRandom {

    public static void main(String[] args) {

        Random random = new Random();

        // 5개의 난수 생성
        IntStream stream = random.ints(5);

        stream.forEach(System.out::println);
    }
}
```

---

## 핵심 정리

- 스트림은 다양한 데이터 소스(컬렉션, 배열, 파일, 범위 등)로부터 생성할 수 있다.
- 객체 스트림과 기본 타입 스트림으로 구분된다.
- `stream()`은 순차 처리, `parallelStream()`은 병렬 처리에 사용된다.
- 파일 스트림은 대용량 데이터 처리에 유용하다.
- `range()`와 `rangeClosed()`는 범위 기반 스트림 생성에 사용된다.