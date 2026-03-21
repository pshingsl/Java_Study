## 바깥 클래스의 멤버 접근

중첩 클래스는 바깥 클래스의 멤버를 사용할 수 있지만,  
**클래스 종류에 따라 접근 가능 범위가 다르다.**

---

## 접근 가능 범위

| 구분 | 바깥 클래스의 사용 가능한 멤버 |
|------|-----------------------------|
| 인스턴스 멤버 클래스 | 모든 필드 및 메소드 (인스턴스 + static) |
| 정적 멤버 클래스 | static 필드 및 static 메소드만 |

---

## 핵심 개념

- 인스턴스 멤버 클래스 → 외부 객체에 종속 → 모든 멤버 접근 가능
- 정적 멤버 클래스 → 독립적 → static만 접근 가능

👉 이유:
정적 멤버 클래스는 **외부 객체 없이도 생성 가능**하기 때문에  
인스턴스 멤버에 직접 접근할 수 없다.

---

# 예제 코드

## 1. 인스턴스 멤버 클래스 접근

```java
class A {

    int instanceField = 10;
    static int staticField = 20;

    void instanceMethod() {
        System.out.println("인스턴스 메소드");
    }

    static void staticMethod() {
        System.out.println("정적 메소드");
    }

    class B {

        void method() {

            // 모든 멤버 접근 가능
            System.out.println(instanceField);
            System.out.println(staticField);

            instanceMethod();
            staticMethod();
        }
    }
}

public class OuterAccessExample1 {

    public static void main(String[] args) {

        A a = new A();
        A.B b = a.new B();

        b.method();
    }
}
```

---

## 2. 정적 멤버 클래스 접근

```java
class A {

    int instanceField = 10;
    static int staticField = 20;

    void instanceMethod() {
        System.out.println("인스턴스 메소드");
    }

    static void staticMethod() {
        System.out.println("정적 메소드");
    }

    static class B {

        void method() {

            // System.out.println(instanceField); ❌
            // instanceMethod(); ❌

            // static만 접근 가능
            System.out.println(staticField);
            staticMethod();
        }
    }
}

public class OuterAccessExample2 {

    public static void main(String[] args) {

        A.B b = new A.B();
        b.method();
    }
}
```

---

## 3. 정적 클래스에서 인스턴스 접근 방법

```java
class A {

    int instanceField = 10;

    static class B {

        void method() {

            A a = new A(); // 외부 객체 생성
            System.out.println(a.instanceField); // 접근 가능
        }
    }
}

public class OuterAccessExample3 {

    public static void main(String[] args) {

        A.B b = new A.B();
        b.method();
    }
}
```

---

# 핵심 정리

- 인스턴스 멤버 클래스 → 외부 객체 기반 → 모든 멤버 접근 가능
- 정적 멤버 클래스 → 독립적 → static 멤버만 접근 가능
- 정적 클래스에서 인스턴스 멤버 사용 시 → 외부 객체 생성 필요
- 설계 시 "의존성 여부" 기준으로 선택