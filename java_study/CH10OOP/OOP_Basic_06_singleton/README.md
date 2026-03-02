

# ✅ 17. 싱글톤 패턴

>  작성 일시: **2026-03-02  오후 7:13**

애플리케이션에서 **객체를 단 하나만 생성하도록 보장하는 설계 패턴**

즉, 프로그램 전체에서 **공유해서 사용하는 단일 객체**를 만들 때 사용한다.

---
## ✔ 왜 사용하는가?

### 1️⃣ 메모리 낭비 방지
객체를 계속 생성하지 않고 하나만 재사용한다.

예)
- DB 커넥션 관리 객체
- 설정(Config) 객체
- 로그 기록 객체

---
## ✔ 핵심 구조

- 생성자 private
- static 객체 생성
- static 메서드 제공

---

## ✔ 예시

```java
public class Singleton {

    private static Singleton instance = new Singleton();

    private Singleton() {}

    public static Singleton getInstance() {
        return instance;
    }
}
```

---

# ⭐ 한 줄 핵심 정리

> 객체 지향 프로그래밍은  
> **현실 세계처럼 객체 중심으로 프로그램을 만드는 방식이다.**