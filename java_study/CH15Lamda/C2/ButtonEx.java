package Lamda.C2;

public class ButtonEx {
    public static void main(String[] args) {
        Button onButton = new Button();
        onButton.setClickListener(()-> System.out.println("클릭이 되었습니다."));
        onButton.click();

        // 취소 버튼
        Button cancleButton = new Button();
        cancleButton.setClickListener(() -> System.out.println("클릭을 취소합니다."));
        cancleButton.click();
    }
}
