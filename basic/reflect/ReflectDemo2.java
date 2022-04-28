package basic.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectDemo2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        method1();
        System.out.println("-------------------");
        method2();
        System.out.println("-------------------");
        method3();
        System.out.println("-------------------");
        method4();
    }

    private static void method1() throws ClassNotFoundException {
        Class<?> claz = Class.forName("basic.reflect.Student");

        //返回所有公共构造方法对象的数组
        Constructor[] constructors = claz.getConstructors();
        for (Constructor constructor:constructors) {
            System.out.println(constructor);
        }

    }

    private static void method2() throws ClassNotFoundException {
        Class<?> claz = Class.forName("basic.reflect.Student");

        //返回所有构造方法对象的数组
        Constructor[] constructors = claz.getDeclaredConstructors();
        for (Constructor constructor:constructors) {
            System.out.println(constructor);
        }

    }

    private static void method3() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> claz = Class.forName("basic.reflect.Student");

        //返回单个公共构造方法对象
        Constructor constructor2 = claz.getConstructor(String.class, int.class);
        System.out.println(constructor2);

        Student student = (Student) constructor2.newInstance("ls",18);
        System.out.println(student);


    }

    private static void method4() throws NoSuchMethodException, ClassNotFoundException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> claz = Class.forName("basic.reflect.Student");

        //返回单个构造方法对象
        Constructor constructor2 = claz.getDeclaredConstructor(String.class);
        System.out.println(constructor2);

        //被private修饰的成员,不能直接使用的
        //如果用反射强行获取并使用,需要临时取消访问检查
        constructor2.setAccessible(true);
        Student student = (Student) constructor2.newInstance("zs");
        System.out.println(student);
    }

}
