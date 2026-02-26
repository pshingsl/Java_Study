package Array;

public class MultyArr {
    public static void main(String[] args) {
        int[][] aptArr = {
                {101, 102, 103},
                {201, 202, 203},
                {301, 302, 303},
                {401, 402, 403}
        };

        for(int i = 0; i < aptArr.length; i++){
            for(int j = 0; j< aptArr[i].length; j++){
                System.out.println("아파트 층수: "+aptArr[i][j] + " ");
            }
        }
    }
}
