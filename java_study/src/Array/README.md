# 📦 배열 (Array)

> **작성 일시:** 2026-02-26 오후 3:06

---

## 1. 배열이란?

변수는 **하나의 값만 저장**할 수 있다.

만약 같은 타입의 데이터를 여러 개 저장해야 한다면 변수를 여러 개 만들어야 하는 불편함이 있다.

👉 이런 문제를 해결하기 위해 사용하는 것이 **배열(Array)** 이다.

---

## ✅ 배열의 정의



> **같은 타입의 데이터를 연속된 메모리 공간에 저장하고,
각 데이터에 인덱스(index)를 부여한 자료구조**이다.

![img.png](img.png)

- 인덱스는 **0부터 시작**
- 연속된 공간에 저장됨
- 같은 타입만 저장 가능

---

## ✅ 배열의 특징 

1. 같은 타입의 데이터만 저장 가능
2. 한 번 생성하면 **길이 변경 불가**
3. 배열 변수는 **참조 변수**
4. 실제 데이터는 힙(Heap)에 저장
5. 배열 변수는 스택(Stack)에 주소값 저장

---

## 2. 배열 선언과 생성

### 📌 배열 선언

```java
타입[] 변수명;
타입 변수명[];
```

```java
int[5] arr; // 5개의 값을 저장할 수 있는 배열 생성
```

![img_1.png](img_1.png)

---

### 📌 배열 생성

```java
변수명 = new 타입[길이];
```

예시:

```java
int[] score = new int[5]; // 5개의 값을 저장할 수 있는 배열 생성
```

---

### 📌 선언과 동시에 초기화

```java
int[] arr = new int[] {1, 2, 3, 4, 5};
int[] arr2 = {10, 20, 30, 40, 50}; // new int[] 생략 가능
```

---

## ✅ 배열의 인덱스

배열은 0부터 시작한다.

```java
score[0] = 10;
score[1] = 20;
score[2] = 30;
score[3] = 40;
score[4] = 50;
```

---

## 3. 배열과 참조 (중요 개념 ⭐)

배열 변수는 **참조 변수**이다.


- 배열 변수 → 주소값 저장
- 실제 데이터 → 힙(Heap)에 저장

---

### 📌 null 초기화 가능

```java
int[] arr = null;
```

⚠️ 주의

null 상태에서 접근하면 예외 발생

```java
arr[0] = 10;  // NullPointerException 발생
```

---

## 4. 배열의 길이

배열의 길이는 저장 가능한 항목 수를 의미한다.



```java
배열변수.length;
```



```java
int[] arr = new int[5];
System.out.println(arr.length); // 5
```

⚠️ length는 읽기만 가능, 변경 불가

---

## 5. 배열 반복 (순회)

### 📌 일반 for문

```java
for (int i = 0; i < arr.length; i++) {
    arr[i] = i;
}
```

---

### 📌 향상된 for문 (Enhanced for)

배열과 컬렉션을 더 쉽게 처리할 때 사용한다.

```java
for (타입 변수 : 배열) {
    실행문;
}
```



```java
for (int element : arr) {
    System.out.println(element);
}
```

특징:

- 인덱스 사용 불가
- 읽기 전용 반복에 적합

---

## 6. 배열 출력

배열을 그냥 출력하면 주소값이 출력된다.

```java
System.out.println(arr); 
// [I@7ad041f3 (주소값)
```

---

### 📌 값 출력 방법

1️⃣ 반복문 사용  
2️⃣ Arrays.toString() 사용

```java
import java.util.Arrays;

System.out.println(Arrays.toString(arr));
```

---

## 7. 배열 복사

배열은 생성 후 길이 변경이 불가능하다.

데이터가 많아질 경우 → 새 배열을 생성하고 복사해야 한다.

![image2.png](image2.png)

---

### 📌 직접 복사

```java
int[] arr = {1, 2, 3, 4, 5};
int[] tmp = new int[arr.length * 2];

for (int i = 0; i < arr.length; i++) {
    tmp[i] = arr[i];
}

arr = tmp;
```

---

### 📌 System.arraycopy()

```java
System.arraycopy(arr1, 0, arr2, 0, arr1.length);
```

---

### 📌 Arrays.copyOf()


```java
arr2 = Arrays.copyOf(arr1, arr1.length);
```

---

## 8. 배열 정렬

### 📌 오름차순 정렬

```java
Arrays.sort(arr);
```

---

### ⚠️ 내림차순 정렬 주의

기본 타입 배열은

```java
Arrays.sort(arr, Collections.reverseOrder());
```

❌ 사용 불가 (기본형 배열에는 적용되지 않음)

✔ 해결 방법:

```java
Integer[] arr = {3, 5, 1, 2, 4};
Arrays.sort(arr, Collections.reverseOrder());
```

→ 반드시 Wrapper 타입 사용

---

## 9. 배열 비교

### 📌 Arrays.equals()

```java
Arrays.equals(arr1, arr2);
```

값을 비교한다.

---

## 10. String 배열과 문자열 메서드

![image3.png](image3.png)

### 📌 charAt()

```java
String str = "ABCDE";
char ch = str.charAt(2); // C
```

---

### 📌 substring()

```java
String str = "012345";
String tmp = str.substring(1, 4); // 123
```

(1 이상 4 미만)

---

### 📌 char 배열 ↔ String 변환

```java
char[] chArr = {'c', 'h', 'a', 'r'};
String str = new String(chArr);

char[] tmp = str.toCharArray();
```

---
## 11. 다차원 배열 (2차원 배열)

2차원 배열은 **배열 안에 배열이 들어 있는 구조**이다.

테이블 형태 (행 × 열) 구조를 가진다.

---

### 📌 생성 방법

```java
int[][] arr = new int[4][3];
```

---

### 📌 선언과 동시에 초기화

(※ 원본 오류 수정: = 누락 보완)

```java
int[][] score = {
    {100, 100, 100},
    {20, 100, 95},
    {50, 80, 90},
    {80, 60, 100}
};
```

---

### 📌 2차원 배열 순회

```java
for (int i = 0; i < score.length; i++) {
    for (int j = 0; j < score[i].length; j++) {
        System.out.print(score[i][j] + " ");
    }
}
```



