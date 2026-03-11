# 형식(Format) 클래스

> 작성 일시: 2026-03-11 오후 2:58

Format 클래스는 **숫자 또는 날짜를 원하는 형식의 문자열로 변환하는 기능**을 제공한다.

Format 클래스는 `java.text` 패키지에 포함되어 있으며 대표적인 클래스는 다음과 같다.

---

# 1. 주요 Format 클래스

| Format 클래스 | 설명 |
|---|---|
DecimalFormat | 숫자를 형식화된 문자열로 변환 |
SimpleDateFormat | 날짜를 형식화된 문자열로 변환 |

---

# 2. DecimalFormat

`DecimalFormat` 클래스는 **숫자를 특정 패턴의 문자열 형식으로 변환하는 클래스**이다.

패턴 문자열을 이용해 숫자의 출력 형식을 지정할 수 있다.

## DecimalFormat 패턴 기호

| 기호 | 의미 | 패턴 예 | 1234567.89 → 변환 결과 |
|---|---|---|---|
0 | 10진수 (빈자리를 0으로 채움) | 00000000.000 | 01234567.890 |
# | 10진수 (빈자리는 채우지 않음) | ########.### | 1234567.89 |
. | 소수점 | #.0 | 1234567.9 |
- | 음수 기호 | -#,### | -1,234 |
, | 단위 구분 | #,### | 1,234,567 |
E | 지수 표현 | 0.###E0 | 1.235E6 |
; | 양수/음수 패턴 구분 | #,###;-#,### | -1,234,567 |
% | 백분율 표시 | #.#% | 123456789% |
\u00A4 | 통화 기호 | \u00A4 #,### | ₩ 1,234,567 |

---

# 4. DecimalFormat 사용 방법

패턴을 지정하여 `DecimalFormat` 객체를 생성한 후  
`format()` 메소드를 사용하면 된다.

```
DecimalFormat df = new DecimalFormat("#,###.0");
String result = df.format(1234567.89);
```

결과

```
1,234,567.9
```


### DecimalFormat 예제

```java
import java.text.DecimalFormat;

public class DecimalFormatExample {

    public static void main(String[] args) {

        double num = 1234567.89;

        DecimalFormat df1 = new DecimalFormat("#,###.0");
        DecimalFormat df2 = new DecimalFormat("00000000.000");
        DecimalFormat df3 = new DecimalFormat("#.##E0");

        System.out.println(df1.format(num));
        System.out.println(df2.format(num));
        System.out.println(df3.format(num));

    }

}
```

출력 예

```
1,234,567.9
01234567.890
1.23E6
```

---

# 5. SimpleDateFormat

`SimpleDateFormat` 클래스는 **날짜를 원하는 문자열 형식으로 변환하는 클래스**이다.

날짜 패턴 문자를 이용해 다양한 형태의 날짜 표현이 가능하다.



## SimpleDateFormat 패턴 문자

| 패턴 문자 | 의미 | 예 |
|---|---|---|
y | 년 | 2026 |
M | 월 | 03 |
d | 일 | 10 |
D | 연 기준 날짜 (1~365) | 69 |
E | 요일 | Tue |
a | 오전 / 오후 | PM |
w | 연 기준 주 | 11 |
W | 월 기준 주 | 2 |
H | 24시간 기준 시 | 15 |
h | 12시간 기준 시 | 3 |
K | 0~11 시간 | 3 |
k | 1~24 시간 | 15 |
m | 분 | 30 |
s | 초 | 45 |
S | 밀리초 | 123 |



## SimpleDateFormat 사용 방법

```
SimpleDateFormat sdf =
        new SimpleDateFormat("yyyy년 MM월 dd일");

String strDate = sdf.format(new Date());
```


### SimpleDateFormat 예제

```java
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormatExample {

    public static void main(String[] args) {

        Date now = new Date();

        SimpleDateFormat sdf1 =
                new SimpleDateFormat("yyyy-MM-dd");

        SimpleDateFormat sdf2 =
                new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");

        SimpleDateFormat sdf3 =
                new SimpleDateFormat("yyyy/MM/dd E요일");

        System.out.println(sdf1.format(now));
        System.out.println(sdf2.format(now));
        System.out.println(sdf3.format(now));

    }

}
```

출력 예

```
2026-03-10
2026년 03월 10일 15:30:45
2026/03/10 Tue요일
```

---

# 정리

| 클래스 | 역할 |
|---|---|
DecimalFormat | 숫자 형식 변환 |
SimpleDateFormat | 날짜 형식 변환 |

즉,

- 숫자 formatting → `DecimalFormat`
- 날짜 formatting → `SimpleDateFormat`