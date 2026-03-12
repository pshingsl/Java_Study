package Generic;

public class GenericEx {
    public static void main(String[] args) {
        Box<String> box = new Box<String>();
        box.content = "박스1";
        String str = box.content;
        System.out.println(str);

        Box<Integer> box2 = new Box<>();
        box2.content = 2;
        int val = box2.content;
        System.out.println(val);

        Box box3 = new Box(); // 제네릭 타입으로 선언 안했지만 오브젝트 클래스 타입으로 정의함
        box3.content = 123;
        int val2 = (int)box3.content; // 따라서 형변환 해줘야함 지금은 정수로 하고싶어 알고 있지만 추후에 어떤걸 쓸지 정해야한다.
        System.out.println(val2);

        Box<Integer> box4 = new Box<>();
        box4.content = 2;
        int val3 = box4.content;
        System.out.println(val3);

        boolean result = box2.compare(box3);
        System.out.println("result: " + result);

        boolean result2 = box2.compare(box4);
        System.out.println("result2: " + result2);

    }

}
