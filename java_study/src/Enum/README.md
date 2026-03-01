# 📚 열거 타입 (Enum)

> **작성 일시:** 2026-03-01 오전 10:36

---

## 1. 열거(Enum)란?

**열거(Enum)** 는 **정해진 몇 가지 값만 사용할 수 있도록 제한하는 데이터 타입**이다.


```
즉, "허용된 값만 사용하도록 강제하는 사용자 정의 타입"
```

예시 상황:

- 요일 → 월, 화, 수, 목, 금, 토, 일
- 계절 → 봄, 여름, 가을, 겨울
- 상태 → 대기, 진행중, 완료

이처럼 **값의 종류가 제한된 경우** 사용한다.

---

## 2. 왜 Enum을 사용하는가?

### ❌ Enum 없이 사용

```java
String status = "READY";
```

문제점:

- 오타 발생 가능
- 잘못된 값 저장 가능
- 타입 안정성 없음

---

### ✅ Enum 사용

```java
Status status = Status.READY;
```

장점:

- 정해진 값만 사용 가능
- 타입 안정성 보장
- 가독성 향상
- 유지보수 용이

---

# 3. Enum 선언 방법

열거 타입은 **별도의 자바 파일로 정의**한다.

---

## 📌 기본 구조

```java
enum 열거타입이름 {
    상수1, 상수2, 상수3
}
```

---

## 📌 예시

```java
enum Week {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
}
```

---

# 4. Enum 네이밍 규칙 (관례 ⭐)

## 📌 Enum 타입 이름

- 첫 글자 대문자
- CamelCase 사용

예:

```
Week
UserStatus
OrderState
```

---

## 📌 Enum 상수 이름

- 모두 대문자
- 여러 단어는 언더바(_) 사용

예:

```
READY
IN_PROGRESS
ORDER_COMPLETED
```

---

# 5. Enum 사용 방법

---

## 📌 변수 선언 및 초기화

```java
Week today = Week.MONDAY;
```

---

## 📌 비교 방법

Enum은 **== 비교 가능**하다.

(주소가 아니라 같은 상수 여부 비교)

```java
if (today == Week.MONDAY) {
    System.out.println("월요일입니다.");
}
```

---

# 6. Enum은 참조 타입이다 

Enum은 **참조 타입**이므로 다음 특징을 가진다.

- 힙(Heap)에 객체 생성
- 변수에는 주소 저장
- null 대입 가능

---

## 📌 null 가능 예시

```java
Week today = null;
```

⚠️ 주의

```java
today.name(); // NullPointerException 발생
```

---

# 7. Enum 주요 메서드

Enum에는 기본적으로 제공되는 유용한 메서드가 있다.

---

## 📌 name()

상수의 문자열 이름 반환

```java
Week day = Week.MONDAY;

System.out.println(day.name()); // MONDAY
```

---

## 📌 ordinal()

상수의 순서(인덱스) 반환 (0부터 시작)

```java
System.out.println(day.ordinal()); // 0
```

---

## 📌 values()

모든 Enum 상수 배열 반환

```java
Week[] days = Week.values();

for (Week d : days) {
    System.out.println(d);
}
```

---

## 📌 valueOf()

문자열 → Enum 변환

```java
Week day = Week.valueOf("MONDAY");
```

---

# 8. Enum 사용 예제

---

## 📌 전체 예제 코드

```java
enum Status {
    READY, RUNNING, FINISHED
}

public class EnumExample {

    public static void main(String[] args) {

        Status state = Status.READY;

        if (state == Status.READY) {
            System.out.println("준비 상태");
        }

        System.out.println(state.name());     // READY
        System.out.println(state.ordinal());  // 0

        for (Status s : Status.values()) {
            System.out.println(s);
        }
    }
}
```

---

# ⭐ 핵심 요약

```
Enum = 정해진 값만 저장 가능한 사용자 정의 타입

✔ 타입 안정성 제공
✔ 참조 타입 (null 가능)
✔ == 비교 가능

주요 메서드:
name()     → 상수 이름
ordinal()  → 순서 번호
values()   → 전체 상수 배열
valueOf()  → 문자열 → Enum 변환
```