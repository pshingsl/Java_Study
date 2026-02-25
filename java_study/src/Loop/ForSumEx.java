package Loop;

public class ForSumEx {
    public static void main(String[] args) {
        int sum = 0;
        for(int i = 1; i<=100; i++){
            sum +=i;
        }

        System.out.println("1~100까지 총합: "+sum);
    }
}
