## 스레드 안전 종료 (Safe Thread Termination)

스레드는 `run()` 메소드 실행이 끝나면 자동 종료된다.  
하지만 상황에 따라 **실행 중인 스레드를 안전하게 종료해야 하는 경우**가 있다.

---

## ❌ 잘못된 방법: stop()

```java
thread.stop();
```

👉 **[확실]** `Thread.stop()`은 deprecated (사용 금지)
- 이유: 실행 중 강제 종료 → **리소스 불안정 상태 발생**
- 예: 파일, DB, 네트워크 연결

---

## ✅ 안전한 종료 방식

### 1. 조건 플래그 방식
### 2. interrupt() 방식

---

# 1. 조건 플래그 방식

## 구조

```java
class WorkerThread extends Thread {

    private boolean stop = false;

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    @Override
    public void run() {

        while (!stop) {
            System.out.println("작업 실행 중...");
        }

        System.out.println("자원 정리 후 종료");
    }
}
```

---

## 실행 코드

```java
public class StopFlagExample {

    public static void main(String[] args) throws InterruptedException {

        WorkerThread thread = new WorkerThread();
        thread.start();

        Thread.sleep(3000);

        thread.setStop(true); // 종료 요청
    }
}
```

---

## 특징

- 안전하게 종료 가능
- 자원 정리 가능
- 즉시 종료는 아님 (루프 조건에 의존)

---

# 2. interrupt() 방식

## 핵심 개념

- `interrupt()` 호출 → 인터럽트 상태 설정
- `sleep()`, `wait()` 상태에서 **InterruptedException 발생**

---

## 예제 코드

```java
public class InterruptExample {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {

            try {
                while (true) {
                    System.out.println("작업 실행 중...");
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                System.out.println("인터럽트 발생 → 종료");
            }

            System.out.println("자원 정리 후 종료");
        });

        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        thread.interrupt(); // 종료 요청
    }
}
```

---

## 특징

- sleep/wait 상태에서 즉시 반응
- 예외 기반 종료 처리
- 실무에서 많이 사용

---

# 3. interrupt 상태 확인 방법

## 방법 1: static 메소드

```java
boolean status = Thread.interrupted();
```

- 현재 스레드의 인터럽트 상태 반환
- 호출 시 상태 초기화됨

---

## 방법 2: 인스턴스 메소드

```java
boolean status = thread.isInterrupted();
```

- 인터럽트 상태 확인만 (초기화 안됨)

---

## 예제 코드

```java
public class InterruptCheckExample {

    public static void main(String[] args) {

        Thread thread = new Thread(() -> {

            while (true) {

                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("인터럽트 감지 → 종료");
                    break;
                }

                System.out.println("작업 중...");
            }
        });

        thread.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        thread.interrupt();
    }
}
```

---

# 4. 핵심 차이 정리

| 방식 | 특징 | 단점 |
|------|------|------|
| 조건 플래그 | 구현 쉬움 | 즉시 종료 어려움 |
| interrupt | 즉시 반응 가능 | 예외 처리 필요 |

---

# 핵심 정리

- `stop()` → ❌ 절대 사용 금지
- 안전 종료 = **자원 정리 + 정상 종료**
- 조건 플래그 → 기본 방식
- interrupt → 실무 핵심 방식
- interrupt 상태 확인 → `isInterrupted()`

---

# 면접 핵심 포인트

- stop() deprecated 이유 설명 가능해야 함
- interrupt 동작 원리 (예외 발생 조건)
- sleep vs interrupt 관계
- 안전 종료 = graceful shutdown 개념