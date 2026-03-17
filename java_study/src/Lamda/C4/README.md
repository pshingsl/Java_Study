## 리턴값이 있는 람다식

함수형 인터페이스의 추상 메소드에 **리턴값이 있을 경우** 람다식은 다음과 같이 작성할 수 있다.

람다식에서 **return 문이 하나만 존재할 경우**  
중괄호 `{}` 와 함께 `return` 키워드를 **생략할 수 있다.**

이때 리턴값은 **연산식** 또는 **리턴값이 있는 메소드 호출**로 대체할 수 있다.

---

## 기본 문법

```java
(매개변수, ...) -> {
    실행문;
    return 값;
}
```

```java
(매개변수, ...) -> 값;
```

---

## 예시 문법

### 1. 중괄호와 return 사용

```java
(x, y) -> {
    int result = x + y;
    return result;
}
```

### 2. 실행문이 return 하나일 경우 (축약형)

```java
(x, y) -> x + y
```

### 3. 메소드 호출을 리턴값으로 사용하는 경우

```java
(x, y) -> Math.max(x, y)
```

---

# 예제 코드

리턴값이 있는 람다식을 사용하는 전체 예제이다.

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

        // 1. 중괄호와 return 사용
        fi = (x, y) -> {
            int result = x + y;
            return result;
        };
        System.out.println("결과1: " + fi.method(10, 20));

        // 2. return문만 있을 경우 축약 가능
        fi = (x, y) -> x + y;
        System.out.println("결과2: " + fi.method(10, 20));

        // 3. 메소드 호출을 리턴값으로 사용
        fi = (x, y) -> Math.max(x, y);
        System.out.println("결과3: " + fi.method(10, 20));
    }
}
```

### 실행 결과

```
결과1: 30
결과2: 30
결과3: 20
```