package NestedClass.C6;

public class ButtonEx {
    public static void main(String[] args) {
        // Ok 버튼 객체 생성
        Button okBtn = new Button();

        // Ok 버튼 클릭 입벤트 처리할 CLickListener 구현 클래스(로컬 클래스)
        class OkListener implements Button.ClickListener {
            @Override
            public void onClick() {
                System.out.println("OK");
            }
        }

        // Ok 버튼 객체에 ClickListener 구현 객체 주입
        okBtn.setClickListener(new OkListener());

        // 실행
        okBtn.click();

        // Cancle 버튼 객체 생성
        Button cancleBtn = new Button();

        // Cancle 버튼 클릭 입벤트 처리할 CLickListener 구현 클래스(로컬 클래스)
        class CancleListener implements Button.ClickListener {
            @Override
            public void onClick() {
                System.out.println("CANCLE");
            }
        }

        // Cancle 버튼 객체에 ClickListener 구현 객체 주입
        cancleBtn.setClickListener(new CancleListener());

        // 실행
        cancleBtn.click();
    }
}
