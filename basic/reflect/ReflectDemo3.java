package basic.reflect;

import java.lang.reflect.Field;

public class ReflectDemo3 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        method1();
        System.out.println("--------------------");
        method2();
        System.out.println("--------------------");
        method3();
        System.out.println("--------------------");
        method4();
    }

    private static void method4() throws ClassNotFoundException, NoSuchFieldException {
        Class<?> claz = Class.forName("basic.reflect.Teacher");

        //返回单个公共成员变量对象
        Field field = claz.getDeclaredField("money");
        System.out.println(field);
    }

    private static void method3() throws ClassNotFoundException, NoSuchFieldException {
        Class<?> claz = Class.forName("basic.reflect.Teacher");

        //返回单个公共成员变量对象
        Field field = claz.getField("name");
        System.out.println(field);
    }

    private static void method2() throws ClassNotFoundException {
        Class<?> claz = Class.forName("basic.reflect.Teacher");

        //getDeclaredFields()：返回所有成员变量对象的数组
        Field[] fields = claz.getDeclaredFields();

        for (Field field:fields){
            System.out.println(field);
        }

    }

    private static void method1() throws ClassNotFoundException {
        Class<?> claz = Class.forName("basic.reflect.Teacher");

        //返回所有公共成员变量对象的数组
        Field[] fields = claz.getFields();

        for (Field field:fields){
            System.out.println(field);
        }

    }
}
