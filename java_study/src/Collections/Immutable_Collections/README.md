# 수정할 수 없는 컬렉션 (Immutable Collection)

> 작성 일시: 2026-03-17 오후 4:40

수정할 수 없는 컬렉션이란 **요소를 추가(add), 삭제(remove), 수정(set)할 수 없는 컬렉션**을 말한다.

즉, **컬렉션 생성 이후 데이터를 변경할 수 없다.**

이러한 컬렉션은 다음과 같은 상황에서 유용하다.

```
데이터 변경을 방지하고 싶을 때
읽기 전용 데이터로 사용할 때
불변 객체(Immutable Object)를 만들 때
```

---

# 수정 불가능 컬렉션 생성 방법

수정할 수 없는 컬렉션은 여러 가지 방법으로 만들 수 있다.

```
1. List.of(), Set.of(), Map.of()
2. copyOf()
3. Arrays.asList()
```

---

# 1. of() 메소드

`List`, `Set`, `Map` 인터페이스의 **정적 메소드 of()** 를 사용하면 수정할 수 없는 컬렉션을 생성할 수 있다.

```java
List<E> immutableList = List.of(E... elements);
Set<E> immutableSet = Set.of(E... elements);
Map<K, V> immutableMap = Map.of(K k1, V v1, K k2, V v2);
```

---

## List.of() 예제

```java
import java.util.List;

public class ImmutableListExample {

    public static void main(String[] args) {

        List<String> list = List.of("Java", "Spring", "Database");

        System.out.println(list);

        // list.add("JPA");  -> UnsupportedOperationException 발생

    }

}
```

출력

```
[Java, Spring, Database]
```

---

## Set.of() 예제

```java
import java.util.Set;

public class ImmutableSetExample {

    public static void main(String[] args) {

        Set<String> set = Set.of("Java", "Spring", "Database");

        System.out.println(set);

        // set.add("JPA"); -> 예외 발생

    }

}
```

---

## Map.of() 예제

```java
import java.util.Map;

public class ImmutableMapExample {

    public static void main(String[] args) {

        Map<String, Integer> map =
                Map.of("Java", 90,
                       "Spring", 95,
                       "Database", 85);

        System.out.println(map);

        // map.put("JPA", 88); -> 예외 발생

    }

}
```

---

# 2. copyOf()

`copyOf()` 메소드는 **기존 컬렉션을 복사하여 수정할 수 없는 컬렉션을 생성한다.**

```java
List<E> immutableList = List.copyOf(Collection<E> coll);
Set<E> immutableSet = Set.copyOf(Collection<E> coll);
Map<K, V> immutableMap = Map.copyOf(Map<K, V> map);
```

---

## copyOf() 예제

```java
import java.util.ArrayList;
import java.util.List;

public class CopyOfExample {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();

        list.add("Java");
        list.add("Spring");

        List<String> immutableList = List.copyOf(list);

        System.out.println(immutableList);

        // immutableList.add("Database"); -> 예외 발생

    }

}
```

---

# 3. Arrays.asList()

배열을 기반으로 List 컬렉션을 생성할 수 있다.

```java
String[] arr = {"A", "B", "C"};
List<String> list = Arrays.asList(arr);
```

주의

```
Arrays.asList()는 완전한 Immutable 컬렉션은 아니다.
```

특징

```
요소 추가(add) 불가
요소 삭제(remove) 불가
요소 변경(set) 가능
```

---

## Arrays.asList() 예제

```java
import java.util.Arrays;
import java.util.List;

public class ArraysAsListExample {

    public static void main(String[] args) {

        String[] arr = {"A", "B", "C"};

        List<String> list = Arrays.asList(arr);

        System.out.println(list);

        list.set(0, "Z");

        System.out.println(list);

        // list.add("D"); -> 예외 발생

    }

}
```

출력

```
[A, B, C]
[Z, B, C]
```

---

# Immutable 컬렉션 특징

```
요소 추가 불가
요소 삭제 불가
데이터 변경 방지
읽기 전용 컬렉션
```

---

# 정리

Immutable 컬렉션 생성 방법

```
List.of()
Set.of()
Map.of()
```

기존 컬렉션 복사

```
List.copyOf()
Set.copyOf()
Map.copyOf()
```

배열 기반 List

```
Arrays.asList()
```

출처:
https://www.youtube.com/watch?v=gHqjLbpXmDY&list=PLVsNizTWUw7EmX1Y-7tB2EmsK6nu6Q10q&index=153