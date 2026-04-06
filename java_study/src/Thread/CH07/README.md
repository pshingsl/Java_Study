## 데몬 스레드 (Daemon Thread)

데몬 스레드는 **주 스레드(Main Thread)를 보조하는 역할을 하는 스레드**이다.

---

## 특징

- 주 스레드가 종료되면 **자동으로 함께 종료**
- 백그라운드 작업 수행
- 주 작업을 방해하지 않음

---

## 대표적인 예

- 자동 저장 기능
- 로그 기록
- 모니터링
- 가비지 컬렉터 (GC)

👉 **[확실]** JVM의 GC는 대표적인 데몬 스레드 기반 동작

👉 워드/미디어 플레이어 예시는 개념 설명용 (구현은 다양함) → **[추정]**

---

## 데몬 스레드 설정 방법

```java
thread.setDaemon(true);
```

👉 반드시 `start()` 호출 전에 설정해야 한다.

---

## 예제 코드

```java
public class DaemonExample {

    public static void main(String[] args) {

        Thread daemonThread = new Thread(() -> {

            while (true) {
                System.out.println("데몬 스레드 실행 중...");
                
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    break;
                }
            }
        });

        daemonThread.setDaemon(true); // 데몬 스레드 설정
        daemonThread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {}

        System.out.println("메인 스레드 종료");
    }
}
```

---

## 실행 결과 흐름

```
데몬 스레드 실행 중...
데몬 스레드 실행 중...
데몬 스레드 실행 중...
메인 스레드 종료
(→ 데몬 스레드 자동 종료)
```

---

## 핵심 포인트

- 데몬 스레드는 **백그라운드 작업 전용**
- 주 스레드 종료 시 강제 종료됨 (정리 코드 실행 안될 수도 있음)
- 중요한 작업에는 사용하면 안됨

---

## 일반 스레드 vs 데몬 스레드

| 구분 | 일반 스레드 | 데몬 스레드 |
|------|------------|------------|
| 종료 조건 | run() 종료 | 주 스레드 종료 시 자동 종료 |
| 용도 | 핵심 작업 | 보조 작업 |
| 안정성 | 높음 | 낮음 |

---

## 면접 핵심 포인트

- 데몬 스레드는 **보조 역할**
- setDaemon(true)는 start() 전에 호출
- GC는 데몬 스레드 기반
- 자원 정리가 필요하면 데몬 스레드 사용 주의