package basic.reflect;

import java.lang.reflect.Field;

public class ReflectDemo4 {
    public static void main(String[] args) throws NoSuchFieldException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        method1();
        method2();
    }

    private static void method1() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {

        Class<?> claz = Class.forName("basic.reflect.Teacher");

        //返回单个公共成员变量对象
        Field field = claz.getField("name");

        Teacher teacher = (Teacher) claz.newInstance();
        field.set(teacher,"zsss");
        System.out.println(teacher);
    }

    private static void method2() throws ClassNotFoundException, NoSuchFieldException, InstantiationException, IllegalAccessException {

        Class<?> claz = Class.forName("basic.reflect.Teacher");

        //返回单个公共成员变量对象
        Field field = claz.getDeclaredField("money");

        field.setAccessible(true);

        Teacher teacher = (Teacher) claz.newInstance();
        field.setInt(teacher,500);
        System.out.println(teacher);
    }
}
