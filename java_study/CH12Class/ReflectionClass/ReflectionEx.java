package Class.ReflectionClass;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionEx {
    public static void main(String[] args) {
        Class clazz = Car.class;
        System.out.println("생성자 정보");
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for(Constructor constructor : constructors){
            System.out.print(constructor.getName() + "(" );
            Class[] parameters = constructor.getParameterTypes();
            printParameter(parameters);
            System.out.println(")");
        }
        System.out.println();

        System.out.println("필드 정보");
        Field[] fields = clazz.getDeclaredFields();
        for(Field field : fields){
            System.out.println(field.getType().getName() + " " + field.getName());
        }
        System.out.println();

        System.out.println("메소드 정보");
        Method[] methods = clazz.getDeclaredMethods();
        for(Method method : methods){
            System.out.print(method.getName() + "(");
            Class[] parmeters = method.getParameterTypes();
            printParameter(parmeters);
            System.out.println(")");
        }
    }

    private static void printParameter(Class[] parameters){
        for(int i = 0; i<parameters.length; i++){
            System.out.print(parameters[i].getName());
            if(i<(parameters.length-1)){
                System.out.print(", ");
            }
        }
    }
}
