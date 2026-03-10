# 날짜와 시간 클래스

> 작성 일시: 2026-03-10 오후: 3:10

자바는 컴퓨터의 날짜와 시간을 처리하기 위해 다음과 같은 클래스를 제공한다.

- `java.util` 패키지
    - Date
    - Calendar

- `java.time` 패키지 (Java 8 이후 권장)
    - LocalDate
    - LocalTime
    - LocalDateTime

---

# 1. 주요 날짜 / 시간 클래스

| 클래스 | 설명 |
|---|---|
Date | 날짜 정보를 전달할 때 사용 |
Calendar | 날짜와 시간을 다양한 방식으로 얻을 때 사용 |
LocalDateTime | 날짜와 시간을 계산하거나 조작할 때 사용 |

---

# 2. Date 클래스

`Date` 클래스는 **날짜 정보를 표현하는 객체**이다.  
주로 **객체 간에 날짜 정보를 전달할 때 사용**된다.

Date 클래스에는 여러 생성자가 있지만 대부분 `Deprecated(더 이상 사용되지 않음)` 되었으며 현재는 **Date() 생성자**를 주로 사용한다.

```
Date now = new Date();
```

이 생성자는 **현재 시스템 날짜와 시간을 읽어 Date 객체로 생성**한다.



## Date 예제

```java
import java.util.Date;

public class DateExample {

    public static void main(String[] args) {

        Date now = new Date();

        System.out.println(now);

    }

}
```

출력 예

```
Tue Mar 10 15:00:00 KST 2026
```

하지만 `toString()`은 **영문 형식**으로 출력된다.

---

# 3. 날짜 포맷 변경 (SimpleDateFormat)

원하는 형식으로 날짜를 출력하려면 `SimpleDateFormat` 클래스를 사용해야 한다.



## 예제

```java
import java.util.Date;
import java.text.SimpleDateFormat;

public class DateFormatExample {

    public static void main(String[] args) {

        Date now = new Date();

        SimpleDateFormat sdf =
                new SimpleDateFormat("yyyy년 MM월 dd일 HH:mm:ss");

        String dateStr = sdf.format(now);

        System.out.println(dateStr);

    }

}
```

출력 예

```
2026년 03월 10일 15:10:00
```

---

# 4. Calendar 클래스

`Calendar` 클래스는 **달력을 표현하는 추상 클래스**이다.

날짜 계산 방식은 **지역과 문화마다 다르기 때문에** 구체적인 구현은 **하위 클래스에서 담당**한다.

일반적으로는 직접 객체를 생성하지 않고 `getInstance()` 메소드를 사용한다.

```
Calendar now = Calendar.getInstance();
```

이 메소드는 **현재 시스템 시간대를 기준으로 Calendar 객체를 생성**한다.

---

# 5. Calendar 주요 메소드

| 값 | 설명 |
|---|---|
YEAR | 연도 |
MONTH | 월 |
DATE | 일 |
DAY_OF_WEEK | 요일 |
AM_PM | 오전 / 오후 |
HOUR | 시 |
MINUTE | 분 |
SECOND | 초 |

---

## Calendar 예제

```java
import java.util.Calendar;

public class CalendarExample {

    public static void main(String[] args) {

        Calendar now = Calendar.getInstance();

        int year = now.get(Calendar.YEAR);
        int month = now.get(Calendar.MONTH) + 1;
        int day = now.get(Calendar.DATE);
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);

        System.out.println(year + "년 "
                + month + "월 "
                + day + "일 "
                + hour + "시 "
                + minute + "분 "
                + second + "초");

    }

}
```

---

# 6. LocalDateTime 클래스

`LocalDateTime` 클래스는**날짜와 시간을 계산하고 조작할 때 사용하는 클래스**이다.

Java 8 이후에는 **Date / Calendar보다 LocalDateTime 사용이 권장된다.**

현재 날짜와 시간을 얻는 방법

```
LocalDateTime now = LocalDateTime.now();
```

---

# 7. 날짜와 시간 조작 메소드

| 메소드 | 설명 |
|---|---|
minusYears() | 년 빼기 |
minusMonths() | 월 빼기 |
minusWeeks() | 주 빼기 |
minusDays() | 일 빼기 |
plusYears() | 년 더하기 |
plusMonths() | 월 더하기 |
plusWeeks() | 주 더하기 |
plusDays() | 일 더하기 |
minusHours() | 시간 빼기 |
minusMinutes() | 분 빼기 |
minusSeconds() | 초 빼기 |
minusNanos() | 나노초 빼기 |
plusHours() | 시간 더하기 |
plusMinutes() | 분 더하기 |
plusSeconds() | 초 더하기 |

---

## 날짜 조작 예제

```java
import java.time.LocalDateTime;

public class LocalDateTimeExample {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime nextWeek = now.plusWeeks(1);
        LocalDateTime yesterday = now.minusDays(1);

        System.out.println("현재 시간: " + now);
        System.out.println("일주일 후: " + nextWeek);
        System.out.println("어제: " + yesterday);

    }

}
```

---

# 8. 날짜와 시간 비교

LocalDateTime은 날짜와 시간을 비교하는 메소드도 제공한다.

| 리턴 타입 | 메소드 | 설명 |
|---|---|---|
boolean | isAfter(other) | 이후 날짜인지 |
boolean | isBefore(other) | 이전 날짜인지 |
boolean | isEqual(other) | 동일 날짜인지 |
long | until(other, unit) | 두 날짜의 차이를 반환 |

---

# 9. 특정 날짜 생성

비교를 위해 특정 날짜와 시간으로 LocalDateTime 객체를 얻어야한다.

```
LocalDateTime target =
        LocalDateTime.of(year, month, dayOfMonth, hour, minute, second);
```

---

## 날짜 비교 예제

```java
import java.time.LocalDateTime;

public class DateCompareExample {

    public static void main(String[] args) {

        LocalDateTime now = LocalDateTime.now();

        LocalDateTime target =
                LocalDateTime.of(2026, 12, 25, 0, 0, 0);

        System.out.println("이후 날짜인가? "
                + now.isAfter(target));

        System.out.println("이전 날짜인가? "
                + now.isBefore(target));

    }

}
```

---

# 정리

| 클래스 | 특징 |
|---|---|
Date | 단순 날짜 객체 |
Calendar | 날짜와 시간 계산 |
LocalDateTime | 날짜/시간 조작 및 비교 (권장) |