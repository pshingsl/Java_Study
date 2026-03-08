# Math 클래스

> 작성 일시: 2026-03-08 오전 11:03 

`Math` 클래스는 **수학 계산에 필요한 다양한 메소드를 제공하는 클래스**이다.  
이 클래스의 모든 메소드는 **정적(static) 메소드**이기 때문에 **객체를 생성하지 않고 바로 사용할 수 있다.**

예

```java
Math.abs(-10);
Math.random();
```

---

# 1. Math 클래스 주요 메소드

| 구분 | 코드                             | 리턴값                           |
|---|--------------------------------|-------------------------------|
절대값 | int v1 = `Math.abs(-10)`       | v1 = `10`                     |
올림값 | double v2 = `Math.ceil(3.14)`  | v2 = `4.0`                    |
버림값 | double v3 = `Math.floor(3.99)` | v3 = `3.0`                    |
최댓값 | int v4 = `Math.max(10, 20)`    | v4 = `20`                     |
최솟값 | int v5 = `Math.min(10, 20)`    | v5 = `10`                     |
랜덤값 | double v6 = `Math.random()`    | v6 = `0.0 ~ 1.0 사이 double 난수` |
반올림값 | long v7 = `Math.round(3.6)`    | v7 = `4`                      |

---

# 예제 코드

```java
public class MathExample {

    public static void main(String[] args) {

        // 절대값
        System.out.println(Math.abs(-10)); 
        // 출력: 10

        // 올림
        System.out.println(Math.ceil(3.14));
        // 출력: 4.0

        // 버림
        System.out.println(Math.floor(3.99));
        // 출력: 3.0

        // 최댓값
        System.out.println(Math.max(10, 20));
        // 출력: 20

        // 최솟값
        System.out.println(Math.min(10, 20));
        // 출력: 10

        // 랜덤값
        System.out.println(Math.random());
        // 출력: 0.0 ~ 1.0 사이 난수

        // 반올림
        System.out.println(Math.round(3.6));
        // 출력: 4

    }
```

---

# 2. Math.random()

`Math.random()` 메소드는 **0.0 이상 1.0 미만의 double 타입 난수**를 반환한다.

```
0.0 <= random < 1.0
```

---

# 3. 특정 범위의 난수 구하기

다음 공식은 **start부터 시작하는 n개의 정수 중 하나의 난수를 생성하는 방법**이다.

```java
int num = (int)(Math.random() * n) + start;
```

범위

```
start <= num < start + n
```

---

## 예제

```java
public class RandomExample {

    public static void main(String[] args) {

        int start = 1;
        int n = 10;

        int num = (int)(Math.random() * n) + start;

        System.out.println("랜덤 숫자: " + num);

    }

}
```

출력 예

```
랜덤 숫자: 7
```

---

# 4. Random 클래스

난수를 생성하는 또 다른 방법으로 **java.util.Random 클래스**를 사용할 수 있다.

이 클래스를 이용하면 다음과 같은 타입의 난수를 생성할 수 있다.

- boolean
- int
- double

---

# 5. Random 객체 생성

| 객체 생성 | 설명 |
|---|---|
Random() | 현재 시간을 이용해 seed(종자값)을 자동 설정 |
Random(long seed) | 지정한 seed 값으로 난수 생성 |

---

# 6. seed(종자값)

**seed(종자값)** 은 난수를 생성하는 알고리즘에 사용되는 값이다.

특징

- 같은 seed 값 → 같은 난수 결과
- 테스트나 게임 로직에서 재현 가능

---

# 7. Random 클래스 주요 메소드

| 리턴 타입 | 메소드 | 설명 |
|---|---|---|
boolean | nextBoolean() | true / false 난수 |
double | nextDouble() | 0.0 ~ 1.0 사이 난수 |
int | nextInt() | int 범위 난수 |
int | nextInt(int n) | 0 ~ n 사이 난수 |

---

# 8. Random 클래스 예제

```java
import java.util.Random;

public class RandomExample {

    public static void main(String[] args) {

        Random random = new Random();

        boolean b = random.nextBoolean();
        int num1 = random.nextInt();
        int num2 = random.nextInt(10);
        double d = random.nextDouble();

        System.out.println("Boolean 난수: " + b);
        System.out.println("Int 난수: " + num1);
        System.out.println("0~9 난수: " + num2);
        System.out.println("Double 난수: " + d);

    }

}
```

---

# 9. 정리

| 구분 | 특징 |
|---|---|
Math 클래스 | 모든 메소드가 static |
Math.random() | 0.0 ~ 1.0 사이 난수 |
특정 범위 난수 | `(int)(Math.random() * n) + start` |
Random 클래스 | 다양한 타입 난수 생성 가능 |
seed | 같은 seed → 같은 난수 |