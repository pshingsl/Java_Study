package OOP.OOP_Basic_08_interface;

public class Television implements RemoteControl{
    private int volume;

    @Override
    public void turnOff() {
        System.out.println("Tv 전원이 꺼집니다.");
    }

    @Override
    public void turnOn() {
        System.out.println("Tv 전원이 켜집니다.");
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
        System.out.println("현재 Tv 볼륨: " + this.volume);
    }
}
