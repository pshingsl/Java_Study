package Array;

public class ArrAvg {
    public static void main(String[] args) {
        int sum = 0;
        double avg = 0;

        int[] score = {10, 20, 30, 40, 50};

        for(int i=0; i<score.length; i++) {
            sum += score[i];
        }
        avg = sum / (double)score.length;

        System.out.println("총점: " + sum);
        System.out.println("평균: " + avg);
    }
}
