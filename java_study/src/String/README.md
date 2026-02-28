# 🧵 문자열 타입 (String)

> **작성 일시:** 2026-02-28 오후 3:44

---

## 1. String 이란?

자바에서 문자열은 **기본 타입이 아니라 객체**이다.



```
String = 참조 타입
```

문자열은 **String 객체로 생성되며 힙(Heap) 영역에 저장**된다.

---

## 2. 문자열 생성 방법

## 📌 리터럴 방식

```java
String str1 = "hello";
String str2 = "hello";
```

✔ 특징

- 문자열 상수 풀(String Constant Pool)에 저장
- 같은 문자열은 **같은 주소 공유**

---

## 📌 new 연산자 방식

```java
String str1 = new String("hello"); // 100번지 주소
String str2 = new String("hello"); // 200번지 주소
```

✔ 특징

- 항상 **새로운 객체 생성**
- 서로 다른 주소를 가짐

---

# 3. 문자열 비교

## ❌ == 연산자

주소(참조값)를 비교한다.

```java
String a = new String("java"); // 100번지 주소
String b = new String("java"); // 200번지 주소

System.out.println(a == b); // false
```

---

## ✅ equals() 메서드

문자열 **내용 자체**를 비교한다.

```java
System.out.println(a.equals(b)); // true
```

---

## ⭐ 핵심 정리

```
==는 주소 비교
equals()는 문자열 내용 비교
```

문자열 비교는 반드시 **equals() 사용**

---

# 4. 문자열 주요 메서드

---

## 📌 문자 추출 : charAt()

특정 위치의 문자 하나를 가져온다.

```java
String str = "JAVA"; // JAVA = 0123

char ch = str.charAt(1);
System.out.println(ch); // A
```

✔ 인덱스는 0부터 시작

---

## 📌 문자열 길이 : length()

문자열의 문자 개수를 반환한다.

```java
String str = "hello";

System.out.println(str.length()); // 5
```

---

## 📌 문자열 대체 : replace()

특정 문자열을 다른 문자열로 바꾼다.

⚠️ 원본 문자열은 변경되지 않는다.

```java
String str = "hello world";

String result = str.replace("world", "java");

System.out.println(result); // hello java
System.out.println(str);    // hello world
```

---

## 📌 문자열 자르기 : substring()

문자열의 일부를 잘라서 반환한다.

```java
String str = "012345";

System.out.println(str.substring(2));    // 2345
System.out.println(str.substring(2, 5)); // 234
```

✔ 시작 인덱스 포함  
✔ 끝 인덱스 미포함

---

## 📌 문자열 찾기 : indexOf()

특정 문자열의 위치를 반환한다.

```java
String str = "Hello Java";

System.out.println(str.indexOf("Java")); // 6
```

✔ 없으면 -1 반환

---

## 📌 문자열 분리 : split()

구분자를 기준으로 문자열을 나눈다.

```java
String str = "apple,banana,orange";

String[] arr = str.split(",");

for (String s : arr) {
    System.out.println(s);
}
```

출력:

```
apple
banana
orange
```

---

# ⭐ 핵심 요약

```
String = 참조 타입 객체
문자열 비교는 반드시 equals() 사용

주요 메서드:
charAt()  → 문자 추출
length()  → 길이
replace() → 문자열 변경
substring() → 문자열 자르기
indexOf() → 위치 찾기
split() → 문자열 분리
```