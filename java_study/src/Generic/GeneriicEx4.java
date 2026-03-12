package Generic;

public class GeneriicEx4 {
    public static <T> Box2<T> boxing(T t) {
        Box2<T> box = new Box2<>();
        box.set(t);
        return box;
    }
    public static void main(String[] args) {
        Box2<Integer> box1 = boxing(100);
        int intVal = box1.get();
        System.out.println(intVal);

        Box2<String> box2 = boxing("박스");
        String strVal = box2.get();
        System.out.println(strVal);
    }
}
