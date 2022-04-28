package basic.myenum;

public class EnumDemo {
    public static void main(String[] args) {
        String springName = Season.SPRING.name();
        System.out.println(springName);

        int index1 = Season.SPRING.ordinal();
        int index2 = Season.SUMMER.ordinal();
        int index3 = Season.AUTUMN.ordinal();
        int index4 = Season.WINTER.ordinal();
        System.out.println(index1);
        System.out.println(index2);
        System.out.println(index3);
        System.out.println(index4);

        String s = Season.SPRING.toString();
        System.out.println(s);

        Season spring = Enum.valueOf(Season.class, "SPRING");
        System.out.println(spring);
        System.out.println(Season.SPRING == spring);

        Season[] values = Season.values();
        for (Season value : values) {
            System.out.println(value);
        }
    }
}
