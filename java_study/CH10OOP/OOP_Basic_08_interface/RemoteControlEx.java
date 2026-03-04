package OOP.OOP_Basic_08_interface;

public class RemoteControlEx {
    public static void main(String[] args) {
        // 인터페이스 변수 텔리비전 선언
        RemoteControl t1 = new Television();
        t1.turnOn();
        t1.setVolume(11);
        t1.turnOff();
        RemoteControl.changeBattery();
        System.out.println();

        // 인터페이스 변수 폰 선언
        RemoteControl r1 = new Phone();
        r1.turnOn();
        r1.setVolume(7);
        r1.setMute(true);
        r1.turnOff();
        System.out.println();
        System.out.println("현재 볼륨: "  + r1.getVolume());
    }
}
