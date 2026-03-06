# 문자열 클래스 (String, StringBuilder, StringTokenizer) 

>작성 일시: 2026-03-06 오후 2:44

자바에서 문자열을 다루기 위해 대표적으로 사용하는 클래스는 다음과 같다.

- String → 문자열 저장 및 기본적인 조작
- StringBuilder → 효율적인 문자열 변경 작업
- StringTokenizer → 구분자를 기준으로 문자열 분리

---

# 1. String 클래스

String 클래스는 문자열을 저장하고 조작할 때 사용한다.

문자열 리터럴은 자동으로 String 객체로 생성된다.

```java
String str = "Hello";
```

또한 생성자를 이용해서 직접 객체를 생성할 수도 있다.

---

## byte 배열 → 문자열 변환

프로그램을 개발하다 보면 byte 배열을 문자열로 변환해야 하는 경우가 있다.

  
네트워크 통신으로 받은 byte 데이터를 문자열로 변환

### 문법
```java
// 기본 문자셋으로 byte배열을 디코딩해서 String 객체로 생성
String str = new String(byte[] bytes);

//특정 문자셋으로 byte배열을 디코딩해서 String 객체로 생성
Stirng str = new String(byte[] bytes, String charseName);

```

### 💻 예제 코드
```java
// 기본 문자셋으로 byte 배열을 디코딩
byte[] bytes = {72, 101, 108, 108, 111};
String str = new String(bytes);

System.out.println(str); // Hello
```

특정 문자셋을 지정할 수도 있다.

```java
byte[] bytes = {72, 101, 108, 108, 111};

// UTF-8 문자셋으로 디코딩
String str = new String(bytes, "UTF-8");

System.out.println(str);
```

---

# 2. StringBuilder 클래스

String 객체는 내부 문자열을 수정할 수 없는 **불변 객체(Immutable)** 이다.

```java
String str = "Hello";
str = str + " World";
```

위 코드에서는 다음 과정이 발생한다.

1. 새로운 String 객체 생성
2. 기존 객체는 버려짐

따라서 문자열 변경이 많으면 **비효율적이다.** 이럴 때 사용하는 것이 **StringBuilder** 이다.

StringBuilder는 내부 버퍼(데이터를 저장하는 메모리)에서 문자열을 저장해두고 **문자열 안에서 저장, 수정, 삭제** 작업을 하도록 설계

따라서 String처럼 **새로운 객체를 생성하지 않고도 문자열 조작할 수 있다..**

---

## StringBuilder 기본 사용 예제

```java
StringBuilder sb = new StringBuilder();

sb.append("Hello");
sb.append(" ");
sb.append("World");

System.out.println(sb.toString());
```

출력

```
Hello World
```

---

## 주요 메소드

| 리턴 타입 | 메소드 | 설명 |
|---|---|---|
StringBuilder | append(값) | 문자열 끝에 추가 |
StringBuilder | insert(위치, 값) | 지정 위치에 문자열 추가 |
StringBuilder | delete(시작, 끝) | 문자열 일부 삭제 |
StringBuilder | replace(시작, 끝, 문자열) | 문자열 일부 변경 |
String | toString() | 완성된 문자열 반환 |

toString()을 제외한 다른 메소드는 StringBuilder를 다시 리턴하기 때문에 연이어서 다른 메소드를 호출할 수 있는 메소드 체이닝 패턴을 사용할 수 있다.

---

## 메소드 체이닝 예제

StringBuilder 메소드는 대부분 **자기 자신을 리턴**하기 때문에 체이닝이 가능하다.

```java
StringBuilder sb = new StringBuilder();

sb.append("Java")
  .append(" ")
  .append("Study")
  .append(" ")
  .append("Start");

System.out.println(sb.toString());
```

출력

```
Java Study Start
```

---

# 3. StringTokenizer 클래스

문자열이 특정 구분자로 연결되어 있을 때 구분자를 기준으로 문자열을 분리하는 클래스이다.

예

```
홍길동/박연수/최은하
```

---

## StringTokenizer 생성

```java
String data = "홍길동/박연수/최은하";

StringTokenizer st = new StringTokenizer(data, "/");
```

- 첫 번째 매개값 → 전체 문자열
- 두 번째 매개값 → 구분자

구분자를 생략하면 **공백이 기본 구분자**가 된다.

---

## 주요 메소드

| 리턴 타입 | 메소드 | 설명 |
|---|---|---|
int | countTokens() | 분리된 문자열 개수 |
boolean | hasMoreTokens() | 남아있는 문자열 존재 여부 |
String | nextToken() | 다음 문자열 반환 |


nextToken()메소드는 분리된 문자열을 하나씩 가져오고, 더 이상 가져올 문자열이 없다면 예외를 발생시킴

nextToken() 사용하기전에 hasMoreTokens() 메소드로 가져올 문자열이 있는지 먼저 검사하는게 좋다.

---

## StringTokenizer 예제

```java
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) {

        String data = "홍길동/박연수/최은하";

        StringTokenizer st = new StringTokenizer(data, "/");

        while (st.hasMoreTokens()) {
            String name = st.nextToken();
            System.out.println(name);
        }

    }

}
```

출력

```
홍길동
박연수
최은하
```

---

# 4. split() 과 StringTokenizer 차이

문자열 분리는 다음 두 가지 방법이 있다.

### split()

정규표현식을 사용한다.

```java
String data = "홍길동&이수홍,박연수,김은수-최은하";

String[] names = data.split("&|,|-");

for(String name : names){
    System.out.println(name);
}
```

---

### StringTokenizer

문자 단위 구분자 처리

```java
String data = "홍길동/박연수/최은하";

StringTokenizer st = new StringTokenizer(data, "/");
```

---

# 정리

| 클래스 | 특징 |
|---|---|
String | 문자열 저장 및 기본 조작 |
StringBuilder | 문자열 변경 작업이 많을 때 효율적 |
StringTokenizer | 구분자를 기준으로 문자열 분리 |