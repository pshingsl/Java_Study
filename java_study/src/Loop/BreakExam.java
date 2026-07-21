package Loop;

public class BreakExam {
    public static void main(String[] args) {
        /*
        * break
        *
        * 정의
        *ㄴ break은 반복문 또는 Switch문을 종료시키는 제어문이다.
        *
        * 왜 사용하는가?
        * ㄴ 반복문을 끝까지 실행할 필요가 없을 때 사용한다.
        * ㄴ 원하는 값을 찾을 때, 특정 조건이 만족되었을때, 무한 반복이 종룔할 떄
        * ㄴ 끝까지 반복하는 것은 비효율적이다.
        *
        * 언제 사용하는가?
        * ㄴ 검색 성공 시
        * ㄴ 사용자의 입력이 종료 조건이 있을떄
        * ㄴ 무한 반복 종료
        *
        * 문법
        * break;
        * 반복문 안에서 사용
        *
        * while(조건) {
        *   if(조건) {
        *       break;
        *   }
        * }
        *
        * 동작 원리
        * ㄴ 반복문 실행 -> break 발견 -> 반복문 종료 -> 다음 코드 실행
        *
        * 주의사항
        * ㄴ 반복문 안에서만 사용 가능
        * ㄴ 가장 가까운 반복문 종료
        * */

        for(int i = 1; i<=5; i++){
            if(i==5){
                break;
            }
            System.out.println(i);
        }
        System.out.println();

        int count = 1;

        while (true) {
            System.out.println(count);
            if(count == 5){
                break;
            }
            count++;
        }
    }
}
