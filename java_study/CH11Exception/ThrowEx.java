package Exception;

// 예외 떠넘기기
public class ThrowEx{
    public static void findClass() throws ClassNotFoundException {
        Class.forName("java.lang.String2");
    }
    public static void main(String[] args) throws ClassNotFoundException {
//        try {
//            findClass();
//        } catch (ClassNotFoundException e) {
//            System.out.println("클래스가 없습니다.");
//        }

        // 만약 위에 있는 try-catch문을 메인에서 사용안할거면 main()메서드에 hrows ClassNotFoundException 추가하기
        findClass();
    }
}
