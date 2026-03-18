## 매개 변수가 없는 람다식

> 작성 일시: **2026-03-18 오후 4:43**

함수형 인터페이스의 추상 메소드에 **매개변수가 없는 경우** 람다식은 다음과 같이 작성할 수 있다.

람다식 기본 형태

```java
() -> { 실행문; 실행문; }
```

실행문이 **두 개 이상일 경우** 중괄호 `{}` 를 생략할 수 없다.

```java
() -> {
    실행문1;
    실행문2;
}
```

실행문이 **하나일 경우** 중괄호 `{}` 를 생략할 수 있다.

```java
() -> 실행문;
```

---

## 예제 코드

매개변수가 없고 반환값이 없는 함수형 인터페이스를 정의한 뒤 람다식을 사용하는 예제이다.

```java
@FunctionalInterface
public interface MyFunctionalInterface {
    void method();
}
```

```java
public class LambdaExample {

    public static void main(String[] args) {

        MyFunctionalInterface fi;

        // 실행문이 여러 개일 경우 (중괄호 필요)
        fi = () -> {
            System.out.println("람다식 실행");
            System.out.println("매개변수가 없는 람다식");
        };
        fi.method();

        // 실행문이 하나일 경우 (중괄호 생략 가능)
        fi = () -> System.out.println("람다식 실행");
        fi.method();
    }
}
```

### 실행 결과

```
람다식 실행
매개변수가 없는 람다식
람다식 실행
```

출처:
https://www.youtube.com/watch?v=iJIktCmxPnI&list=PLVsNizTWUw7EmX1Y-7tB2EmsK6nu6Q10q&index=155