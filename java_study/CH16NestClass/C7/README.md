## 익명 객체 (Anonymous Object)

> 작성 일시: 2026-03-23 오후 3:00

익명 객체는 **이름이 없는 객체**를 의미한다.  
클래스를 따로 선언하지 않고, **즉석에서 객체를 생성**할 수 있다.

익명 객체는 **클래스를 상속하거나 인터페이스를 구현**해야만 생성할 수 있다.

---

## 특징

- 클래스 이름 없이 객체 생성
- 1회성으로 사용되는 경우에 적합
- 필드, 로컬 변수, 매개변수로 주로 사용
- 반드시 **상속 또는 인터페이스 구현 형태로 생성**

---

## 종류

| 구분 | 설명 |
|------|------|
| 익명 자식 객체 | 클래스를 상속 |
| 익명 구현 객체 | 인터페이스 구현 |

---

# 1. 익명 자식 객체

부모 클래스를 상속하여 생성

---

## 기본 구조

```java
new 부모생성자(매개값...) {

    // 필드
    // 메소드 (주로 오버라이딩)

};
```

---

## 특징

- 부모 타입으로 참조됨
- 부모 클래스의 메소드 재정의(오버라이딩) 주로 사용
- 블록 내부 멤버는 외부에서 직접 접근 불가

---

## 예제 코드

```java
class Parent {
    void method() {
        System.out.println("부모 메소드");
    }
}

public class AnonymousChildExample {

    public static void main(String[] args) {

        Parent obj = new Parent() {

            @Override
            void method() {
                System.out.println("익명 자식 객체 메소드");
            }
        };

        obj.method();
    }
}
```

---

## 매개변수로 전달하는 경우

```java
class Parent {
    void method() {
        System.out.println("부모 메소드");
    }
}

public class AnonymousChildExample2 {

    public static void action(Parent p) {
        p.method();
    }

    public static void main(String[] args) {

        action(new Parent() {
            @Override
            void method() {
                System.out.println("익명 객체 전달");
            }
        });
    }
}
```

---

# 2. 익명 구현 객체

인터페이스를 구현하여 생성

---

## 기본 구조

```java
new 인터페이스() {

    @Override
    public void method() {
        실행문;
    }

};
```

---

## 특징

- 인터페이스 타입으로 참조됨
- 반드시 모든 추상 메서드 구현
- 이벤트 처리 및 콜백에서 많이 사용

---

## 예제 코드

```java
interface RemoteControl {
    void turnOn();
    void turnOff();
}

public class AnonymousImplExample {

    public static void main(String[] args) {

        RemoteControl rc = new RemoteControl() {

            @Override
            public void turnOn() {
                System.out.println("전원 ON");
            }

            @Override
            public void turnOff() {
                System.out.println("전원 OFF");
            }
        };

        rc.turnOn();
        rc.turnOff();
    }
}
```

---

## 매개변수로 전달

```java
interface Calculator {
    int calc(int x, int y);
}

public class AnonymousImplExample2 {

    public static void execute(Calculator c) {
        System.out.println(c.calc(3, 5));
    }

    public static void main(String[] args) {

        execute(new Calculator() {
            @Override
            public int calc(int x, int y) {
                return x + y;
            }
        });
    }
}
```

---

# 3. 람다식과 비교

```java
// 익명 객체
Calculator c1 = new Calculator() {
    @Override
    public int calc(int x, int y) {
        return x + y;
    }
};

// 람다식
Calculator c2 = (x, y) -> x + y;
```

👉 함수형 인터페이스일 경우 람다식으로 대체 가능

---

# 4. 실무 활용 (이벤트 처리 패턴)

```java
interface ButtonClickListener {
    void onClick();
}

class Button {

    private ButtonClickListener listener;

    public void setListener(ButtonClickListener listener) {
        this.listener = listener;
    }

    public void click() {
        listener.onClick();
    }
}

public class AnonymousEventExample {

    public static void main(String[] args) {

        Button button = new Button();

        button.setListener(new ButtonClickListener() {
            @Override
            public void onClick() {
                System.out.println("버튼 클릭됨");
            }
        });

        button.click();
    }
}
```

---

# 핵심 정리

- 익명 객체 = 이름 없는 객체
- 클래스 선언 없이 즉석 생성
- 상속 또는 인터페이스 구현 필수
- 주로 **오버라이딩 / 이벤트 처리 / 콜백**에 사용
- 함수형 인터페이스는 람다로 대체 가능