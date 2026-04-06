## 스레드풀 (Thread Pool)

멀티 스레드 환경에서 스레드를 계속 생성하면  
→ **스레드 수 폭증 + CPU 과부하 + 메모리 증가 → 성능 저하**

이를 해결하기 위해 **스레드풀(Thread Pool)** 을 사용한다.

---

## 핵심 개념

- 스레드를 미리 생성해두고 재사용
- 작업 큐(Task Queue)에 작업 저장
- 스레드가 작업을 하나씩 가져와 처리

---

## 동작 구조

```
[작업 요청]
     ↓
[작업 큐]
     ↓
[스레드풀 내부 스레드들이 작업 처리]
     ↓
[작업 완료 후 재사용]
```

---

## 특징

- 스레드 생성 비용 감소
- 과도한 스레드 생성 방지
- 안정적인 성능 유지

---

# 스레드풀 생성

자바는 `java.util.concurrent` 패키지에서 제공

---

## 1. 기본 생성 방식 (Executors)

```java
ExecutorService executorService = Executors.newCachedThreadPool();
```

### 특징

| 메소드 | 설명 |
|--------|------|
| newCachedThreadPool() | 필요 시 스레드 생성, 재사용 |
| newFixedThreadPool(n) | 고정된 개수 유지 |

---

## 예시

```java
ExecutorService executor = Executors.newFixedThreadPool(3);
```

---

## 2. 상세 설정 방식 (ThreadPoolExecutor)

👉 ⚠️ 원문 오류 수정: `ThreadExecutors` ❌ → `ThreadPoolExecutor` ✔

```java
ExecutorService executor = new ThreadPoolExecutor(
    3,                      // 코어 스레드 수
    100,                    // 최대 스레드 수
    120L,                   // 유휴 시간
    TimeUnit.SECONDS,       // 시간 단위
    new SynchronousQueue<>() // 작업 큐
);
```

---

## 주요 개념

| 용어 | 설명 |
|------|------|
| 코어 스레드 | 항상 유지되는 최소 스레드 |
| 최대 스레드 | 생성 가능한 최대 스레드 |
| 작업 큐 | 대기 작업 저장 |
| 유휴 시간 | 놀고 있는 스레드 제거 시간 |

---

# 스레드풀 종료

👉 **[확실]** 스레드풀은 자동 종료되지 않음 → 반드시 종료 필요

---

## 1. 정상 종료

```java
executor.shutdown();
```

- 현재 작업 + 대기 작업 모두 처리 후 종료

---

## 2. 즉시 종료

```java
executor.shutdownNow();
```

- 실행 중 작업 interrupt
- 미처리 작업 반환

---

## 예제 코드

```java
ExecutorService executor = Executors.newFixedThreadPool(2);

for (int i = 0; i < 5; i++) {

    executor.execute(() -> {
        System.out.println(Thread.currentThread().getName() + " 작업 실행");
    });
}

executor.shutdown();
```

---

# 작업 생성 및 제출

---

## Runnable (리턴값 없음)

```java
executor.execute(() -> {
    System.out.println("Runnable 작업 실행");
});
```

---

## Callable (리턴값 있음)

```java
Future<Integer> future = executor.submit(() -> {
    return 10 + 20;
});
```

---

## 결과 받기

```java
try {
    Integer result = future.get();
    System.out.println("결과: " + result);
} catch (Exception e) {}
```

---

# Runnable vs Callable

| 구분 | Runnable | Callable |
|------|----------|----------|
| 리턴값 | 없음 | 있음 |
| 메소드 | run() | call() |
| 예외 처리 | 제한적 | throws Exception |

---

# 전체 예제 (실무형)

```java
import java.util.concurrent.*;

public class ThreadPoolExample {

    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        // Runnable 작업
        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + " Runnable 실행");
        });

        // Callable 작업
        Future<Integer> future = executor.submit(() -> {
            return 100;
        });

        System.out.println("Callable 결과: " + future.get());

        executor.shutdown();
    }
}
```

---

# 핵심 정리

- 스레드풀 = 스레드 재사용
- Executors / ThreadPoolExecutor 사용
- execute() → Runnable
- submit() → Callable + 결과 반환
- 반드시 shutdown() 호출 필요

---

# 면접 핵심 포인트

- 스레드 폭증 문제 해결 → Thread Pool
- Runnable vs Callable 차이
- Future 역할
- shutdown vs shutdownNow 차이
- ThreadPoolExecutor 직접 생성 이유 (세밀한 제어)