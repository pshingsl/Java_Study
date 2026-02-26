package Array;

public class ArrShuffle {
    public static void main(String[] args) {
        int[] score = new int[10];

        for (int i = 0; i < score.length; i++) {
            score[i] = i;
            System.out.print(score[i] + " "); // 0 1 2 3 4 5 6 7 8 9
        }
        System.out.println();

        for (int i = 0; i < 100; i++) {
            int n = (int) (Math.random() * 10); // 난수 10개를 얻음(0~9)
            int tmp = score[0];
            score[0] = score[n];
            score[n] = tmp;
        }

        for (int i = 0; i < score.length; i++)
            System.out.print(score[i] + " ");
    }
}
