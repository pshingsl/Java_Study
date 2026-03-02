package OOP.OOP_Basic_05_encapsulation;

public class Bike {
    private int speed;
    private boolean stop;

    // getter는 내부의 멤버 변수에 저장된 값을 외부로 리턴
    // 매개변수는 없고, 리턴값만 메서드로 정의
    public int getSpeed() {
        return speed;
    }

    // setter는 외부로부터 데이터를 전달받아 멤버변수에 저장
    // 매개변수만 있고, 리턴값은 없는 메서드로 정의
    public void setSpeed(int speed) {
        if(speed < 0){
            System.out.println("속력 0이 될 수 없습니다.");
            this.speed = 0;
            return;
        }else {
            this.speed = speed;
            return;
        }
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
        if(stop){
            this.speed = 0;
        }
    }
}
