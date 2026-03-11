# 리플렉션 (Reflection)

> 작성 일시: 2026-03-11 오후 4:47

자바는 클래스와 인터페이스의 **메타정보(Meta Information)**를 `Class` 객체로 관리한다.

메타정보란 다음과 같은 정보를 의미한다.

- 패키지 정보
- 타입 정보 (클래스 / 인터페이스)
- 멤버 정보
    - 생성자
    - 필드
    - 메소드

이러한 **메타 정보를 프로그램 실행 중에 읽거나 수정하는 기술을 리플렉션(Reflection)**이라고 한다.

리플렉션은 다음과 같은 곳에서 많이 사용된다.

- 프레임워크 (Spring)
- ORM (Hibernate)
- 의존성 주입 (DI)
- 테스트 프레임워크

---

# 1. Class 객체 얻는 방법

리플렉션을 사용하려면 먼저 `Class` 객체를 얻어야 한다.

Class 객체를 얻는 방법은 3가지가 있다.

```java
// 1. 클래스 타입으로 얻는 방법
Class clazz = 클래스이름.class;

// 2. 문자열로 클래스 로드
Class clazz = Class.forName("패키지이름.클래스이름");

// 3. 객체로부터 얻는 방법
Class clazz = 객체참조변수.getClass();
```

---

# 2. Class 객체 얻기 예제

```java
public class ReflectionExample {

    public static void main(String[] args) throws Exception {

        Class clazz1 = String.class;

        Class clazz2 = Class.forName("java.lang.String");

        String str = "Hello";
        Class clazz3 = str.getClass();

        System.out.println(clazz1);
        System.out.println(clazz2);
        System.out.println(clazz3);

    }

}
```

출력 예

```
class java.lang.String
class java.lang.String
class java.lang.String
```

---

# 3. 패키지와 타입 정보 얻기

Class 객체를 이용하면 **패키지 정보와 타입 이름**을 얻을 수 있다.

| 메소드 | 설명 |
|---|---|
Package getPackage() | 패키지 정보 반환 |
String getSimpleName() | 패키지를 제외한 클래스 이름 |
String getName() | 패키지를 포함한 전체 클래스 이름 |

---

# 4. 패키지 정보 예제

```java
public class PackageInfoExample {

    public static void main(String[] args) throws Exception {

        Class clazz = Class.forName("java.util.ArrayList");

        Package pkg = clazz.getPackage();

        System.out.println("패키지: " + pkg.getName());
        System.out.println("클래스 이름: " + clazz.getSimpleName());
        System.out.println("전체 이름: " + clazz.getName());

    }

}
```

출력 예

```
패키지: java.util
클래스 이름: ArrayList
전체 이름: java.util.ArrayList
```

---

# 5. 멤버 정보 얻기

클래스가 가지고 있는 **생성자, 필드, 메소드 정보**도 리플렉션을 통해 확인할 수 있다.

| 메소드 | 설명 |
|---|---|
Constructor[] getDeclaredConstructors() | 생성자 정보 |
Field[] getDeclaredFields() | 필드 정보 |
Method[] getDeclaredMethods() | 메소드 정보 |

각 메소드는 다음 배열을 반환한다.

- Constructor[]
- Field[]
- Method[]

이 클래스들은 모두 다음 패키지에 있다.

```
java.lang.reflect
```

---

# 6. 멤버 정보 조회 예제

```java
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class MemberInfoExample {

    public static void main(String[] args) throws Exception {

        Class clazz = Class.forName("java.lang.String");

        Constructor[] constructors = clazz.getDeclaredConstructors();
        Field[] fields = clazz.getDeclaredFields();
        Method[] methods = clazz.getDeclaredMethods();

        System.out.println("=== Constructors ===");
        for (Constructor c : constructors) {
            System.out.println(c);
        }

        System.out.println("=== Fields ===");
        for (Field f : fields) {
            System.out.println(f);
        }

        System.out.println("=== Methods ===");
        for (Method m : methods) {
            System.out.println(m);
        }

    }

}
```

---

# 7. 리소스 경로 얻기

Class 객체는 **클래스 파일(.class)의 위치 정보를 가지고 있다.**

따라서 해당 경로를 기준으로  
**XML, Properties, 이미지 파일 등 리소스 파일을 읽을 수 있다.**

| 메소드 | 설명 |
|---|---|
URL getResource(String name) | 리소스 파일 URL 반환 |
InputStream getResourceAsStream(String name) | 리소스 파일 InputStream 반환 |

---

# 8. 리소스 파일 읽기 예제

예: `config.properties` 파일을 읽는 경우

```java
import java.io.InputStream;

public class ResourceExample {

    public static void main(String[] args) throws Exception {

        Class clazz = ResourceExample.class;

        InputStream is =
                clazz.getResourceAsStream("config.properties");

        int data;

        while ((data = is.read()) != -1) {
            System.out.print((char) data);
        }

        is.close();

    }

}
```

---

# 정리

| 기능 | 클래스 |
|---|---|
메타 정보 관리 | Class |
생성자 정보 | Constructor |
필드 정보 | Field |
메소드 정보 | Method |

즉,

리플렉션은 **클래스의 구조를 실행 중에 분석하고 사용할 수 있는 기술**이다.

Spring, Hibernate 같은 프레임워크 내부에서 많이 사용된다.