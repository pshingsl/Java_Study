package NestedClass.C7;

public class HomeEx {
    public static void main(String[] args) {
        Home home = new Home();
        home.use1();
        home.use2();
        home.use3(new RemoteControl() {
            @Override
            public void turnOn() {
                System.out.println("히터를 킵니다.");
            }

            @Override
            public void turnOff() {
                System.out.println("히터를 끕니다.");
            }
        });
    }
}
