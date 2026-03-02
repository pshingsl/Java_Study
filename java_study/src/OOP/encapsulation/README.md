# ✅ 15. 접근 제한자 (Access Modifier)

> **작성 일시:** 2026-03-02 오후 6:42

접근 제한자는 **클래스, 필드, 생성자, 메서드에 대한 외부 접근을 제한하는 기능**이다.

즉, 객체 내부 데이터를 보호하고  
잘못된 접근으로부터 시스템을 안전하게 유지하기 위해 사용된다.

---

## ✔ 주요 목적

### 1️⃣ 데이터 보호

객체 내부의 중요한 데이터가 외부에서 직접 수정되는 것을 방지한다.

👉 예:
- 계좌 잔액
- 비밀번호
- 사용자 정보

---

### 2️⃣ 잘못된 접근 방지

외부에서 직접 값을 변경하면  
프로그램의 정상적인 동작이 깨질 수 있다.

접근 제한자는 이를 막아 **객체의 무결성**을 유지한다.

---

## ✔ 접근 제한자의 종류

자바에는 4가지 접근 제한자가 존재한다.

| 접근 제한자 | 같은 클래스 | 같은 패키지 | 다른 패키지 | 상속 관계 |
|--------------|-------------|-------------|-------------|-------------|
| public | O | O | O | O |
| protected | O | O | X | O |
| default | O | O | X | X |
| private | O | X | X | X |

---

## ✔ 1️⃣ public

어디서든 접근 가능하다.

```java
public class Person {
    public String name;
}
```

## ✔ 2️⃣ protected

같은 패키지 + 상속 관계에서 접근 가능

```
protected int age;
```
👉 주로 상속 설계에서 사용

## 3️⃣ default (package-private)

접근 제한자를 쓰지 않으면 자동 적용된다.

같은 패키지 내부에서만 접근 가능

```
int score;   // default 접근 제한자
```

## ✔ 4️⃣ private

같은 클래스 내부에서만 접근 가능하다.

가장 강력한 보호 수준이다.

```
private String password;
```
👉 외부에서는 직접 접근 불가능

---
## 접근 제한자 사용 예시

### 🔹 잘못된 설계 (캡슐화 깨짐)
```
class Account {
public int balance;
}
```
문제

- 외부에서 마음대로 값 변경 가능
- 객체 무결성 깨짐
---


### 🔹 올바른 설계 (캡슐화 적용)
```
class Account {

    private int balance;

    public void deposit(int money) {
        balance += money;
    }

    public int getBalance() {
        return balance;
    }
}
```
####  ✔ 데이터 보호
#### ✔ 안전한 접근
#### ✔ 객체 무결성 유지

---
✔ 핵심 정리

접근 제한자는 객체 내부 데이터를 보호하고
외부의 잘못된 접근을 막아
객체의 안정성과 무결성을 유지하기 위한 기능이다.
---

# ✅ 16. Getter / Setter

객체의 필드를 직접 접근하지 않고 **메서드로 읽거나 수정하는 접근하는 방식**이다

## ✔ 왜 사용하는가? (핵심 이유 ⭐)


- 데이터 보호 -> 객체 지향 4대 특징인 캡슐화
- 잘못된 값 방지 -> 외부에서 필드를 마음대로 변경하면 객체의 상태가 망가질 수 있다.


## ✔ 기본 구조

### 🔹 Getter → 값을 "읽는" 메서드

```java
타입 get필드명() {
    return 필드;
}
```



### 🔹 Setter → 값을 "설정하는" 메서드

```java
void set필드명(타입 값) {
    this.필드 = 값;
}
```

---

## ✔ 예제 코드 (핵심 ⭐)

```java
class Student {

    private int age; // 외부 직접 접근 불가

    // Getter
    int getAge() {
        return age;
    }

    // Setter
    void setAge(int age) {

        // 유효성 검사
        if (age < 0) {
            System.out.println("나이는 음수가 될 수 없습니다.");
            return;
        }

        this.age = age;
    }
}
```

---

## ✔ 사용 방법

```java
Student s = new Student();

s.setAge(20);        // 값 설정
System.out.println(s.getAge());  // 값 조회
```

---

## ✔ 핵심 개념 정리

| 구분 | 역할 |
|------|------|
| Getter | 필드 값을 읽기 |
| Setter | 필드 값을 변경 |
| private | 외부 직접 접근 차단 |
