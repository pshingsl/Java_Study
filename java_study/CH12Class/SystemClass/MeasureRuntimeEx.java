package Class.SystemClass;

public class MeasureRuntimeEx {
    public static void main(String[] args) {
        long time1= System.nanoTime();
        int sum = 0;
        for(int i=1; i<=100000; i++){
            sum+=i;
        }
        long time2 = System.nanoTime();
        System.out.println("1~100000까지의 총합: " + sum);
        System.out.println("계산에" + (time2 - time1) + "나노초가 소요됨");
    }
}
