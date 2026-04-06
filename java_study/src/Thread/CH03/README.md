## 스레드 이름 (Thread Name)

스레드는 각각 **고유한 이름(Name)** 을 가진다.

---

## 기본 이름

- 작업 스레드는 자동으로 다음과 같은 이름이 부여된다.

```
Thread-0
Thread-1
Thread-2
...
```

---

## 스레드 이름 변경

스레드 이름은 `setName()` 메소드를 통해 변경할 수 있다.

```java
thread.setName("작업스레드-1");
```

---

## 스레드 이름 확인

현재 실행 중인 스레드 이름은 다음과 같이 확인한다.

```java
Thread thread = Thread.currentThread();
System.out.println(thread.getName());
```

👉 ⚠️ 주의: `getName` → ❌ / `getName()` → ✔

---

## 사용 목적

- 디버깅 시 어떤 스레드가 실행 중인지 확인
- 로그 추적
- 멀티 스레드 흐름 분석

---

# 예제 코드

## 1. 기본 스레드 이름 확인

```java
public class ThreadNameExample1 {

    public static void main(String[] args) {

        Thread mainThread = Thread.currentThread();

        System.out.println("현재 스레드 이름: " + mainThread.getName());
    }
}
```

---

## 2. 작업 스레드 이름 변경

```java
public class ThreadNameExample2 {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {
            System.out.println("실행 중인 스레드: " + Thread.currentThread().getName());
        });

        thread.setName("Worker-Thread");
        thread.start();
    }
}
```

---

## 3. 여러 스레드 이름 확인

```java
public class ThreadNameExample3 {

    public static void main(String[] args) {

        for (int i = 0; i < 3; i++) {

            Thread thread = new Thread(() -> {
                System.out.println("현재 스레드: " + Thread.currentThread().getName());
            });

            thread.start();
        }
    }
}
```

---

## 4. 이름 지정 + 디버깅 활용

```java
public class ThreadNameExample4 {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 실행");
        });

        Thread t2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " 실행");
        });

        t1.setName("DB-Thread");
        t2.setName("API-Thread");

        t1.start();
        t2.start();
    }
}
```

---

# 핵심 정리

- 스레드는 기본적으로 `Thread-n` 이름을 가짐
- `setName()`으로 이름 변경 가능
- `Thread.currentThread().getName()`으로 현재 스레드 확인
- 디버깅 및 로그 추적에서 매우 중요