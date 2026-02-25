package Loop;

public class WhileSumEx {
    public static void main(String[] args) {
        int sum = 0;

        int i = 1;

        while (i<101){
            sum += i;
            i++;
        }
        System.out.println("총합:" +  sum);
    }
}
