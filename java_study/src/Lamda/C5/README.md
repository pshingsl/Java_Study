## 메소드 참조 (Method Reference)

> 작성 일시: 2026-03-19 오후 3:33

메소드 참조는 **메소드를 직접 참조하여 람다식을 더욱 간결하게 표현하는 방법**이다.  
람다식이 단순히 **기존 메소드를 호출하는 역할만 할 경우**, 메소드 참조를 사용하면  
**불필요한 매개변수 표현을 제거를 하는 것을 목저으로 한다..**

예를 들어 다음과 같은 람다식이 있다.

```java
(x, y) -> Math.max(x, y)
```

이 람다식은 단순히 두 값을 `Math.max()` 메소드의 매개값으로 전달하는 역할만 한다.  

이 경우 **메소드 참조**를 사용하면 더 간결하게 표현할 수 있다.

```java
Math::max
```

---

# 정적 메소드 참조

정적 메소드를 참조할 경우 **클래스 이름 뒤에 `::` 기호를 붙이고 정적 메소드 이름을 작성한다.**

```java
클래스::메소드
```

예시

```java
Math::max
```

---

# 인스턴스 메소드 참조

인스턴스 메소드를 참조할 경우 **객체(참조 변수) 뒤에 `::` 기호를 붙이고 메소드 이름을 작성한다.**

```java
참조변수::메소드
```

예시

```java
calculator::add
```

---

# 예제 코드 (정적 메소드 참조 / 인스턴스 메소드 참조)

```java
@FunctionalInterface
interface MyFunctionalInterface {
    int method(int x, int y);
}
```

```java
class Calculator {

    // 인스턴스 메소드
    public int add(int x, int y) {
        return x + y;
    }
}
```

```java
public class MethodReferenceExample {

    public static void main(String[] args) {

        MyFunctionalInterface fi;

        // 람다식 사용
        fi = (x, y) -> Math.max(x, y);
        System.out.println("결과1: " + fi.method(10, 20));

        // 정적 메소드 참조
        fi = Math::max;
        System.out.println("결과2: " + fi.method(10, 20));

        // 인스턴스 메소드 참조
        Calculator calculator = new Calculator();
        fi = calculator::add;
        System.out.println("결과3: " + fi.method(10, 20));
    }
}
```

### 실행 결과

```
결과1: 20
결과2: 20
결과3: 30
```

---

# 매개변수의 메소드 참조

람다식에서 **첫 번째 매개변수의 메소드를 호출하고 두 번째 매개변수를 전달하는 경우**  
메소드 참조로 다음과 같이 표현할 수 있다.

람다식

```java
(a, b) -> {
    a.instanceMethod(b);
}
```

메소드 참조

```java
클래스::instanceMethod
```

---

# 예제 코드 (매개변수 메소드 참조)

```java
@FunctionalInterface
interface MyFunctionalInterface2 {
    int method(String a, String b);
}
```

```java
public class ParameterMethodReferenceExample {

    public static void main(String[] args) {

        MyFunctionalInterface2 fi;

        // 람다식
        fi = (a, b) -> a.compareToIgnoreCase(b);
        System.out.println(fi.method("Java", "java"));

        // 매개변수 메소드 참조
        fi = String::compareToIgnoreCase;
        System.out.println(fi.method("Java", "java"));
    }
}
```

### 실행 결과

```
0
0
```****