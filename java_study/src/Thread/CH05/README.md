## 스레드 동기화 (Thread Synchronization)

멀티 스레드 환경에서는 **여러 스레드가 하나의 객체를 공유**할 수 있다.  
이 경우, 동시에 접근하면 **데이터 불일치 문제(Race Condition)** 가 발생할 수 있다.

---

## 문제 상황

```java
count++; // 여러 스레드가 동시에 실행하면 값이 꼬일 수 있음
```

👉 원인: 동시에 접근 → 값 읽기/쓰기 충돌

---

## 해결 방법: 동기화 (Synchronization)

- 한 번에 하나의 스레드만 실행하도록 제한
- 공유 자원 보호

---

# 1. 동기화 메소드

## 선언 방법

```java
public synchronized void method() {
    // 단 하나의 스레드만 실행
}
```

---

## 특징

- 메소드 실행 시 객체에 **락(lock)** 발생
- 메소드 종료 시 락 해제
- 다른 스레드는 해당 메소드 접근 불가

---

## 예제 코드

```java
class Calculator {

    private int memory;

    public synchronized void setMemory(int value) {

        this.memory = value;

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {}

        System.out.println(Thread.currentThread().getName() + " : " + memory);
    }
}

public class SyncMethodExample {

    public static void main(String[] args) {

        Calculator calc = new Calculator();

        Thread t1 = new Thread(() -> calc.setMemory(100));
        Thread t2 = new Thread(() -> calc.setMemory(50));

        t1.start();
        t2.start();
    }
}
```

---

# 2. 동기화 블록

## 선언 방법

```java
public void method() {

    // 여러 스레드 접근 가능 영역

    synchronized(this) {
        // 단 하나의 스레드만 실행
    }

    // 여러 스레드 접근 가능 영역
}
```

---

## 특징

- 필요한 부분만 동기화 → 성능 최적화
- 특정 객체 기준으로 락 설정 가능

---

## 예제 코드

```java
class Calculator {

    private int memory;

    public void setMemory(int value) {

        synchronized(this) {
            this.memory = value;

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}

            System.out.println(Thread.currentThread().getName() + " : " + memory);
        }
    }
}
```

---

# 3. 동기화 특징

- 하나의 스레드가 락을 획득하면
    - 다른 스레드는 **동기화 메소드/블록 진입 불가**
- 일반 메소드는 실행 가능

---

# 4. wait() / notify() (스레드 협력)

두 스레드를 **교대로 실행**할 때 사용

---

## 핵심 흐름

```
Thread A 작업
   ↓
notify() → Thread B 깨움
   ↓
wait() → A 대기
   ↓
Thread B 실행
```

---

## 주요 메소드

| 메소드 | 설명 |
|--------|------|
| wait() | 현재 스레드 일시 정지 (WAITING) |
| notify() | 대기 중인 스레드 하나 깨움 |
| notifyAll() | 모든 대기 스레드 깨움 |

👉 반드시 **synchronized 내부에서만 사용 가능**

---

# 5. 교대 실행 예제

```java
class WorkObject {

    public synchronized void methodA() {

        System.out.println("ThreadA 작업");

        notify(); // 상대 스레드 깨움

        try {
            wait(); // 자신은 대기
        } catch (InterruptedException e) {}
    }

    public synchronized void methodB() {

        System.out.println("ThreadB 작업");

        notify();

        try {
            wait();
        } catch (InterruptedException e) {}
    }
}

public class WaitNotifyExample {

    public static void main(String[] args) {

        WorkObject work = new WorkObject();

        Thread t1 = new Thread(() -> {
            for(int i=0; i<5; i++) {
                work.methodA();
            }
        });

        Thread t2 = new Thread(() -> {
            for(int i=0; i<5; i++) {
                work.methodB();
            }
        });

        t1.start();
        t2.start();
    }
}
```

---

# 핵심 정리

- 동기화 = 한 번에 하나의 스레드만 실행
- `synchronized` → 락 기반 제어
- 동기화 메소드 vs 블록 → 범위 차이
- `wait()` → 스레드 일시 정지
- `notify()` → 다른 스레드 실행
- 반드시 synchronized 내부에서 사용

---

# 면접 핵심 포인트

- Race Condition 해결 방법 → synchronized
- wait()는 락을 해제, sleep()은 락 유지
- notify()는 하나, notifyAll()은 전체 깨움
- 과도한 동기화 → 성능 저하 (주의)