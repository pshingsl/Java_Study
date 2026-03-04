package OOP.OOP_Basic_08_interface;

public class Phone implements RemoteControl{
    private int volume;

    @Override
    public void turnOn() {
        System.out.println("휴대폰 전원을 킵니다.");
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public void setVolume(int volume) {
        if(volume>RemoteControl.MAX_VOLUME){
            this.volume = volume;
        }else if(volume < RemoteControl.MIN_VOLUME){
            this.volume = volume;
        }else{
            this.volume = volume;
        }
        System.out.println("현재 휴대폰 볼륨: " + this.volume);
    }

    @Override
    public void turnOff() {
        System.out.println("휴대폰 전원을 끕니다.");
    }
}
