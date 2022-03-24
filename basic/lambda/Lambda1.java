package basic.lambda;

//实现类
class EatableImpl implements Eatable {
    @java.lang.Override
    public void eat() {
        System.out.println("111111111");
    }
}

//测试类
public class Lambda1 {
    public static void main(String[] args) {

        //在主方法中调用
        Eatable e = new EatableImpl();
        useEatable(e);

        //匿名内部类
        useEatable(new Eatable() {
            @Override
            public void eat() {
                System.out.println("22222222");
            }
        });

        //Lambda表达式 无参无返
        useEatable(()->{
            System.out.println("33333333333333");
        });
    }

    private static void useEatable(Eatable e){
        e.eat();
    }




}
