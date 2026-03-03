package OOP.OOP_Basic_07_heritance;

public class SmartPhoneEx {
    public static void main(String[] args) {
        //SmartPhone 객체 생성
        SmartPhone s1 = new SmartPhone("갤럭시", "흰색");
        
        // Phone으로부터 상속 받은 필드 읽기
        System.out.println("모델: " + s1.model);
        System.out.println("색상: " + s1.color);

        // SmartPhone의 필드 읽기
        System.out.println("와이파이 상태: " + s1.wifi);

        // Phone으로부터 상속 받은 메소드 호출
        s1.bell();
        s1.sendVoice("여보세요");
        s1.receiveVoice("안녕하십니까 a입니다");
        s1.sendVoice("안녕하세요.");
        s1.hangup();

        // SmartPhone의 메소드 호출
        s1.setWifi(true);
        s1.internet();
    }
}
