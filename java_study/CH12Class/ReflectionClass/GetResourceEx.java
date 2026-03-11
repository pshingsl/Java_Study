package Class.ReflectionClass;

public class GetResourceEx {
    public static void main(String[] args) {
        Class clazz = Car.class;

        try{
            String photo1Path =  clazz.getResource("photo1.jpg").getPath();
            System.out.println(photo1Path);
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }


    }
}
