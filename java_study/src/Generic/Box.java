package Generic;

public class Box<T> {
    // 제네릭 타입 필드
    public T content;


    public boolean compare(Box<T> other) {
        boolean result = content.equals(other.content);
        return result;
    }

}
