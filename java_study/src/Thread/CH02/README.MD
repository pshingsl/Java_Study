## 작업 스레드 생성과 실행

멀티 스레드 프로그램을 개발하려면  
**병렬로 실행할 작업 수를 결정 → 각 작업별 스레드 생성**이 필요하다.

---

## 핵심 개념

- 자바 프로그램은 기본적으로 **메인 스레드(main thread)** 를 가진다.
- 추가 작업이 필요하면 **작업 스레드(worker thread)** 를 생성해야 한다.
- 스레드는 객체로 관리되며 `Thread` 클래스를 사용한다.

---

# 1. Thread + Runnable 방식 (권장)

## 구조

```java
Thread thread = new Thread(Runnable target);
```

---

## Runnable 인터페이스

```java
interface Runnable {
    void run();
}
```

👉 `run()` 메소드에 **실행할 작업 코드 작성**

---

## 1-1. 구현 클래스 방식

```java
class Task implements Runnable {

    @Override
    public void run() {
        System.out.println("작업 스레드 실행");
    }
}

public class ThreadExample1 {

    public static void main(String[] args) {

        Runnable task = new Task();     // 작업 정의
        Thread thread = new Thread(task); // 스레드 생성

        thread.start(); // 스레드 실행
    }
}
```

---

## 1-2. 익명 객체 방식

```java
public class ThreadExample2 {

    public static void main(String[] args) {

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("익명 스레드 실행");
            }
        });

        thread.start();
    }
}
```

👉 ✔ 원문에 "사용할 수 없다"는 내용은 잘못됨 → **사용 가능함**

---

## 1-3. 람다식 (실무 최다 사용)

```java
public class ThreadExample3 {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("람다 스레드 실행");
        });

        thread.start();
    }
}
```

👉 Runnable은 **함수형 인터페이스 → 람다 가능**

---

# 2. Thread 상속 방식

## 구조

```java
class WorkerThread extends Thread {

    @Override
    public void run() {
        System.out.println("스레드 실행");
    }
}
```

---

## 사용

```java
public class ThreadExample4 {

    public static void main(String[] args) {

        Thread thread = new WorkerThread();
        thread.start();
    }
}
```

---

## 익명 자식 객체

```java
public class ThreadExample5 {

    public static void main(String[] args) {

        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println("익명 자식 스레드 실행");
            }
        };

        thread.start();
    }
}
```

---

# start() vs run()

```java
thread.start(); // 새로운 스레드 생성 후 run() 실행
thread.run();   // 단순 메소드 호출 (멀티스레드 아님)
```

👉 반드시 `start()` 호출해야 멀티 스레드 실행

---

# 실행 흐름

```
main 스레드
    │
    ├─ thread.start()
    │       │
    │       ▼
    │   새로운 스레드 생성
    │       │
    │       ▼
    │   run() 실행
```

---

# Thread vs Runnable

| 구분 | Runnable | Thread |
|------|----------|--------|
| 구조 | 인터페이스 | 클래스 |
| 확장성 | 높음 (다른 클래스 상속 가능) | 낮음 |
| 권장 여부 | ⭐ 권장 | 비권장 |
| 실무 사용 | 매우 많음 | 거의 없음 |

---

# 핵심 정리

- 스레드는 `Thread` 객체로 생성
- 실행은 반드시 `start()` 호출
- `Runnable` 방식이 표준 (실무 기준)
- 익명 객체 및 람다식으로 간단하게 작성 가능
- `run()` 직접 호출하면 멀티 스레드 아님