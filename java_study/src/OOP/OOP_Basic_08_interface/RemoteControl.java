package OOP.OOP_Basic_08_interface;

public interface RemoteControl {
    // 상숙 필드
    public static final int MAX_VOLUME = 10;
    int MIN_VOLUME = 0; // public static final 생략 가능

    // 추상 메소드
    public void turnOn();
    public void turnOff();
    public void setVolume(int volume);
    int getVolume();
    
    // 디폴트 인스턴스 메서드
    default void setMute(boolean mute){
            // 1. if(mute)는 if(mute == true)와 같은 뜻!
            // 자바 약속: 괄호 안의 값이 true면 무조건 첫 번째 { } 블록을 실행함
        if(mute){
            System.out.println("무음");
            setVolume(MIN_VOLUME);
        }else{
            // 2. 외부에서 false를 던져주면 else 블록을 실행함
            System.out.println("무음 해제");
        }
    }
    
    static void changeBattery(){
        System.out.println("리모컨을 충전합니다");
    }
}
