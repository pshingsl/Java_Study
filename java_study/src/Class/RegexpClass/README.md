# 정규 표현식 (Regular Expression)

> 작성 일시: 2026-03-11 오후 4:13

정규 표현식(Regular Expression)은 **문자열이 특정 형식에 맞는지 검증하기 위한 패턴 문자열**이다.

예를 들어 다음과 같은 데이터를 검증할 때 사용한다.

- 이메일 형식 검증
- 전화번호 형식 검증
- 비밀번호 규칙 검증
- 주민번호 / 우편번호 검증

자바에서는 **정규 표현식을 이용하여 문자열이 특정 패턴에 맞는지 검사할 수 있다.**

---

# 1. 정규 표현식 작성 방법

정규 표현식은 **문자, 숫자, 특수기호, 반복 기호를 조합하여 문자열 패턴을 정의하는 방식**이다.

---

# 2. 정규 표현식 주요 표현

| 표현 | 설명 | 예 | 의미 |
|---|---|---|---|
[] | 한 개의 문자 | [abc] | a, b, c 중 하나 |
[] | 한 개의 문자 | [^abc] | a, b, c 제외 |
[] | 문자 범위 | [a-zA-Z] | 영문자 |
\d | 숫자 | \d | 0~9 |
\s | 공백 문자 | \s | space, tab |
\w | 문자 + 숫자 | \w | a-zA-Z0-9 |
\. | 점 문자 | \. | . 문자 자체 |
. | 임의의 문자 | . | 모든 문자 |
? | 0 또는 1번 반복 | a? | a가 없거나 1개 |
* | 0번 이상 반복 | a* | a가 0개 이상 |
+ | 1번 이상 반복 | a+ | a가 1개 이상 |
{n} | n번 반복 | a{3} | aaa |
{n,} | n번 이상 반복 | a{3,} | aaa 이상 |
{n,m} | n~m번 반복 | a{2,4} | aa ~ aaaa |
a\|b | OR 조건 | a\|b | a 또는 b |
() | 그룹 | (abc) | abc 그룹 |

---

# 3. 이메일 정규 표현식 예

예를 들어 다음과 같은 이메일이 있다고 가정한다.

```
black@naver.com
```

이메일 형식 검증을 위한 정규 표현식 예

```
\w+@\w+\.\w+(\.\w+)?
```

구성 의미

| 표현 | 의미 |
|---|---|
\w+ | 문자 또는 숫자 1개 이상 |
@ | @ 문자 |
\w+ | 도메인 이름 |
\. | 점 문자 |
\w+ | 도메인 확장자 |
(\.\w+)? | 추가 도메인 (선택) |

---

# 4. Pattern 클래스

자바에서는 `java.util.regex` 패키지의 **Pattern 클래스**를 이용하여  
정규 표현식을 검사할 수 있다.

대표적인 메소드

```
Pattern.matches(정규식, 문자열)
```

| 매개변수 | 설명 |
|---|---|
정규식 | 검증할 패턴 |
문자열 | 검사할 문자열 |

리턴 값

```
boolean
```

- true → 패턴과 일치
- false → 패턴 불일치

---

# 5. Pattern.matches() 사용 예

```java
import java.util.regex.Pattern;

public class RegexExample {

    public static void main(String[] args) {

        String email = "black@naver.com";

        boolean result =
                Pattern.matches("\\w+@\\w+\\.\\w+(\\.\\w+)?", email);

        System.out.println(result);

    }

}
```

출력

```
true
```

---

# 6. 이메일 검증 예제

```java
import java.util.regex.Pattern;

public class EmailValidationExample {

    public static void main(String[] args) {

        String email1 = "test@naver.com";
        String email2 = "test@naver";

        String regex = "\\w+@\\w+\\.\\w+(\\.\\w+)?";

        System.out.println(Pattern.matches(regex, email1));
        System.out.println(Pattern.matches(regex, email2));

    }

}
```

출력

```
true
false
```

---

# 7. 전화번호 검증 예제

```java
import java.util.regex.Pattern;

public class PhoneValidationExample {

    public static void main(String[] args) {

        String phone = "010-1234-5678";

        String regex =
                "010-\\d{4}-\\d{4}";

        boolean result =
                Pattern.matches(regex, phone);

        System.out.println(result);

    }

}
```

출력

```
true
```

---

# 정리

| 기능 | 클래스 |
|---|---|
정규 표현식 검사 | Pattern |
문자열 패턴 정의 | Regex |

즉,

정규 표현식 → 문자열 패턴  
Pattern.matches() → 문자열 검증