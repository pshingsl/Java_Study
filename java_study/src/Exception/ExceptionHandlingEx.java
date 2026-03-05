package Exception;

public class ExceptionHandlingEx {
    public static void printLength(String data){
        try {
            int result = data.length();
            System.out.println("문자수 :" + result);
        }catch (NullPointerException e){
            System.out.println(e.getMessage()); // getMessage(): 예외 메세지 반환
          //  e.printStackTrace();                // printStackTrace(): 콘솔에 호출스택을 출력 -> 예외 확인할떄 사용
        }finally {
            System.out.println("[마무리 실행]\n");
        }

    }
    public static void main(String[] args) {
        System.out.println("[프로그램 시작]\n");  // 1

        printLength("이것은 예외 실습 중입니다."); // 2호출 안에 try-catch 검사끝나면 바로 아래 함수 호출 시작
        printLength(null); // 3. 시작

        System.out.println("[프로그램 종료]"); // 4시작
    }
}
