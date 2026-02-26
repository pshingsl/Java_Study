package Array;

public class ArrayEx {
    public static void main(String[] args) {
        // 배열 변수 선언 및 초기화
        String[] season = {"Spring", "Summer", "Fall", "Winter"};

        //배열의 항목 읽기(인덱스 접근)
        System.out.println("season[0] : " + season[0]);
        System.out.println("season[1] : " + season[1]);
        System.out.println("season[2] : " + season[2]);
        System.out.println("season[3] : " + season[3]);
        System.out.println();

        // 반복문으로 배열을 순차적으로 순회에 값을 넣어주는 법
        for(int i = 0; i < season.length; i++){
            System.out.print(season[i] + " ");
        }

        // 인덱스 1번 항목 값 변경
        season[1] = "여름";
        System.out.println("season[1] : " + season[1]);
        System.out.println();

        // 향상된 for문으로 출력 가능
        for (String element : season){
            System.out.print(element + " ");
        }
    }
}
