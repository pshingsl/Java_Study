## 인스턴스 멤버 클래스 (Instance Member Class)

인스턴스 멤버 클래스는 **외부 클래스의 인스턴스에 종속되어 생성되는 중첩 클래스**이다.

---

## 기본 구조

```java
[public] class A {

    [public | protected | (default) | private] class B {
    }
}
```

---

## 특징

- 반드시 **외부 클래스 객체 생성 후** 사용 가능
- 외부 클래스의 모든 멤버 접근 가능 (private 포함)
- 객체 생성 방식

```java
A a = new A();
A.B b = a.new B();
```

---

## 접근 제한자에 따른 범위

| 구분 | 접근 범위 |
|------|----------|
| public class B | 다른 패키지에서도 사용 가능 |
| class B (default) | 같은 패키지에서만 사용 가능 |
| private class B | A 클래스 내부에서만 사용 가능 |

---

# 예제 코드

## 1. 기본 인스턴스 멤버 클래스

```java
class A {

    class B {
        void method() {
            System.out.println("인스턴스 멤버 클래스 실행");
        }
    }
}

public class InstanceMemberExample1 {

    public static void main(String[] args) {

        A a = new A();        // 외부 클래스 객체 생성
        A.B b = a.new B();   // 내부 클래스 객체 생성

        b.method();
    }
}
```

---

## 2. 외부 클래스 멤버 접근

```java
class A {

    private int value = 100;

    class B {
        void print() {
            System.out.println("외부 값: " + value); // private 접근 가능
        }
    }
}

public class InstanceMemberExample2 {

    public static void main(String[] args) {

        A a = new A();
        A.B b = a.new B();

        b.print();
    }
}
```

---

## 3. 접근 제한자 예제

```java
public class A {

    public class PublicB {
        public void method() {
            System.out.println("public 클래스");
        }
    }

    class DefaultB {
        void method() {
            System.out.println("default 클래스");
        }
    }

    private class PrivateB {
        void method() {
            System.out.println("private 클래스");
        }
    }

    void test() {
        PrivateB b = new PrivateB(); // 내부에서는 사용 가능
        b.method();
    }
}
```

---

## 4. 외부에서 접근 가능한 경우

```java
public class InstanceMemberExample3 {

    public static void main(String[] args) {

        A a = new A();

        // public 클래스 접근 가능
        A.PublicB publicB = a.new PublicB();
        publicB.method();

        // default 클래스 (같은 패키지일 경우 가능)
        A.DefaultB defaultB = a.new DefaultB();
        defaultB.method();

        // private 클래스는 접근 불가 (컴파일 에러)
        // A.PrivateB privateB = a.new PrivateB(); ❌
    }
}
```

---

# 핵심 정리

- 인스턴스 멤버 클래스는 **외부 객체에 종속**
- 객체 생성 시 `a.new B()` 형태 사용
- 외부 클래스의 모든 멤버 접근 가능 (private 포함)
- 접근 제한자에 따라 사용 범위 결정
- 캡슐화 및 내부 구현 숨김에 유리