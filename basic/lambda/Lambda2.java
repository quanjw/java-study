package basic.lambda;

public class Lambda2 {
    public static void main(String[] args) {

        //匿名内部类
        useFlyable(new Flyable() {
            @Override
            public void fly(String s) {
                System.out.println(s);
                System.out.println("22222222");
            }
        });

        //Lambda  有参无返
        useFlyable((String s)->{
            System.out.println(s);
            System.out.println("3333333333333");
        });


    }

    private static void useFlyable(Flyable flyable){
        flyable.fly("11111111");
    }
}
