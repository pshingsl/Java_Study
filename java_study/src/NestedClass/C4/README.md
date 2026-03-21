## 로컬 클래스 (Local Class)

로컬 클래스는 **생성자 또는 메소드 내부에서 선언되는 클래스**이다.

---

## 기본 구조

```java
[public] class A {

    // 생성자 내부
    public A() {
        class B {
        }
    }

    // 메소드 내부
    public void method() {
        class B {
        }
    }
}
```

---

## 특징

- 메소드 또는 생성자 내부에서만 사용 가능
- 해당 블록을 벗어나면 사용 불가
- 접근 제한자(public, private 등) 사용 불가
- **메소드 실행 시점에 생성됨**

---

## 사용 목적

- 특정 메소드에서만 사용하는 임시 클래스
- 외부에 노출할 필요 없는 내부 로직 캡슐화
- 익명 객체와 유사한 역할

---

# 예제 코드

## 1. 기본 로컬 클래스

```java
class A {

    void method() {

        class B {
            void print() {
                System.out.println("로컬 클래스 실행");
            }
        }

        B b = new B();
        b.print();
    }
}

public class LocalClassExample1 {

    public static void main(String[] args) {

        A a = new A();
        a.method();
    }
}
```

---

## 2. 생성자 내부 로컬 클래스

```java
class A {

    public A() {

        class B {
            void print() {
                System.out.println("생성자 내부 로컬 클래스");
            }
        }

        B b = new B();
        b.print();
    }
}

public class LocalClassExample2 {

    public static void main(String[] args) {

        new A(); // 생성자 실행
    }
}
```

---

## 3. 외부 변수 접근

로컬 클래스는 **메소드의 지역 변수 사용 가능**  
(단, final 또는 effectively final 이어야 함)

```java
class A {

    void method() {

        int value = 10; // effectively final

        class B {
            void print() {
                System.out.println("값: " + value);
            }
        }

        B b = new B();
        b.print();
    }
}

public class LocalClassExample3 {

    public static void main(String[] args) {

        new A().method();
    }
}
```

---

## 4. final / effectively final 제약

```java
class A {

    void method() {

        int value = 10;

        // value = 20; ❌ 변경하면 에러 발생

        class B {
            void print() {
                System.out.println(value);
            }
        }

        new B().print();
    }
}
```

👉 로컬 클래스에서 사용하는 지역 변수는  
**변경되지 않는(final 또는 effectively final) 상태여야 한다**

---

## 5. 로컬 클래스 + 인터페이스 활용

```java
interface Calculator {
    int calc(int x, int y);
}

class A {

    void method() {

        class LocalCalculator implements Calculator {
            public int calc(int x, int y) {
                return x + y;
            }
        }

        Calculator c = new LocalCalculator();
        System.out.println(c.calc(3, 5));
    }
}

public class LocalClassExample4 {

    public static void main(String[] args) {

        new A().method();
    }
}
```

---

# 핵심 정리

- 로컬 클래스는 **메소드 내부에서만 사용**
- 외부에서 접근 불가
- 접근 제한자 사용 불가
- 메소드 실행 시 생성
- 지역 변수는 반드시 **final 또는 effectively final**
- 특정 로직을 캡슐화할 때 유용