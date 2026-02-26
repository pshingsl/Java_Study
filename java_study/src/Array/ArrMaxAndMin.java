package Array;

public class ArrMaxAndMin {
    public static void main(String[] args) {
        int[] score = {10, 20, 30, 40, 50};

        // 기준점 세우기: score[0]이 가장크고 가장 작다고 가정하기
        int max = score[0];
        int min = score[0];

        // 기준점 score[0]으로 잡았기 때문에 두번째 인덱스1부터 마지막까지 비교
        // 1부터 시작인 이유는 score[0]은 이미 자기 자신과 비교할 필요 없기 때문에
        for(int i=1; i<score.length; i++) {
            if(score[i] > max) {
                max = score[i];
            } else if(score[i] < min){
                min = score[i];
            }
        }

        System.out.println("최대값: " + max);
        System.out.println("최소값: " + min);
    }
}
