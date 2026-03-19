## 생성자 참조 (Constructor Reference)

> 작성 일시: 2026-03-19 오후 4:23

생성자 참조는 **객체 생성을 람다식 대신 간결하게 표현하는 방법**이다.

람다식이 단순히 객체를 생성하고 반환하는 구조라면,  
이를 **생성자 참조(::new)** 로 대체할 수 있다.

---

## 기본 개념

### 람다식

```java
(a, b) -> {
    return new 클래스(a, b);
}
```

### 생성자 참조

```java
클래스명::new
```

---

## 동작 원리

- 생성자 참조는 **함수형 인터페이스와 함께 사용**
- 컴파일러는 다음 기준으로 생성자를 선택한다

👉 기준
- 매개변수 타입
- 매개변수 개수

👉 일치하는 생성자가 없으면 **컴파일 에러 발생**

---

# 예제 코드

## 1. 기본 생성자 참조

```java
import java.util.function.Supplier;

class Person {
    public Person() {
        System.out.println("Person 객체 생성");
    }
}

public class ConstructorReferenceExample1 {

    public static void main(String[] args) {

        // 람다식
        Supplier<Person> supplier1 = () -> new Person();

        // 생성자 참조
        Supplier<Person> supplier2 = Person::new;

        supplier1.get();
        supplier2.get();
    }
}
```

---

## 2. 매개변수가 있는 생성자 참조

```java
import java.util.function.Function;

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
}

public class ConstructorReferenceExample2 {

    public static void main(String[] args) {

        // 람다식
        Function<String, Person> func1 = name -> new Person(name);

        // 생성자 참조
        Function<String, Person> func2 = Person::new;

        Person p = func2.apply("홍길동");
        System.out.println(p.name);
    }
}
```

---

## 3. 두 개의 매개변수 생성자

```java
import java.util.function.BiFunction;

class Student {
    String name;
    int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}

public class ConstructorReferenceExample3 {

    public static void main(String[] args) {

        // 람다식
        BiFunction<String, Integer, Student> func1 =
                (name, score) -> new Student(name, score);

        // 생성자 참조
        BiFunction<String, Integer, Student> func2 = Student::new;

        Student s = func2.apply("김자바", 100);
        System.out.println(s.name + " : " + s.score);
    }
}
```

---

## 4. 배열 생성자 참조

```java
import java.util.function.IntFunction;

public class ConstructorReferenceExample4 {

    public static void main(String[] args) {

        // 람다식
        IntFunction<int[]> func1 = size -> new int[size];

        // 생성자 참조
        IntFunction<int[]> func2 = int[]::new;

        int[] arr = func2.apply(5);
        System.out.println(arr.length);
    }
}
```

---

## 5. 스트림에서 생성자 참조 활용

```java
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

class Person {
    String name;

    public Person(String name) {
        this.name = name;
    }
}

public class ConstructorReferenceExample5 {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("홍길동", "김자바", "이스트림");

        List<Person> people = names.stream()
                .map(Person::new) // 생성자 참조
                .collect(Collectors.toList());

        people.forEach(p -> System.out.println(p.name));
    }
}
```

---

## 핵심 정리

- 생성자 참조 = `클래스명::new`
- 람다식에서 객체 생성 부분을 간결하게 표현
- 함수형 인터페이스와 함께 사용
- 매개변수 타입과 개수에 맞는 생성자 자동 선택
- 코드 가독성 향상 및 간결화