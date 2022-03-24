package basic.lambda;

public class Lambda3 {
    public static void main(String[] args) {

        //匿名内部类
        useAddable(new Addable() {
            @Override
            public int add(int x, int y) {
                return x+y;
            }
        });

        //Lambda 有参有返回
        useAddable((int x,int y)->{
            return x+y;
        });


    }

    private static void useAddable(Addable addable){
        int sum = addable.add(10,20);
        System.out.println(sum);
    }
}
