## 스레드 상태 (Thread State)

스레드는 생성부터 종료까지 여러 상태를 거친다.

---

## 스레드 상태 흐름

```
NEW (생성)
   │
   ▼
RUNNABLE (실행 대기)
   │
   ▼
RUNNING (실행)
   │
   ├──────────────┐
   ▼              │
WAITING /         │
TIMED_WAITING /   │
BLOCKED           │
(일시 정지 상태)   │
   │              │
   └───────▶ RUNNABLE
                     │
                     ▼
               TERMINATED (종료)
```

---

## 상태 설명

| 상태 | 설명 |
|------|------|
| NEW | 스레드 객체 생성 |
| RUNNABLE | 실행 대기 상태 (CPU 점유 대기) |
| RUNNING | CPU를 점유하여 실행 중 |
| WAITING | 다른 스레드를 기다림 |
| TIMED_WAITING | 일정 시간 동안 대기 |
| BLOCKED | 동기화 락 획득 대기 |
| TERMINATED | 실행 종료 |

---

## 핵심 흐름

- `start()` 호출 → RUNNABLE 상태
- CPU 스케줄링 → RUNNING
- `run()` 종료 → TERMINATED

---

# 일시 정지 상태 관련 메소드

| 구분 | 메소드 | 설명 |
|------|--------|------|
| 일시 정지 | sleep() | 일정 시간 동안 정지 |
| 일시 정지 | join() | 다른 스레드 종료까지 대기 |
| 일시 정지 | wait() | 객체 락 반납 후 대기 |
| 일시 정지 | synchronized | 락 대기 시 BLOCKED 상태 |
| 정지 해제 | interrupt() | sleep/wait 상태 깨움 |
| 정지 해제 | notify() / notifyAll() | wait 상태 해제 |
| 양보 | yield() | 다른 스레드에게 CPU 양보 |

---

# 1. sleep() (일정 시간 정지)

```java
public class SleepExample {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {

            try {
                System.out.println("1초 대기 시작");
                Thread.sleep(1000); // 1초 정지
                System.out.println("다시 실행");
            } catch (InterruptedException e) {
                System.out.println("인터럽트 발생");
            }
        });

        thread.start();
    }
}
```

👉 `sleep()` → TIMED_WAITING 상태

---

# 2. join() (다른 스레드 기다림)

```java
public class JoinExample {

    public static void main(String[] args) throws InterruptedException {

        Thread thread = new Thread(() -> {
            System.out.println("작업 스레드 실행");
        });

        thread.start();
        thread.join(); // 해당 스레드 종료까지 대기

        System.out.println("메인 스레드 실행");
    }
}
```

👉 join() 호출한 스레드가 WAITING 상태가 됨

---

# 3. yield() (CPU 양보)

```java
public class YieldExample {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {

            boolean work = false;

            while (true) {

                if (work) {
                    System.out.println("작업 수행");
                } else {
                    Thread.yield(); // 다른 스레드에게 양보
                }
            }
        });

        thread.start();
    }
}
```

👉 실행 중 → RUNNABLE 상태로 돌아감

---

# 4. wait / notify (동기화 제어)

```java
class WorkObject {

    public synchronized void methodA() {

        System.out.println("ThreadA 작업");

        notify(); // 다른 스레드 깨움

        try {
            wait(); // 대기 상태 진입
        } catch (InterruptedException e) {
        }
    }

    public synchronized void methodB() {

        System.out.println("ThreadB 작업");

        notify();

        try {
            wait();
        } catch (InterruptedException e) {
        }
    }
}
```

👉 wait() → WAITING 상태  
👉 notify() → WAITING → RUNNABLE

---

# 핵심 정리

- `start()` → RUNNABLE → RUNNING → TERMINATED 흐름
- sleep(), join(), wait() → 일시 정지 상태
- interrupt(), notify() → 다시 실행 가능
- yield() → CPU 양보
- 멀티스레드 핵심은 **상태 전이 + 제어**

---

# 면접 핵심 포인트

- RUNNABLE에는 RUNNING 포함 개념 (JVM 관점)
- BLOCKED vs WAITING vs TIMED_WAITING 구분
- wait()는 반드시 synchronized 내부에서 사용
- sleep()은 락을 놓지 않지만 wait()는 락을 놓는다