package Class.SystemClass;

public class ExitEx {
    public static void main(String[] args) {
        for(int i = 0; i<10; i++){
            System.out.println(i);
            if(i == 5 ){
                //JVM 프로레스 종료
                System.out.println("프로그램 종료");
                System.exit(0); // 위에 해당 조건이 맞으면 정상 종료
            }
        }
    }
}
