package OOP.OOP_Basic_08_interface;

public class Bus implements Vehicle{
    @Override
    public void run() {
        System.out.println("버스가 달립니다");
    }
}
