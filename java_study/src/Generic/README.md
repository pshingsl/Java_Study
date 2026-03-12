# 제네릭 (Generic)

> 작성 일시: 2026-03-12 오후 3:10 

제네릭(Generic)은 **결정되지 않은 타입을 파라미터로 처리하고 실제 사용할 때 구체적인 타입으로 대체하는 기능**이다.

제네릭을 사용하면 **타입 안정성을 높이고 불필요한 형변환을 줄일 수 있다.**

---

# 1. 제네릭이 필요한 이유

다음과 같이 Box 클래스를 선언한다고 가정한다.

```java
public class Box {
    public Object content;
}
```

`Object` 타입은 모든 클래스의 최상위 부모 클래스이므로 어떤 객체든 저장할 수 있다.

```java
Box box = new Box();
box.content = "문자열";
box.content = 100;
box.content = new Object();
```

하지만 문제는 **값을 꺼낼 때 발생한다.**

```java
String content = (String) box.content;
```

`content`의 타입이 `Object`이기 때문에 **강제 타입 변환이 필요하다.**

또한 잘못된 타입 변환을 하면 **런타임 오류(ClassCastException)** 가 발생할 수 있다.

이 문제를 해결하기 위해 **제네릭(Generic)** 을 사용한다.

---

# 2. 제네릭 타입 (Generic Type)

제네릭 타입은 **타입 파라미터를 가지는 클래스 또는 인터페이스**를 의미한다.

예시

```java
public class Box<T> {
    public T content;
}
```

설명

```
<T> → 타입 파라미터
T → 실제 사용할 때 타입으로 대체됨
```



## 제네릭 사용 예

```java
public class Box<T> {
    public T content;
}
```

사용

```java
public class GenericExample {

    public static void main(String[] args) {

        Box<String> box = new Box<String>();

        box.content = "박스1";

        String content = box.content;

        System.out.println(content);

    }

}
```

출력

```
박스1
```

특징

- 타입 안정성 확보
- 형변환 필요 없음

---

# 3. 제네릭 타입 선언

제네릭 타입은 **클래스 또는 인터페이스 선언 시 타입 파라미터를 정의한다.**

일반적으로 대문자 알파벳 한 글자로 표현한다.

**만약 지정하지 않으면 Object타입으로 암묵적으로 사용된다.**(GenericEx 참고)


```java
public class 클래스명<A, B, ...> {}
public interface 인터페이스명<A, B, ...> {}
```

예시

```java
public class Pair<K, V> {

    private K key;
    private V value;

    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

}
```

사용

```java
Pair<String, Integer> pair = new Pair<>("age", 20);

System.out.println(pair.getKey());
System.out.println(pair.getValue());
```

출력

```
age
20
```

---

# 4. 제네릭 메소드 (Generic Method)

제네릭 메소드는 **메소드 자체가 타입 파라미터를 가지는 메소드**이다.

제네릭 타입과 차이점

```
제네릭 타입 → 클래스 전체에서 사용
제네릭 메소드 → 메소드 내부에서만 사용
```

문법

```java
public <T> 리턴타입 메소드명(매개변수) {}
```

예시

```java
public class GenericMethodExample {

    public static <T> Box<T> boxing(T t) {

        Box<T> box = new Box<>();
        box.content = t;

        return box;

    }

}
```

사용

```java
Box<Integer> box1 = GenericMethodExample.boxing(100);
Box<String> box2 = GenericMethodExample.boxing("문자열");

System.out.println(box1.content);
System.out.println(box2.content);
```

출력

```
100
문자열
```

설명

```
100 → Integer 타입으로 자동 변환
문자열 → String 타입으로 처리
```

---

# 5. 제한된 타입 파라미터 (Bounded Type Parameter)

경우에 따라 **타입 파라미터를 특정 타입으로 제한할 수 있다.**

**모든 타입으로 대체할 수 없고, 특정 타입과 자식 또는 구현 관계에 있는 타입**만 대체할 수 있는
**타입 파리미터를 제한된 타입 파라미터**라고 한다.


문법

```java
<T extends 상위타입>
```

예시

```java
public class Util {

    public static <T extends Number> boolean compare(T t1, T t2) {

        double v1 = t1.doubleValue();
        double v2 = t2.doubleValue();

        return v1 == v2;

    }

}
```

사용

```java
boolean result = Util.compare(10, 10);

System.out.println(result);
```

출력

```
true
```

설명

```
T는 Number 또는 Number의 자식 클래스만 가능
```

예

```
Integer
Double
Long
Short
Byte
```

---

# 6. 와일드카드 타입 (Wildcard)

제네릭 타입을 사용할 때 **타입을 제한하기 위해 와일드카드(?)** 를 사용할 수 있다.

```
? → 어떤 타입이든 가능
```

---

## 1. 모든 타입 허용

```java
List<?> list
```

예시

```java
public static void printList(List<?> list) {

    for (Object obj : list) {
        System.out.println(obj);
    }

}
```

---

## 2. 상한 제한 (Upper Bound)

특정 타입 **또는 자식 타입만 허용**

문법

```java
<? extends 타입>
```

예시

```java
public static void printStudents(List<? extends Student> list) {

    for (Student s : list) {
        System.out.println(s);
    }

}
```

가능

```
Student
HighStudent
MiddleStudent
```

---

## 3. 하한 제한 (Lower Bound)

특정 타입 **또는 부모 타입만 허용**

문법

```java
<? super 타입>
```

예시

```java
public static void registerWorker(List<? super Worker> list) {

    System.out.println("등록 완료");

}
```

가능

```
Worker
Person
Object
```

---

# 7. 정리

| 개념 | 설명 |
|---|---|
Generic | 타입을 파라미터로 처리하는 기능 |
Generic Type | 타입 파라미터를 가지는 클래스/인터페이스 |
Generic Method | 메소드에 타입 파라미터 정의 |
Bounded Type | 특정 타입으로 제한된 제네릭 |
Wildcard | 제네릭 타입 범위를 지정하는 기호 |

---

# 핵심 정리

```
제네릭 목적

1. 타입 안정성 확보
2. 형변환 제거
3. 코드 재사용 증가
```