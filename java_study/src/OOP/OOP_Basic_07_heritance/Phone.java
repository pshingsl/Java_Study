package OOP.OOP_Basic_07_heritance;

public class Phone {
    // 필드 선언
    public String model;
    public String color;

    // 메서드 선언
    public void bell() {
        System.out.println("벨이 울립니다.");
    }

    public void sendVoice(String msg) {
        System.out.println("자기: " + msg);
    }

    public void receiveVoice(String msg) {
        System.out.println("상대방: " + msg);
    }

    public void hangup() {
        System.out.println("전화를 끊습니다");
    }
}
