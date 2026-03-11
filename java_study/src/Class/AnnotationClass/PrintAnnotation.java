package Class.AnnotationClass;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD}) // 적용대상 메소드
@Retention(RetentionPolicy.RUNTIME) // 실핼할 때 적용
public @interface PrintAnnotation {
    String value() default "-";
    int number() default 15;
}
