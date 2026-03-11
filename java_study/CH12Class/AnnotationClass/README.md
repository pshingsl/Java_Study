# 어노테이션 (Annotation)

> 작성 일시: 2026-03-11 오후 6:20

코드에서 `@` 기호로 작성되는 요소를 **어노테이션(Annotation)** 이라고 한다.

어노테이션은 **클래스나 인터페이스가 컴파일되거나 실행될 때 어떻게 처리할 것인지에 대한 설정 정보(metadata)**를 제공한다.

어노테이션은 다음과 같은 세 가지 용도로 사용된다.

1. 컴파일 시 사용하는 정보 전달
2. 빌드 도구가 코드를 자동으로 생성할 때 사용하는 정보 전달
3. 실행 시 특정 기능을 처리할 때 사용하는 정보 전달

대표적인 예

```
@Override
```

`@Override`는 **컴파일러에게 메소드가 정상적으로 재정의 되었는지 검사하도록 지시**한다.

---

# 1. 어노테이션 타입 정의

어노테이션도 하나의 **타입(type)** 이기 때문에 사용하기 전에 정의해야 한다.

어노테이션을 정의하는 방법은 인터페이스를 정의하는 것과 같다.

어노테이션 정의 방법

```java
public @interface AnnotationName {
}
```

이렇게 정의한 어노테이션은 다음과 같이 사용할 수 있다.

```java
@AnnotationName
```

---

# 2. 어노테이션 속성 정의

어노테이션은 **속성(Property)을** 가질 수 있다.

속성의 기본값은 `default` 키워드로 지정할 수 있다.

속성 정의 형태

```
타입 이름();
```

예

```java
public @interface AnnotationName {

    String prop1();
    int prop2() default 1;

}
```

설명

| 속성 | 설명 |
|---|---|
prop1 | 기본값 없음 (반드시 값 지정) |
prop2 | 기본값 존재 |

---

# 3. 어노테이션 사용 예

```java
@AnnotationName(prop1 = "값")
```

또는

```java
@AnnotationName(prop1 = "값", prop2 = 3)
```

---

# 4. value 속성

어노테이션에는 **특별한 속성 이름인 value를** 사용할 수 있다.

```java
public @interface AnnotationName {

    String value();
    int prop2() default 1;

}
```

이 경우 어노테이션을 사용할 때 **value 속성 이름을 생략할 수 있다.**

```java
@AnnotationName("값")
```

하지만 다른 속성과 함께 사용할 경우에는 반드시 `value`를 명시해야 한다.

```java
@AnnotationName(value = "값", prop2 = 3)
```

---

# 5. 어노테이션 적용 대상

어노테이션을 정의할 때 **어떤 요소에 적용할 것인지 지정해야 한다.**

적용 대상은 `ElementType` 열거형 상수로 정의되어 있다.

| ElementType | 적용 대상 |
|---|---|
TYPE | 클래스, 인터페이스, 열거 타입 |
ANNOTATION_TYPE | 어노테이션 |
FIELD | 필드 |
CONSTRUCTOR | 생성자 |
METHOD | 메소드 |
LOCAL_VARIABLE | 로컬 변수 |
PACKAGE | 패키지 |

적용 대상 지정에는 `@Target` 어노테이션을 사용한다.

`@Target`의 기본 속성 `value`는 `ElementType` 배열을 가진다.

이는 **여러 적용 대상을 동시에 지정하기 위해서이다.**

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
public @interface AnnotationName {
}
```

## 어노테이션 적용 예

```java
@AnnotationName -> TYPE(클래스)에 적용
public class className{
    @AnnotationName -> 필드에 적용
    private String fieldName;

    @AnnotationName -> @Target에 생성자가 없으므로 생성자적용 안됨
    public ClassName() {}

    @AnnotationName -> 메소드에 적용
    publc void methodName(){}
```

---

# 6. 어노테이션 유지 정책

어노테이션을 정의할 때 **어느 시점까지 유지할 것인지 지정해야 한다.**

이를 **Retention Policy**라고 한다.

| RetentionPolicy | 적용 시점 | 제거 시점 |
|---|---|---|
SOURCE | 컴파일 시 적용 | 컴파일 후 제거 |
CLASS | 클래스 로딩 시 적용 | JVM 로딩 후 제거 |
RUNTIME | 실행 시 적용 | 프로그램 실행 동안 유지 |

유지 정책을 지정할 때는 `@Retention` 어노테이션을 사용한다.

## @Retention 사용 예

```java
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface AnnotationName {
}
```

`RUNTIME`으로 설정하면 **실행 중에도 리플렉션을 통해 어노테이션 정보를 읽을 수 있다.**

---

# 7. 어노테이션 + 리플렉션 예제

```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@interface PrintAnnotation {
    String value() default "-";
}

class AnnotationService {

    @PrintAnnotation("*")
    public void method1() {}

    @PrintAnnotation("#")
    public void method2() {}

}

public class AnnotationReflectionExample {

    public static void main(String[] args) {

        Method[] methods = AnnotationService.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(PrintAnnotation.class)) {

                PrintAnnotation annotation =
                        method.getAnnotation(PrintAnnotation.class);

                System.out.println("method: " + method.getName());
                System.out.println("value: " + annotation.value());

            }

        }

    }

}
```

---

# 8. 어노테이션 설정 정보 이용

어노테이션은 **실제 동작을 수행하는 코드가 아니라 설정 정보(metadata)** 이다.

따라서 어노테이션에 담긴 설정 정보를 **애플리케이션 또는 프레임워크가 읽어 처리해야 한다.**

자바에서는 보통 **Reflection을 이용하여 어노테이션 정보를 읽는다.**

## 어노테이션 정보 읽기 메소드

`Class`, `Method`, `Field` 객체는 어노테이션 정보를 읽기 위한 메소드를 제공한다.

| 리턴 타입 | 메소드 | 설명                                   |
|---|---|--------------------------------------|
boolean | isAnnotationPresent(Class annotationClass) | 특정 어노테이션이 적용되어 있는지 확인                |
Annotation | getAnnotation(Class annotationClass) | 특정 어노테이션 객체 반환 객체 존재시 반환, 없으면 null반환 |
Annotation[] | getAnnotations() | 적용된 모든 어노테이션 반환                      |

---

## 어노테이션 정의 예

```java
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@interface PrintAnnotation {

    String value() default "-";
    int number() default 1;

}
```

| 속성 | 설명 |
|---|---|
value | 출력할 문자열 |
number | 반복 출력 횟수 |

---

## 어노테이션 적용 클래스

```java
class AnnotationService {

    @PrintAnnotation(value = "*", number = 5)
    public void method1() {
        System.out.println("method1 실행");
    }

    @PrintAnnotation(value = "#", number = 3)
    public void method2() {
        System.out.println("method2 실행");
    }

}
```

---

## 어노테이션 정보 읽기 예제

```java
import java.lang.reflect.Method;

public class AnnotationReaderExample {

    public static void main(String[] args) {

        Method[] methods = AnnotationService.class.getDeclaredMethods();

        for (Method method : methods) {

            if (method.isAnnotationPresent(PrintAnnotation.class)) {

                PrintAnnotation annotation =
                        method.getAnnotation(PrintAnnotation.class);

                String value = annotation.value();
                int number = annotation.number();

                for (int i = 0; i < number; i++) {
                    System.out.print(value);
                }

                System.out.println();

                try {
                    method.invoke(new AnnotationService());
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

        }

    }

}
```

---

## 실행 결과

```
*****
method1 실행
###
method2 실행
```

설명

- `method1` → `*` 5번 출력
- `method2` → `#` 3번 출력

이처럼 **어노테이션의 설정 정보를 읽어 프로그램 동작을 제어할 수 있다.**

---

# 정리

| 개념 | 설명 |
|---|---|
Annotation | 코드에 추가하는 설정 정보 |
@Target | 적용 대상 지정 |
@Retention | 유지 정책 지정 |
ElementType | 적용 가능한 요소 |
RetentionPolicy | 유지 범위 지정 |
Reflection | 어노테이션 정보를 읽는 기술 |
isAnnotationPresent() | 어노테이션 존재 확인 |
getAnnotation() | 어노테이션 객체 반환 |
getAnnotations() | 모든 어노테이션 반환 |

어노테이션은 **코드 자체의 동작을 변경하는 것이 아니라 설정 정보를 제공하는 역할**을 하며  
실제 동작은 **프레임워크나 프로그램이 해당 정보를 읽어 처리한다.**