## 중첩 인터페이스 (Nested Interface)

중첩 인터페이스는 **클래스 내부에 선언된 인터페이스**를 의미한다.

---

## 사용 목적

- 특정 클래스와 **강하게 연관된 기능 정의**
- 외부에 불필요한 인터페이스 노출 방지
- 이벤트 처리 구조 설계 (특히 UI, 콜백 구조)

---

## 기본 구조

```java
class 클래스명 {

    [public | protected | (default) | private] static interface 인터페이스명 {

        // 상수 필드
        public static final int VALUE = 10;

        // 추상 메서드
        void method();

        // 디폴트 메서드
        default void defaultMethod() {}

        // 정적 메서드
        static void staticMethod() {}
    }
}
```

---

## 특징

- 반드시 `static` 형태로 선언됨 (클래스처럼 사용)
- 클래스 없이도 인터페이스 사용 가능
- 접근 제한자에 따라 사용 범위 결정

---

## 접근 제한자

| 구분 | 접근 범위 |
|------|----------|
| public static interface | 모든 패키지에서 사용 가능 |
| static interface (default) | 같은 패키지에서만 사용 |
| private static interface | 클래스 내부에서만 사용 |

---

# 예제 코드

## 1. 기본 중첩 인터페이스

```java
class A {

    public static interface B {
        void method();
    }
}

class Impl implements A.B {

    @Override
    public void method() {
        System.out.println("중첩 인터페이스 구현");
    }
}

public class NestedInterfaceExample1 {

    public static void main(String[] args) {

        A.B obj = new Impl();
        obj.method();
    }
}
```

---

## 2. 내부 클래스에서 구현

```java
class A {

    interface B {
        void method();
    }

    class C implements B {
        public void method() {
            System.out.println("내부 클래스 구현");
        }
    }
}

public class NestedInterfaceExample2 {

    public static void main(String[] args) {

        A a = new A();
        A.C c = a.new C();

        c.method();
    }
}
```

---

## 3. 이벤트 처리 구조 (실무 느낌)

```java
class Button {

    // 중첩 인터페이스 (이벤트 리스너)
    public static interface OnClickListener {
        void onClick();
    }

    private OnClickListener listener;

    // 리스너 등록
    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    // 이벤트 발생
    public void click() {
        if (listener != null) {
            listener.onClick();
        }
    }
}

public class NestedInterfaceExample3 {

    public static void main(String[] args) {

        Button button = new Button();

        // 익명 객체로 구현
        button.setOnClickListener(new Button.OnClickListener() {
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

## 4. 람다식 활용 (함수형 인터페이스)

```java
class Button {

    public interface OnClickListener {
        void onClick();
    }

    private OnClickListener listener;

    public void setOnClickListener(OnClickListener listener) {
        this.listener = listener;
    }

    public void click() {
        listener.onClick();
    }
}

public class NestedInterfaceExample4 {

    public static void main(String[] args) {

        Button button = new Button();

        // 람다식 사용
        button.setOnClickListener(() -> System.out.println("람다 클릭 이벤트"));

        button.click();
    }
}
```

---

# 핵심 정리

- 중첩 인터페이스 = 클래스 내부 인터페이스
- 특정 클래스와 강한 연관 관계를 가질 때 사용
- 이벤트 처리(콜백 패턴)에 매우 많이 사용
- `static` 구조로 외부 객체 없이 사용 가능
- 람다식과 함께 사용 시 활용도 높음