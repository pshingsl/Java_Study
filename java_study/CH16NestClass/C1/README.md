## 중첩 클래스 (Nested Class)

중첩 클래스란 **클래스 내부에 선언된 클래스**를 의미한다.

---

## 사용 목적
- 외부 클래스의 멤버를 쉽게 접근
- 클래스 간 관계를 내부로 숨김 (캡슐화)
- 코드 복잡도 감소

---

## 중첩 클래스 종류

| 분류 | 종류 | 선언 위치 | 객체 생성 조건 |
|------|------|----------|----------------|
| 멤버 클래스 | 인스턴스 멤버 클래스 | class A { class B {} } | A 객체 생성 후 B 생성 가능 |
| 멤버 클래스 | 정적 멤버 클래스 | class A { static class B {} } | A 객체 없이 생성 가능 |
| 로컬 클래스 | 메소드 내부 클래스 | method 내부 | 메소드 실행 시 생성 가능 |

---

# 1. 인스턴스 멤버 클래스

외부 클래스의 인스턴스가 있어야 생성 가능

```java
class A {

    class B {
        void method() {
            System.out.println("인스턴스 멤버 클래스");
        }
    }
}

public class NestedExample1 {

    public static void main(String[] args) {

        A a = new A();          // 외부 객체 생성
        A.B b = a.new B();     // 내부 객체 생성

        b.method();
    }
}
```

---

# 2. 정적 멤버 클래스 (static)

외부 클래스 객체 없이 생성 가능

```java
class A {

    static class B {
        void method() {
            System.out.println("정적 멤버 클래스");
        }
    }
}

public class NestedExample2 {

    public static void main(String[] args) {

        A.B b = new A.B(); // 바로 생성 가능
        b.method();
    }
}
```

---

# 3. 로컬 클래스

메소드 내부에서 선언되는 클래스

```java
class A {

    void method() {

        class B {
            void method() {
                System.out.println("로컬 클래스");
            }
        }

        B b = new B();
        b.method();
    }
}

public class NestedExample3 {

    public static void main(String[] args) {

        A a = new A();
        a.method();
    }
}
```

---

# 4. 멤버 클래스 접근 범위

## 외부 → 내부 접근

```java
class A {

    int field = 10;

    class B {
        void print() {
            System.out.println(field); // 외부 멤버 접근 가능
        }
    }
}
```

---

## 내부 → 외부 접근

```java
class A {

    int field = 10;

    class B {
        void method() {
            System.out.println(field);
        }
    }
}
```

👉 내부 클래스는 외부 클래스의 **모든 멤버 접근 가능 (private 포함)**

---

# 5. 바이트 코드 파일 생성

중첩 클래스도 컴파일 시 별도의 `.class` 파일 생성됨

## 멤버 클래스

```
A$B.class
```

---

## 로컬 클래스

```
A$1B.class
```

👉 숫자는 컴파일러가 자동 부여

---

# 6. 활용 예제 (실무 느낌)

```java
class Outer {

    private String message = "Hello";

    class Inner {
        void print() {
            System.out.println(message);
        }
    }

    static class StaticInner {
        void print() {
            System.out.println("Static Inner Class");
        }
    }
}

public class NestedExample4 {

    public static void main(String[] args) {

        // 인스턴스 멤버 클래스
        Outer outer = new Outer();
        Outer.Inner inner = outer.new Inner();
        inner.print();

        // 정적 멤버 클래스
        Outer.StaticInner staticInner = new Outer.StaticInner();
        staticInner.print();
    }
}
```

---

# 핵심 정리

- 중첩 클래스 = 클래스 내부 클래스
- 인스턴스 멤버 클래스 → 외부 객체 필요
- 정적 멤버 클래스 → 외부 객체 없이 생성 가능
- 로컬 클래스 → 메소드 내부에서만 사용
- 내부 클래스는 외부 클래스의 모든 멤버 접근 가능
- 캡슐화 및 코드 구조 개선에 유리