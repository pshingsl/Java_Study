## 매개 변수가 있는 람다식

함수형 인터페이스의 추상 메소드에 **매개변수가 있을 경우** 람다식은 다음과 같이 작성할 수 있다.

매개변수를 선언할 때 **타입을 생략할 수 있으며**, 구체적인 타입 대신 **var** 를 사용할 수도 있다.  
하지만 일반적으로 **타입을 생략하는 방식이 가장 많이 사용된다.**

---

## 1. 타입을 명시한 람다식

```java
(타입 매개변수, ...) -> {
    실행문;
    실행문;
}

(타입 매개변수, ...) -> 실행문
```

예시

```java
(int x, int y) -> {
    int result = x + y;
    System.out.println(result);
}

(int x, int y) -> x + y
```

---

## 2. var를 사용하는 람다식

Java 11부터 매개변수 타입 대신 **var** 를 사용할 수 있다.

```java
(var 매개변수, ...) -> {
    실행문;
    실행문;
}

(var 매개변수, ...) -> 실행문
```

예시

```java
(var x, var y) -> {
    int result = x + y;
    System.out.println(result);
}

(var x, var y) -> x + y
```

---

## 3. 타입을 생략한 람다식 (가장 일반적인 형태)

```java
(매개변수, ...) -> {
    실행문;
    실행문;
}

(매개변수, ...) -> 실행문
```

예시

```java
(x, y) -> {
    int result = x + y;
    System.out.println(result);
}

(x, y) -> x + y
```

---

## 4. 매개변수가 하나일 경우

매개변수가 **하나일 경우 괄호 `()` 를 생략할 수 있다.**

단, 이 경우 **타입 또는 var를 사용할 수 없다.**

```java
매개변수 -> {
    실행문;
    실행문;
}

매개변수 -> 실행문;
```

예시

```java
x -> {
    System.out.println(x);
    System.out.println(x * 2);
}

x -> x * 2
```

---

# 예제 코드

매개변수가 있는 람다식을 사용하는 전체 예제이다.

```java
@FunctionalInterface
interface MyFunctionalInterface {
    int method(int x, int y);
}
```

```java
public class LambdaExample {

    public static void main(String[] args) {

        MyFunctionalInterface fi;

        // 타입 명시
        fi = (int x, int y) -> {
            return x + y;
        };
        System.out.println("결과1: " + fi.method(10, 20));

        // var 사용
        fi = (var x, var y) -> {
            return x + y;
        };
        System.out.println("결과2: " + fi.method(10, 20));

        // 타입 생략
        fi = (x, y) -> {
            return x + y;
        };
        System.out.println("결과3: " + fi.method(10, 20));

        // 실행문 하나 (중괄호 생략)
        fi = (x, y) -> x + y;
        System.out.println("결과4: " + fi.method(10, 20));
    }
}
```

### 실행 결과

```
결과1: 30
결과2: 30
결과3: 30
결과4: 30
```