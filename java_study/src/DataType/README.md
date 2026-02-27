# 💾 자바 데이터 타입 & 메모리 구조

> **작성 일시:** 2026-02-27 오후 3:36

---

## 1. 자바 데이터 타입 분류

자바의 데이터 타입은 크게 **기본 타입(Primitive Type)** 과 **참조 타입(Reference Type)** 으로 나뉜다.

---

## ✅ 기본 타입 (Primitive Type)

값 자체를 저장하는 타입이다.

### 특징

- 변수에 **실제 값이 저장**
- 스택(Stack) 영역에 저장
- 객체가 아님

---

### 종류

#### 🔹 정수 타입
byte, short, int, long

#### 🔹 실수 타입
float, double

#### 🔹 논리 타입
boolean

---

## ✅ 참조 타입 (Reference Type)

객체의 **주소값(번지)** 을 저장하는 타입이다.

---

### 특징

- 변수에는 **주소값 저장**
- 실제 객체는 힙(Heap)에 존재
- 주소를 통해 객체에 접근

---

### 종류

- 클래스
- 배열
- 인터페이스
- 열거(Enum)
- String

---

## 2. 객체(Object)란?

객체는 **데이터와 메서드를 함께 가진 덩어리**이다.

```
객체 = 필드(데이터) + 메서드(기능)
```

객체는 **힙(Heap) 영역에 생성**된다.

---

# 🧠 3. 자바 메모리 영역

자바 프로그램 실행 시 메모리는 크게 3가지 영역으로 나뉜다.

![img.png](img.png)

---

## 📌 메소드 영역 (Method Area)

클래스 정보가 저장되는 영역이다.

### 저장 내용

- 바이트코드
- 클래스 정보
- static 변수
- 상수
- 메서드 코드
- 생성자 코드

---

## 📌 힙 영역 (Heap)

객체가 생성되는 영역이다.

### 특징

- new 키워드로 생성
- 참조 타입의 실제 데이터 저장
- 가비지 컬렉션 대상

---

## 📌 스택 영역 (Stack)

메서드 호출 시 생성되는 영역이다.

### 특징

- 메서드 호출마다 프레임 생성
- 지역 변수 저장
- 메서드 종료 시 자동 제거

---

### 스택에 저장되는 것

| 타입 | 저장 내용 |
|------|------------|
| 기본 타입 | 실제 값 |
| 참조 타입 | 객체 주소 |

---

# 🔍 4. 기본 타입 vs 참조 타입 예시

## 기본 타입

```java
int a = 10;
int b = a;

b = 20;

System.out.println(a); // 10
System.out.println(b); // 20
```

👉 값이 복사된다.

---

## 참조 타입

```java
class Student {
    int score;
}

Student s1 = new Student();
s1.score = 100;

Student s2 = s1;
s2.score = 200;

System.out.println(s1.score); // 200
System.out.println(s2.score); // 200
```

👉 주소가 복사된다.

---

# ⚖️ 5. 참조 타입 비교 연산

## 기본 타입 비교

```java
int a = 10;
int b = 10;

System.out.println(a == b); // true (값 비교)
```

---

## 참조 타입 비교

```java
Student s1 = new Student();
Student s2 = new Student();

System.out.println(s1 == s2); // false (주소 비교)
```

---

# ❗ 6. null 과 NullPointerException

## null 의미

참조 변수가 객체를 가리키지 않는 상태

```java
Student s = null;
```

---

## NullPointerException 발생

```java
Student s = null;
s.score = 10; // 예외 발생
```

👉 null 상태에서 객체를 사용하면 발생한다.

---

# ♻️ 7. 가비지 컬렉션 (GC)

어떤 변수에서도 참조하지 않는 객체는 더 이상 사용할 수 없는 객체가 된다.

이 객체는 **가비지 컬렉터(GC)** 가 자동으로 제거한다.

---

# ⭐ 핵심 요약

```
기본 타입 = 값 저장 (Stack)
참조 타입 = 주소 저장 (Stack → Heap 참조)
객체 = Heap 영역에 생성
```