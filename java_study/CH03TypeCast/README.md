# 🔄 타입 변환 (Type Casting)

> **작성 일시:** 2026-02-24 오후 1:23

---

## 1. 타입 변환의 개념

### 💻 타입 변환이란?

한 데이터 타입을 다른 타입으로 바꾸는 것을 의미.

프로그램에서는 다음과 같은 상황에서 타입 변환이 필요하다.

- 서로 다른 타입끼리 값을 대입할 때
- 연산을 수행할 때
- 문자열을 숫자로 바꿀 때

---

## 📍 타입 변환의 종류

자바의 타입 변환은 크게 3가지로 나뉜다.

1️⃣ 자동 타입 변환 (묵시적 형변환)  
2️⃣ 강제 타입 변환 (명시적 형변환)  
3️⃣ 문자열 ↔ 기본 타입 변환

---

# 2. 자동 타입 변환 (Implicit Casting)

## ✨ 개념

자동 타입 변환은 컴파일러가 자동으로 타입을 변환해주는 것이다.

발생 조건은 단 하나이다.

👉 작은 범위 타입 → 큰 범위 타입으로 대입할 때

즉,
작은 그릇의 물을 큰 그릇에 옮기는 것과 같다.

---

## 📊 기본 타입 크기 순서 (매우 중요 ⭐)

아래 순서는 반드시 기억해야 한다.

byte < short < int < long < float < double  
char → int 로 자동 변환

![img.png](img.png)

👉 왼쪽에서 오른쪽으로만 자동 변환 가능

---

## 💻 예제 1 — 정수 타입 자동 변환

```java
byte byteVal = 10;
int intVal = byteVal; // 자동 타입 변환
```

이유  
int가 byte보다 더 큰 값을 저장할 수 있기 때문

---

## 💻 예제 2 — 정수 → 실수 변환

```java
long longVal = 5000000L;

float floatVal = longVal;
double doubleVal = longVal;
```

실수 타입은 정수보다 더 큰 범위를 가지므로 자동 변환 발생

---

## 💻 예제 3 — char → int 변환

```java
char charVal = 'A';
int intVal = charVal;
```

결과:
intVal = 65

이유  
char는 내부적으로 유니코드 숫자로 저장되기 때문

---

# 3. 강제 타입 변환 (Explicit Casting)

## ✨ 개념

강제 타입 변환은 개발자가 직접 변환을 지정하는 것이다.

다음 상황에서 발생한다.

👉 큰 타입 → 작은 타입으로 변환할 때

즉,
큰 물통의 물을 작은 컵에 억지로 옮기는 것

이때 데이터 손실이 발생할 수 있다.

---

## 📌 문법

```java
작은타입 변수 = (작은타입)큰타입변수;
```

---

## 💻 예제

```java
int intVal = 10;
byte byteVal = (byte) intVal;
```

int(4byte) → byte(1byte) 로 줄이는 변환

---

## ⚠️ 데이터 손실 예시

```java
int intVal = 130;
byte byteVal = (byte) intVal;
```

결과:

byteVal = -126

이유  
byte 저장 범위:

-128 ~ 127

범위를 초과하면 값이 깨진다.

---

# 4. 문자열 ↔ 기본 타입 변환

## ✨ 개념

문자열은 숫자가 아니기 때문에  
연산하려면 반드시 기본 타입으로 변환해야 한다.

---

## 📌 문자열 → 기본 타입 변환

기본 문법

```java
기본타입 변수 = WrapperClass.parseXXX(문자열);
```

---

## 💻 주요 변환 메서드

byte → Byte.parseByte()  
int → Integer.parseInt()  
long → Long.parseLong()  
float → Float.parseFloat()  
double → Double.parseDouble()  
boolean → Boolean.parseBoolean()

---

## 💻 예제

```java
String str = "10";

int intVal = Integer.parseInt(str);
double doubleVal = Double.parseDouble(str);
byte byteVal = Byte.parseByte(str);
```

---

## 📌 기본 타입 → 문자열 변환

방법 1 (가장 많이 사용)

```java
String str = String.valueOf(10);
```

방법 2

```java
String str = 10 + "";
```

---

# 💡 한 줄 정리

자동 타입 변환  
→ 작은 타입 → 큰 타입  
→ 컴파일러가 자동 처리

강제 타입 변환  
→ 큰 타입 → 작은 타입  
→ 캐스팅 필요  
→ 데이터 손실 가능

문자열 변환  
→ 문자열 → parseXXX()  
→ 기본타입 → String.valueOf()

---

# 🧠 이해를 돕는 비유

작은 컵 → 큰 물통 = 자동 변환  
큰 물통 → 작은 컵 = 강제 변환  
숫자를 읽어 해석 = 문자열 변환


