package Exception;

// 사용자 예외 정의하기
// 개발자는 예외가 발생날때 일반예외, 실행예외 둘 중 어떤게 낲지 에상하고 정의하기
// 일반예외는 Exception, 실행예외는 RuntimeException사용
public class InsufficientException extends Exception {
    public InsufficientException() {}
    public InsufficientException(String message) {
        super(message);
    }
}
