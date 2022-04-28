package basic.reflect;

public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.Class类中的静态方法forName("全类名")
        Class<?> claz = Class.forName("basic.reflect.Student");
        System.out.println(claz);

        //2.通过class属性来获取

        Class<?> claz2 = Student.class;
        System.out.println(claz2);

        //3.利用对象的getClass方法来获取class对象
        Student student = new Student();
        Class<?> claz3 = student.getClass();
        System.out.println(claz3);

        System.out.println(claz == claz2);
        System.out.println(claz2 == claz3);
    }
}
