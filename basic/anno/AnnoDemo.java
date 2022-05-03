package basic.anno;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class AnnoDemo {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, InvocationTargetException {
        Class  clazz = Class.forName("basic.anno.UseTest");

        UseTest useTest = (UseTest) clazz.newInstance();

        Method[] methods = clazz.getDeclaredMethods();

        for (Method method :methods){
            if (method.isAnnotationPresent(Test.class)){
                method.invoke(useTest);
            }
        }
    }
}
