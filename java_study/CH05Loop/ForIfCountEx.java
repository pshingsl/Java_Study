package Loop;

public class ForIfCountEx {
    public static void main(String[] args) {
        int cnt = 0;

        for(int i =1; i<=100; i++){
            if(i%2==0)
                    cnt++;
        }

        System.out.println("1~100까지 짝수의 총 개수: " + cnt);
    }
}
