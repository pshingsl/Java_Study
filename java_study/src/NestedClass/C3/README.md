## 정적 멤버 클래스 (Static Member Class)

> 작성 일시: 2026-03-23 오후 1:03

정적 멤버 클래스는 **static 키워드가 붙은 중첩 클래스**로,  
외부 클래스의 인스턴스 없이도 생성할 수 있다.

---

## 기본 구조

```java
[public] class A {

    [public | protected | (default) | private] static class B {
    }
}
```

---

## 특징

- 외부 클래스 객체 없이 생성 가능
- 외부 클래스의 **static 멤버만 직접 접근 가능**
- 인스턴스 멤버는 접근 시 외부 객체 필요

---

## 객체 생성 방법

```java
A.B b = new A.B();
```

---

## 접근 제한자에 따른 범위

| 구분 | 접근 범위 |
|------|----------|
| public static class B | 다른 패키지에서도 사용 가능 |
| static class B (default) | 같은 패키지에서만 사용 가능 |
| private static class B | A 클래스 내부에서만 사용 가능 |

---

# 예제 코드

## 1. 기본 정적 멤버 클래스

```java
class A {

    static class B {
        void method() {
            System.out.println("정적 멤버 클래스 실행");
        }
    }
}

public class StaticMemberExample1 {

    public static void main(String[] args) {

        A.B b = new A.B(); // 외부 객체 없이 생성 가능
        b.method();
    }
}
```

---

## 2. static 멤버 접근

```java
class A {

    static int staticValue = 100;

    static class B {
        void print() {
            System.out.println("static 값: " + staticValue);
        }
    }
}

public class StaticMemberExample2 {

    public static void main(String[] args) {

        A.B b = new A.B();
        b.print();
    }
}
```

---

## 3. 인스턴스 멤버 접근 (주의)

```java
class A {

    int instanceValue = 200;

    static class B {
        void print() {

            // System.out.println(instanceValue); ❌ 직접 접근 불가

            A a = new A(); // 외부 객체 생성
            System.out.println(a.instanceValue); // 가능
        }
    }
}

public class StaticMemberExample3 {

    public static void main(String[] args) {

        A.B b = new A.B();
        b.print();
    }
}
```

---

## 4. 접근 제한자 예제

```java
public class A {

    public static class PublicB {
        public void method() {
            System.out.println("public static 클래스");
        }
    }

    static class DefaultB {
        void method() {
            System.out.println("default static 클래스");
        }
    }

    private static class PrivateB {
        void method() {
            System.out.println("private static 클래스");
        }
    }

    void test() {
        PrivateB b = new PrivateB(); // 내부에서는 사용 가능
        b.method();
    }
}
```

---

## 5. 외부 접근 예제

```java
public class StaticMemberExample4 {

    public static void main(String[] args) {

        // public static 클래스
        A.PublicB publicB = new A.PublicB();
        publicB.method();

        // default static 클래스 (같은 패키지일 경우)
        A.DefaultB defaultB = new A.DefaultB();
        defaultB.method();

        // private static 클래스는 접근 불가
        // A.PrivateB privateB = new A.PrivateB(); ❌
    }
}
```

---

# 인스턴스 멤버 클래스 vs 정적 멤버 클래스

| 구분 | 인스턴스 멤버 클래스 | 정적 멤버 클래스 |
|------|----------------------|------------------|
| 생성 방식 | A 객체 필요 | 바로 생성 가능 |
| 접근 | 모든 멤버 접근 가능 | static만 직접 접근 |
| 의존성 | 외부 객체에 의존 | 독립적 |

---

# 핵심 정리

- `static` 키워드가 붙은 중첩 클래스
- 외부 객체 없이 생성 가능
- static 멤버만 직접 접근 가능
- 인스턴스 멤버 접근 시 외부 객체 필요
- 구조적으로 독립적인 내부 클래스 설계에 적합